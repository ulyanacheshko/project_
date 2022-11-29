package com.src;

import java.io.IOException;

public interface Reader {
    public void Read(String filename) throws Exception;

    //public void Unzip();
    public default void Unzip(ZipControl cntrl) throws IOException {

        //cntrl.Unzip();

    }
    //public void Decrypt();
}
