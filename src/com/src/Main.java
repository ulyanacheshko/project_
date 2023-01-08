package com.src;

public class Main {
    public static void main(String[] args) throws Exception {
        Interface anInterface = new Interface();
        anInterface.Start();
        PathCheck pathCheck = new PathCheck("/IdeaProjects/project_/testFile.rtf");
//        Encrypt encryptControl = new Encrypt("KeyIsVerySecret1");
//        encryptControl.EncryptFile(pathCheck,"");
//        ZipFiles.Zip(pathCheck,"","testFile\\\\zippedUnsupported.zip");
        Commands.Process(args);
//        Reader r = new TxtReader();
//        Writer w = new TxtWriter();
//        String buffer = "";
//        r.Open("test.txt");
//        w.Open("test1.txt");
//        while(r.HasNextLine() ) {
//            buffer = r.ReadLine();
//            w.WriteLine(buffer);
//        }
//        r.Close();
//        w.Close();

    }
}
