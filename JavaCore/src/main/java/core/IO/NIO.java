package core.IO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * NIO - Files, Path, Paths
 *
 * https://javarush.ru/quests/lectures/questcollections.level01.lecture03
 * https://javarush.ru/groups/posts/2275-files-path
 */
public class NIO {

    public static void main(String[] args) throws IOException {
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
        Files.readAllBytes(path);

        List<String> lines = Files.readAllLines(path);
        lines.forEach(System.out::println);
    }
}
