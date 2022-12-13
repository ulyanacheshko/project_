package com.src.writers;
import com.src.ZipControl;

import java.io.FileWriter;
import java.io.IOException;
public interface Writer {

    public default void Zip(ZipControl cntrl) throws IOException {

        //cntrl.Zip();
        //cntrl.Clean();

    }
    //public void Encrypt();
    public void Open(String fileName) throws IOException;
    public void WriteLine(String line) throws Exception;
    public void Write(String string) throws IOException;
    public void Close() throws IOException;

}

