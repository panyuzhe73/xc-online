package com.xuecheng.media.api;

import io.minio.*;


import io.minio.messages.DeleteError;
import io.minio.messages.DeleteObject;
import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 * 把本地的视频分片，把本地的碎片上传到minio，把minio的碎文件合并成完整文件
 */
@RestController
public class RemoteVideoController {

   @Autowired
   private MinioClient minioClient;

    @GetMapping("/minio/fileCut")
    public String fileCut() throws IOException {
        //要分片的本地文件
        File sourceFile = new File("D:\\BaiduNetdiskDownload\\第1章 1.1 导入角色.mp4");
        //分片后的文件存放的路径
        String chunkFilePath = "D:\\BaiduNetdiskDownload\\fenkuai\\minio\\";
        File chunkFile = new File(chunkFilePath);

        if(!chunkFile.exists()){
            chunkFile.mkdirs();
        }

        //定义每块的大小
        //minio的默认方法，分块的大小最小为5M
        int chunkSize = 1024 * 1024 * 5;
        //定义分块数量
        int chunkNum = (int) Math.ceil(sourceFile.length() * 1.0 / chunkSize);

        //定义缓冲区大小
        byte[] b = new byte[1024];
        //创建读源文件流
        RandomAccessFile raf_read = new RandomAccessFile(sourceFile, "r");

        for (int i = 0; i < chunkNum; i++) {
            File file = new File(chunkFilePath + i);
            if(file.exists()){
                file.delete();
            }
            boolean mkdirs = file.createNewFile();
            if(mkdirs){
                //创建写目标文件流
                RandomAccessFile raf_write = new RandomAccessFile(file, "rw");
                int len = -1;
                while ((len = raf_read.read(b))!=-1){
                    raf_write.write(b,0,len);

                    if(file.length() >= chunkSize){
                        break;
                    }
                }
                raf_write.close();
                System.out.println("分块完成"+i);
            }

        }
        raf_read.close();
        return "完成分块，请前往"+chunkFilePath+"文件夹查看";

    }

    /***
     * 将本地的碎文件上传到minio
     * @return
     * @throws IOException
     */
    @GetMapping("/minio/fileUploadMinio")
    public void fileUploadMinio() {

//        //碎文件的目录
//        File chunkPath = new File("D:\\BaiduNetdiskDownload\\fenkuai\\minio\\");
//        //分块文件
//        File[] files = chunkPath.listFiles();
//        //将文件上传到minio
//        for (int i = 0; i < files.length; i++) {
//            try {
//                //上传文件
//                UploadObjectArgs uploadObjectArgs = UploadObjectArgs.builder().bucket("testbucket").object("chunk/"+i).filename(files[i].getAbsolutePath()).build();
//                minioClient.uploadObject(uploadObjectArgs);
//                System.out.println("上传分块成功"+i);
//                //桶是否存在，如果不存在则创建名为testbucket的桶，每个单词都必须是小写，不然桶会创建失败
//
//            }
//            catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//        return "上传成功，请到Minio的testbucket桶查看";

        String chunkFolderPath = "D:\\BaiduNetdiskDownload\\fenkuai\\minio\\";
        File chunkFolder = new File(chunkFolderPath);
        //分块文件
        File[] files = chunkFolder.listFiles();
        //将分块文件上传至minio
        for (int i = 0; i < files.length; i++) {
            try {
                UploadObjectArgs uploadObjectArgs = UploadObjectArgs.builder().bucket("testbucket").object("chunk/" + i).filename(files[i].getAbsolutePath()).build();
                minioClient.uploadObject(uploadObjectArgs);
                System.out.println("上传分块成功"+i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /***
     * 把minio的岁文件合并
     * @return
     * @throws IOException
     */
    @GetMapping("/minio/fileOneMinio")
    public String fileMerge() throws Exception {
        List<ComposeSource> sources = Stream.iterate(0, i -> ++i)
                .limit(8)//重点！！ 分了几个碎文件就写几个
                .map(i -> ComposeSource.builder()
                        .bucket("testbucket")//碎文件所用的桶
                        .object("chunk/".concat(Integer.toString(i)))//碎文件目录
                        .build())
                .collect(Collectors.toList());

        ComposeObjectArgs composeObjectArgs = ComposeObjectArgs.builder().bucket("testbucket").object("tareget/mergeMinio02.mp4").sources(sources).build();
        minioClient.composeObject(composeObjectArgs);
        return "合并成功，请到Minio的bilibilichunk桶查看";
    }

    /***
     * 清除minio碎文件
     * @return
     */
    @GetMapping("/minio/clear")
    // 浏览器访问http://localhost:8080/minio/clear  文件清理的执行速度非常快，这个接口不耗时
    public String yyclear(){
        //合并分块完成将分块文件清除
        List<DeleteObject> deleteObjects = Stream.iterate(0, i -> ++i)
                .limit(8)//重点！！！这个要手动写，你有几个碎文件，就写几，(源文件大小 / 分块大小)+1=碎文件数量，或者手动写，不然碎文件删不干净
                .map(i -> new DeleteObject("chunk/".concat(Integer.toString(i))))
                .collect(Collectors.toList());

        RemoveObjectsArgs removeObjectsArgs = RemoveObjectsArgs.builder().bucket("bilibilichunk").objects(deleteObjects).build();
        Iterable<Result<DeleteError>> results = minioClient.removeObjects(removeObjectsArgs);
        results.forEach(r->{
            DeleteError deleteError = null;
            try {
                deleteError = r.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return "清理成功";
    }
}
