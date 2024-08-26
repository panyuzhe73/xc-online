package com.xuecheng.media.api;

import org.apache.commons.compress.utils.IOUtils;
import com.j256.simplemagic.ContentInfo;
import com.j256.simplemagic.ContentInfoUtil;
import io.minio.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;

@RestController
public class MinioController {

    static MinioClient minioClient =
            MinioClient.builder()
                    .endpoint("http://47.96.10.151:9000") //Minio地址+服务端口
                    .credentials("minioadmin", "minioadmin")//用户名+密码
                    .build();

    //--------------------------------上传----------------------------------

    @GetMapping("/upload")
    // 浏览器访问http://localhost:8080/upload 。第一次访问可能会报错，后续访问就不会报错了，访问的等待时间根据你的文件大小而定
    // 如果Minio有一个文件的名字，跟你要上传的文件名一样，那么你上传的文件会覆盖Minio那个文件
    public String xxupload(){


        //如果要上传的文件没有扩展名，就指定扩展名为.txt
        ContentInfo extensionMatch = ContentInfoUtil.findExtensionMatch(".png");//手动指定的扩展名
        String mimeType = MediaType.APPLICATION_OCTET_STREAM_VALUE;//默认是正常的扩展名
        if(extensionMatch!=null){
            mimeType = extensionMatch.getMimeType();//当没有默认扩展名的时候，就指定扩展名为.txt
        }

        //上传文件
        try {
            //桶是否存在，如果不存在就创建名为bilibili的桶
            boolean bucketExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket("testbucket").build());
            if (!bucketExists) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket("testbucket").build());
            }

            //上传文件
            minioClient.uploadObject(
                    UploadObjectArgs.builder()
                            .bucket("testbucket")//往哪个桶上传文件
                            .filename("E:\\123.png")//指定本地文件，绝对路径
                            .object("123.png")//上传到Minio之后这个文件叫什么，也就是重命名这个文件的文件名
                            //如果你不想直接上传到bilibili桶的根目录，你想在bilibili桶里面新建一个temp文件夹，把文件上传到这个temp文件夹里面，那就用下一行
                            //.object("temp/xxmaven.zip")
                            .contentType(mimeType)//设置文件扩展名，可选，当你要上传的文件没有扩展名时，需要此项
                            .build());
        } catch (Exception e){
            throw new RuntimeException("上传失败");
        }
        return "上传成功，请到Minio查看";
    }

    //--------------------------------删除----------------------------------

    @GetMapping("/delete")
    // 浏览器访问http://localhost:8080/delete 这个请求的执行速度非常快，秒删
    public String xxdelete(){
        try {
            //删除在bilibili桶的xxmaven.zip文件
            minioClient.removeObject(RemoveObjectArgs.builder().bucket("bilibili").object("xxmaven.zip").build());
            //如果你要删除的文件不在bilibili桶的根目录，而是在bilibili桶里面的temp文件夹，就用下一行
            //minioClient.removeObject(RemoveObjectArgs.builder().bucket("bilibili").object("temp/xxmaven.zip").build());
        } catch (Exception e) {
            throw new RuntimeException("删除失败");
        }
        return "删除成功，请到Minio查看";
    }

    //--------------------------------下载----------------------------------

    @GetMapping("/download")
    // 浏览器访问http://localhost:8080/download 这个请求的执行速度比较慢，根据文件大小而定。下载之前，请确认你的Minio里有相应文件，不然下载报错
    public String xxdownload(){
        GetObjectArgs getObjectArgs = GetObjectArgs.builder().bucket("bilibili").object("xxmaven.zip").build();
        //如果你要下载的文件不在bilibili桶的根目录，而是在bilibili桶的temp文件夹，就用下一行
        //GetObjectArgs getObjectArgs = GetObjectArgs.builder().bucket("bilibili").object("temp/xxmaven.zip").build();
        try{
            //输入流，也就是从你服务器拿文件。操作的是Minio的文件
            FilterInputStream inputStream = minioClient.getObject(getObjectArgs);
            //输出流，也就是把拿到的文件下载到你本地电脑。操作的是你本地电脑的文件
            FileOutputStream outputStream = new FileOutputStream("D:\\SpringBootXueMaven\\xxmaven2.zip");//下载到你电脑的哪个位置，以及自定义下载后的文件名
            //输入流拷贝为输出流
            IOUtils.copy(inputStream,outputStream);

            //【校验文件完整-请确保你下载的文件"下载文件"，是来源于你电脑的文件"原始文件"】

            //判断文件是否下载完成，避免出现文件不完整。原理: 比较两个文件的md5值。比较'原始文件'跟'下载文件'的md5值，如果md5值一样，就说明'下载文件'的完整的
            FileInputStream originFile = new FileInputStream("D:\\SpringBootXueMaven\\xxmaven.zip");//原始文件。因为Minio的这个文件，其实就是从我们电脑传到Minio，所以原始文件就是本地的文件

            outputStream.close();//把你下载好(走到这就已经是下载好了，只是说不知道是不是完整的)的文件的流关闭掉，不然一直是下载状态，你本地电脑以为还没下载完就一直占用IO资源，导致这里校验拿不到你'下载文件'的IO资源
            String minio_md5 = DigestUtils.md5Hex(originFile);//'原始文件'的md5值
            String local_md5 = DigestUtils.md5Hex(new FileInputStream("D:\\SpringBootXueMaven\\xxmaven.zip"));//‘下载文件’的md5值
            if(minio_md5.equals(local_md5)){
                return "下载成功，请到本地电脑指定位置查看";
            }

        } catch (Exception e) {
            throw new RuntimeException("下载失败");
        }
        return "下载的文件不完整";//请确保你下载的文件"下载文件"，是来源于你电脑的文件"原始文件"
    }

}
