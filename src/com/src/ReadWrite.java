package com.src;
import com.src.writers.Writer;

import java.io.File;
import java.io.IOException;

public class ReadWrite {

    boolean wasZipped = false;
    boolean wasEncrypted = false;

    private Reader reader;
    private Writer writer;

    private ZipControl cntrl = new ZipControl();

    private String filePath = "/Users/maksim/IdeaProjects/ReadWrite/default.zip";
    private String path = "";
    private String fileName;
    private String tempDir = "temp/";
    private String outputDir = "output/";
    private String readPath;
    private String writePath;

    ReadWrite(String filePath){
        this.filePath = filePath;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }
    public void SetWriter(Writer writer) {
        this.writer = writer;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void Prepare() throws IOException {

        boolean created;

        File temp = new File(path  + tempDir);
        created = temp.mkdir();
        File output = new File(path + outputDir);
        created = output.mkdir();

        int fileNameStart = 0;
        fileNameStart = this.filePath.lastIndexOf('/');
        if(fileNameStart != -1) {
            this.fileName = filePath.substring(fileNameStart + 1);
            this.path = filePath.substring(0, fileNameStart + 1);
        }
        else fileName = filePath;

        if(fileName.endsWith(".zip")) {

            wasZipped = true;

            //cntrl.Unzip(filePath,path + tempDir);
        }

    }

    public void End() {

        boolean created;

        File temp = new File(path + tempDir);
        created = temp.delete();
        //File output = new File(path + outputDir);
        //created = output.delete();

    }

}