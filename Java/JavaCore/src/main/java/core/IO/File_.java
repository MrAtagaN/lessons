package core.IO;

import java.io.File;
import java.io.IOException;


/**
 * https://javarush.ru/quests/lectures/questcollections.level01.lecture01
 */
public class File_ {

    public static void main(String[] args) throws IOException {
        File file = new File("TODO.txt");
        System.out.println("File name: " + file.getName());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Parent directory: " + file.getParent());
        System.out.println("File length: " + file.length() + " bytes");

        System.out.println("File exists: " + file.exists());
        System.out.println("File can write: " + file.canWrite());
        System.out.println("File can read: " + file.canRead());
        System.out.println("File is directory: " + file.isDirectory());
        System.out.println("File is regular file: " + file.isFile());
        System.out.println("File is hidden: " + file.isHidden());
        System.out.println("File canonical path: " + file.getCanonicalPath());
        System.out.println("File  path: " + file.toPath());

        System.out.println("Total space: " + file.getTotalSpace() / Math.pow(10, 9) + " Gb");
        System.out.println("Free space: " + file.getFreeSpace() / Math.pow(10, 9) + " Gb");


    }
}
