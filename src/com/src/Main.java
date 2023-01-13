package com.src;

public class Main {
    public static void main(String[] args) throws Exception {
        Interface anInterface = new Interface();
        anInterface.Calculate();
        PathCheck pathCheck = new PathCheck("/IdeaProjects/project_/testFile.rtf");
        Encrypt encrypt = new Encrypt("KeyIsVerySecret1");
        encrypt.EncryptFile(pathCheck,"");
        //ZipControl.Zip(pathControl,"","testFile\\\\zippedUnsupported.zip");

        //CommandLineControl.Process(args);

    }
}
