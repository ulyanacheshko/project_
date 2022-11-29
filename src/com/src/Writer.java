package com.src;
import java.io.IOException;
public interface Writer {
    public void Write(String filename) throws Exception;

    //public void Zip();
    public default void Zip(ZipControl cntrl) throws IOException {

        //cntrl.Zip();
        //cntrl.Clean();

    }
    //public void Encrypt();
}

