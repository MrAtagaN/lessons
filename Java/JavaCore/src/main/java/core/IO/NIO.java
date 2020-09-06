package core.IO;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
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
        Files.newBufferedReader(path);
        Files.readAllBytes(path);
        List<String> lines = Files.readAllLines(path);
        System.out.println("Содержимое файла: ");
        lines.forEach(System.out::println);


        //Обход файлов
        Files.walkFileTree(Paths.get("./JavaCore"), new MyFileVisitor());
        //Обход файлов c глубиной 1
        Files.walkFileTree(Paths.get("./JavaCore"), new HashSet<>(), 1,  new MyFileVisitor());


        //BasicFileAttributes
        BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
        System.out.println("File size: " + attributes.size());
        System.out.println("File creationTime: " + attributes.creationTime());
    }

    /**
     * Обходчик файлов
     */
    static class MyFileVisitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println(file.getFileName());
            //return super.visitFile(file, attrs);
            return FileVisitResult.CONTINUE;
        }
    }
}
