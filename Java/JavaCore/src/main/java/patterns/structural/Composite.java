package patterns.structural;

import java.util.ArrayList;
import java.util.List;

/**
 * Компоновщик реализует интерфейс, и содержит массив объектов с таким же интерфейсом
 */
public class Composite {

    public static void main(String[] args) {
        File file1 = new File("aa", 5);
        File file2 = new File("bbb", 3);
        File file3 = new File("ccc", 2);

        File file4 = new File("g", 6);
        file4.addFile(file1);
        file4.addFile(file2);

        File file5 = new File("qq", 3);
        file5.addFile(file3);

        File file6 = new File("rr", 7);
        file6.addFile(file4);
        file6.addFile(file5);

        file6.getInfo();
    }


    interface Info {
        void getInfo();
    }


    /**
     * Компоновщик
     */
    static class File implements Info {
        private String fileName;
        private int size;
        private List<Info> fileList = new ArrayList<>();

        public File(String fileName, int size) {
            this.fileName = fileName;
            this.size = size;
        }

        public void getInfo() {
            System.out.println("File name: " + fileName + " size: " + size);
            fileList.forEach(Info::getInfo);
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public void addFile(File file) {
            fileList.add(file);
        }

        public void removeFile(File file) {
            fileList.remove(file);
        }
    }

}
