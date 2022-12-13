package com.src;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // write your code here//ZipControl
        ZipControl cntrl = new ZipControl();
        cntrl.Prepare();
        cntrl.SetPath("C://Users//Юзер//IdeaProjects//project_//src//com//src//ReadWrite.java");
        cntrl.SetArchiveName("testFile.zip");
        cntrl.SetFileName("testFile.txt");
        cntrl.Unzip();
    }
}