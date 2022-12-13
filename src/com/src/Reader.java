package com.src;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public interface Reader {
    void Open(String fileName) throws FileNotFoundException;
    String ReadLine() throws Exception;
    boolean HasNextLine();
    void Close() throws IOException;
}
class TxtReader implements Reader{
    FileReader fr;
    Scanner scan;
    public void Open(String fileName) throws FileNotFoundException {
        fr = new FileReader(fileName);
        scan = new Scanner(fr);
    }
    public String ReadLine() throws Exception {
        String temp;
        temp = scan.nextLine();
        return temp;
    }
    public boolean HasNextLine() {
        return scan.hasNextLine();
    }
    public void Close() throws IOException {
        fr.close();
    }
}
