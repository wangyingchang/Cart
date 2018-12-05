package com.unique.time.model;

import java.io.File;
import java.util.List;

public class UpFile {
    private List<File> img;
    private List<String> imgContentType;
    private List<String> imgFileName;

    public List<File> getImg() { return img; }

    public void setImg(List<File> img) { this.img = img; }

    public List<String> getImgContentType() { return imgContentType; }

    public void setImgContentType(List<String> imgContentType) { this.imgContentType = imgContentType; }

    public List<String> getImgFileName() { return imgFileName; }

    public void setImgFileName(List<String> imgFileName) { this.imgFileName = imgFileName; }
}
