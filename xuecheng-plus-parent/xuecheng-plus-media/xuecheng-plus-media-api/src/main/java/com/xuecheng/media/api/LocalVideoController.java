package com.xuecheng.media.api;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/***
 * 把本地的视频文件分片，把分片后的岁文件合并成完整的视频文件
 */
@RestController
public class LocalVideoController {

    /**
     * 将本地视频分块
     * @return
     * @throws IOException
     */
    @GetMapping("/fileCut")
    public String fileCut() throws IOException {
        //本地源文件
        File sourceFile = new File("D:\\BaiduNetdiskDownload\\第1章 1.1 导入角色.mp4");
        //存放分片后的视频路径
        String chunkPath = "D:\\BaiduNetdiskDownload\\fenkuai\\";
        File chunkPathFile = new File(chunkPath);
        //检查检查路径是否存在
        if(!chunkPathFile.exists()){
            chunkPathFile.mkdirs();
        }

        //定义分块每块的大小
        int chunkSize = 1024*1024*1;
        //计算要分的数量
        int ceilNum = (int) Math.ceil(sourceFile.length() * 1.0 / chunkSize);

        //定义缓冲区，每次从源文件读的数据都保存在缓冲区中
        byte[] b = new byte[1024];
        //使用RandomAccessFile进行读写【可以读可以写】
        RandomAccessFile raf_read = new RandomAccessFile(sourceFile, "r");
        //分块存储
        for (int i = 0; i < ceilNum; i++) {
            //每块都写到新的文件中
            File file = new File(chunkPath + i);
            if(file.exists()){
                file.delete();
            }
            //判断是否创建成功
            boolean newFile = file.createNewFile();
            if(newFile){
                RandomAccessFile raf_write = new RandomAccessFile(file, "rw");
                int len = -1;
                //现将源文件的数据存到缓存区中
                while((len = raf_read.read(b))!= -1){
                    //将缓存区中的数据写入到新建的文件中
                    raf_write.write(b,0,len);
                    //存满了返回
                    if(file.length() >= chunkSize){
                        break;
                    }
                }
                raf_write.close();
            }

        }
        raf_read.close();
        return "完成分块，请前往"+chunkPath+"文件夹查看";
    }

    /***
     * 合并文件
     * @return
     * @throws IOException
     */
    @GetMapping("/fileOne")
    public String fileMerge() throws IOException {
        //已分块文件的路径
        File chunkPath = new File("D:\\BaiduNetdiskDownload\\fenkuai\\");
        //源文件夹的路径，校验合并后的文件是否完整
        File sourceFile = new File("D:\\BaiduNetdiskDownload\\第1章 1.1 导入角色.mp4");
        //合并后的文件的路径以及名字
        File mergeFile = new File("D:\\BaiduNetdiskDownload\\第1章 1.1 导入角色合并后.mp4");
        if(mergeFile.exists()){
            mergeFile.delete();
        }
        boolean newFile = mergeFile.createNewFile();
        if(newFile){
            //创建写文件
            RandomAccessFile raf_write = new RandomAccessFile(mergeFile, "rw");

            //缓冲区
            byte[] bytes = new byte[1024];
            //分块列表
            File[] fileArray = chunkPath.listFiles();
            //转为数据进行排序
            List<File> fileList = Arrays.asList(fileArray);
            //进行从小到大排序
            Collections.sort(fileList, (o1, o2) -> Integer.parseInt(o1.getName()) - Integer.parseInt(o2.getName()));

            //合并文件
            for (File chunkFile : fileList) {
                //创建读文件
                RandomAccessFile raf_read = new RandomAccessFile(chunkFile, "rw");
                int len = -1;
                while ((len = raf_read.read(bytes))!= -1){
                    raf_write.write(bytes,0,len);
                }
                raf_read.close();
            }
            raf_write.close();

            FileInputStream fileInputStream = new FileInputStream(sourceFile);
            FileInputStream mergeInputStream = new FileInputStream(mergeFile);

            //源文件的md5
            String originalMd5 = DigestUtils.md5Hex(fileInputStream);
            //合并后文件的md5
            String mergeMd5 = DigestUtils.md5Hex(mergeInputStream);
            if(originalMd5.equals(mergeMd5)){
                System.out.println("文件合成成功");
            }else{
                System.out.println("合成文件失败，文件不完整");
            }


        }
        return "合并成功，合并后额的文件是"+mergeFile;

    }
}
