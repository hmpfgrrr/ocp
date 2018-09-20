package main.java.ocp.io;

import java.io.File;

/**
 * Created by christianneuls on 09.01.17.
 */
public class ReadFileInformation {

    public static void main(String[] args) {
        //File file = new File("./src/main/java/ocp/io/ReadFileInformation.java");
        File file = new File("./src/main/java/ocp/io");
        System.out.println("File exists: " + file.exists());
        if (file.exists()){
            System.out.println(file.getAbsolutePath());
            System.out.println(file.isDirectory());
            System.out.println(file.getParent());
            if (file.isFile()) {
                System.out.println(file.length());
                System.out.println(file.lastModified());
            } else {
                for (File subfile: file.listFiles()) {
                    System.out.println(subfile.getName());
                }
            }
        }
    }
}
