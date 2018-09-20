package main.java.ocp.io;

import java.io.*;

/**
 * Created by christianneuls on 19.09.18.
 */
public class CopyBufferFile {

    public static void copy(File source, File destination) throws IOException {
        try (InputStream in = new BufferedInputStream(new FileInputStream(source));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(destination))) {
            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File source = new File("./src/main/java/ocp/io/CopyFile.java");
        File destination = new File("./src/main/java/ocp/io/CopyFile2.java");
        copy(source, destination);
    }
}
