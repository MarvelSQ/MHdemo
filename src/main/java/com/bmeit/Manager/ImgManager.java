package com.bmeit.Manager;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

/**
 * Created by sunqiang on 2016/9/28.
 */

public class ImgManager {

    private static ImgManager instance;

    public ImgManager(){

    }

    public static ImgManager getInstance(){
        if(instance==null){
            instance=new ImgManager();
        }
        return instance;
    }

    public String saveFile(MultipartFile file){
        if(!file.isEmpty()){
            try {
              /*
               * 这段代码执行完毕之后，图片上传到了工程的跟路径；
               * 大家自己扩散下思维，如果我们想把图片上传到 d:/files大家是否能实现呢？
               * 等等;
               * 这里只是简单一个例子,请自行参考，融入到实际中可能需要大家自己做一些思考，比如：
               * 1、文件路径；
               * 2、文件名；
               * 3、文件格式;
               * 4、文件大小的限制;
               */
                String fileName = file.getOriginalFilename();
                fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
                //获取扩展
                String extName = fileName.substring(fileName.lastIndexOf("."));//.jpg
                //System.out.println(extName);
                //UUID
                String uuid = UUID.randomUUID().toString().replace("-", "");
                //System.out.println(uuid);
                //新名称
                String newName = uuid+extName;
                //System.out.println(newName);
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File("img/"+newName)));
                out.write(file.getBytes());
                out.flush();
                out.close();
                System.out.println(file.getOriginalFilename());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return"上传失败,"+e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return"上传失败,"+e.getMessage();
            }
            return"上传成功";
        }else{
            return"上传失败，因为文件是空的.";
        }
    }
}
