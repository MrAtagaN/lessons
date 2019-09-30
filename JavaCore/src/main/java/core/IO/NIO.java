package core.IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * NIO - Files, Path, Paths
 * <p>
 * https://javarush.ru/quests/lectures/questcollections.level01.lecture03
 * https://javarush.ru/groups/posts/2275-files-path
 */
public class NIO {

    public static void main(String[] args) throws IOException {
        //Paths
        Path path = Paths.get("TODO.txt");

        //Path
        System.out.println(path.isAbsolute());
        System.out.println(path.getRoot());
        System.out.println(path.getFileName());
        System.out.println(path.getParent());
        System.out.println(path.startsWith(path));
        System.out.println(path.endsWith(path));
        System.out.println(path.normalize());
        System.out.println(path.relativize(path));
        System.out.println(path.toAbsolutePath());
        System.out.println(path.toFile());

        //Files
        System.out.println("File is exists: " + Files.exists(path));
        System.out.println("File is readable: " + Files.isReadable(path));
        System.out.println("File is hidden: " + Files.isHidden(path));
        System.out.println("File is regular file: " + Files.isRegularFile(path));
        System.out.println("File size: " + Files.size(path));

        Files.readAllBytes(path);

        List<String> lines = Files.readAllLines(path);
        System.out.println("Содержимое файла: ");
        lines.forEach(System.out::println);
    }
}
