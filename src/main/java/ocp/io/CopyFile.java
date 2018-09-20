package main.java.ocp.io;

import java.io.*;

/**
 * Created by christianneuls on 19.09.18.
 */
public class CopyFile {

    public static void copy(File source, File destination) throws IOException {
        try (InputStream in = new FileInputStream(source);
             OutputStream out = new FileOutputStream(destination)) {
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File source = new File("./src/main/java/ocp/io/CopyFile.java");
        File destination = new File("./src/main/java/ocp/io/CopyFile2.java");
        copy(source, destination);
    }
}
