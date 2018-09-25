package main.java.ocp.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

/**
 * Created by christianneuls on 20.09.18.
 */
public class Simple {

    public static void main(String[] args) {
        Path path = Paths.get("src/main/java/ocp/io/CopyFile.java");
        System.out.println("path is :" + path);
        System.out.println(path.getRoot());
        System.out.println(path.getFileName());
        System.out.println(path.getParent());

        for (int i = 0; i < path.getNameCount(); i++) {
            System.out.println("element " + i + " is " + path.getName(i));

        }

        //copy Files
        try {
            Files.copy(Paths.get("one"), Paths.get("two"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //BasicFileAttributes
        try {
            Path path1 = Paths.get("path");
            BasicFileAttributeView view = Files.getFileAttributeView(path1, BasicFileAttributeView.class);
            BasicFileAttributes data = view.readAttributes();
            FileTime lastModifiedTime = FileTime.fromMillis(data.lastModifiedTime().toMillis() + 10_000);
            view.setTimes(lastModifiedTime, null, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Listing contents
        try {
            Path path2 = Paths.get(".");
            Files.list(path2)
                    .filter(p -> !Files.isDirectory(p))
                    .map(Path::toAbsolutePath)
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
