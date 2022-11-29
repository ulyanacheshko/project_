package com.src;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipControl {
    private String path = "/User/IdeaProjects/ReadWrite/";
    private String tempDir = "temp";
    private String outputDir = "output";
    private String archiveName = "default.zip";
    private String fileName = "default.txt";


    public void SetPath(String userPath) {

        path = userPath;

    }

    public void SetArchiveName(String UserArchiveName) {

        archiveName = UserArchiveName;

    }

    public void SetFileName(String UserFileName) {

        fileName = UserFileName;

    }

    public void Prepare() {

        boolean created;

        File temp = new File(path + tempDir);
        created = temp.mkdir();
        File output = new File(path + outputDir);
        created = output.mkdir();

    }

    public void Zip() throws IOException {

        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(path + tempDir + "/" + archiveName));
             FileInputStream fis = new FileInputStream(fileName)) {

            ZipEntry entry = new ZipEntry(fileName);
            zout.putNextEntry(entry);

            byte[] buffer = new byte[fis.available()];

            zout.write(buffer);
            zout.closeEntry();

        }

    }

    public void Unzip() throws IOException {

        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(path + archiveName))) {

            ZipEntry entry;
            String filename;
            long size;

            while ((entry = zin.getNextEntry()) != null) {

                filename = entry.getName();
                size = entry.getSize();

                FileOutputStream fout = new FileOutputStream(path + tempDir + "/" + filename);
                for (int c = zin.read(); c != -1; c = zin.read()) fout.write(c);

                fout.flush();
                zin.closeEntry();
                fout.close();

            }

        }


    }

    public void Clean() {

        boolean created;

        File temp = new File(path + tempDir);
        created = temp.delete();
        File output = new File(path + outputDir);
        created = output.delete();
    }
}
