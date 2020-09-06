package libs.apache_common.io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.input.TeeInputStream;
import org.apache.commons.io.output.TeeOutputStream;

import java.io.*;
import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) throws IOException {

        fileUtils();
        filenameUtils();
        inputAndOutput();


    }

    private static void fileUtils() throws IOException {
        System.out.println("\n=== fileUtils ===");

        //getFile
        File file = FileUtils.getFile(Main.class.getClassLoader().getResource("logback.xml").getPath());
        //getTempDirectory
        File tempDir = FileUtils.getTempDirectory();
        //copyFileToDirectory
        FileUtils.copyFileToDirectory(file, tempDir);
        //getFile
        File newTempFile = FileUtils.getFile(tempDir, file.getName());
        //readFileToString
        String data = FileUtils.readFileToString(newTempFile, Charset.defaultCharset());
    }


    private static void filenameUtils() throws IOException {
        System.out.println("\n=== filenameUtils ===");

        String path = "D:\\Projects\\My_projects\\lessons\\JavaCore\\src\\main\\resources\\logback.xml";

        String fullPath = FilenameUtils.getFullPath(path);
        System.out.println("fullPath = " + fullPath);

        String extension = FilenameUtils.getExtension(path);
        System.out.println("extension = " + extension);

        String baseName = FilenameUtils.getBaseName(path);
        System.out.println("baseName = " + baseName);
    }



    private static void inputAndOutput() throws IOException {
        System.out.println("\n=== inputAndOutput ===");

        //write a single input stream to two different output streams
        String str = "Hello World.";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(str.getBytes());
        ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
        ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();

        FilterOutputStream teeOutputStream = new TeeOutputStream(outputStream1, outputStream2);
        new TeeInputStream(inputStream, teeOutputStream, true).read(new byte[str.length()]);

        assert str.equals(String.valueOf(outputStream1));
        assert str.equals(String.valueOf(outputStream2));
    }
}
