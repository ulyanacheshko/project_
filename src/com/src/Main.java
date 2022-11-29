package com.src;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // write your code here//ZipControl
        ZipControl cntrl = new ZipControl();
        cntrl.Prepare();
        cntrl.SetPath("/Users/maksim/IdeaProjects/ReadWrite/");
        cntrl.SetArchiveName("testFile.zip");
        cntrl.SetFileName("testFile.txt");
        cntrl.Unzip();
    }
}