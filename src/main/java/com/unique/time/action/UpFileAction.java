package com.unique.time.action;

import java.io.File;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unique.time.model.UpFile;
import org.springframework.stereotype.Component;

@Component
public class UpFileAction extends ActionSupport implements ModelDriven<UpFile> {

    UpFile file=new UpFile();
    public String up() {
        String upFilePath="E:\\IntelliJ IDEA 2018.1.3\\workspace\\Time\\src\\main\\webapp\\img";//取真实路径
        if (file.getImg()!=null) {
            //String imgurl = ServletActionContext.getServletContext().getRealPath("\\img");//取真实路径
            for (int i=0;i<file.getImg().size();i++) {
                File imgdir = new File(upFilePath, file.getImgFileName().get(i));//把文件映射到真实路径里
                file.getImg().get(i).renameTo(imgdir);//把临时空间里的文件放到imagedir里面
            }
        } else {
            return ERROR;
        }
        return SUCCESS;
    }
    @Override
    public UpFile getModel(){
        return file;
    }

}

