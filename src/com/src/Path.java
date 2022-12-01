package com.src;

import java.io.File;

public class Path {

    private String filePath;
    private String path;
    private String fileName;
    private String tempDir;
    private String outputDir;

    Path(String filePath){
        this.filePath = filePath;

        int fileNameStart = 0;
        fileNameStart = this.filePath.lastIndexOf('/');
        if(fileNameStart != -1) {
            this.fileName = filePath.substring(fileNameStart + 1);
            this.path = filePath.substring(0, fileNameStart + 1);
        }
        else
        {
            this.fileName = filePath;
            this.path = "";
        }

        this.tempDir = this.path + "temp/";
        this.outputDir = this.path + "output/";


    }
    Path(){

    }

    public void CreateDirs() {

        boolean created;

        File temp = new File(path  + tempDir);
        created = temp.mkdir();
        File output = new File(path + outputDir);
        created = output.mkdir();

    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }
    public void setTempDir(String tempDir) {
        this.tempDir = tempDir;
    }
    public String ArchiveName() {

        String ArchiveName = "";

        int extensionStart = 0;
        int fileNameStart = 0;
        extensionStart = this.fileName.lastIndexOf('.');
        fileNameStart = this.fileName.lastIndexOf('/');
        if(extensionStart != -1 && fileNameStart == -1) ArchiveName = this.fileName.substring(0,extensionStart) + ".zip";
        else if(extensionStart != -1) ArchiveName = this.fileName.substring(fileNameStart + 1,extensionStart) + ".zip";
        else ArchiveName = fileName + ".zip";

        return ArchiveName;
    }
    public String FileName() {
        return this.fileName;
    }
    public String FilePath() {
        return filePath;
    }
    public String TempDir(){
        return this.tempDir;
    }
    public String OutputDir() {
        return this.outputDir;
    }
    public boolean isTxt() {
        return fileName.endsWith(".txt");
    }
    public boolean isZip() {
        return fileName.endsWith(".zip");
    }
    public void ClearTemp() {
        boolean created;

        File temp = new File(tempDir);
        created = temp.delete();
    }

}
