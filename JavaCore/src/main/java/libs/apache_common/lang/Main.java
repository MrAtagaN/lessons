package libs.apache_common.lang;

import lombok.Data;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.JavaVersion;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        exceptionUtils();
        stringUtils();
        arrayUtils();
        systemUtils();
        reflectionUtils();

    }


    private static void exceptionUtils() {
        System.out.println("\n=== exceptionUtils ===");

        try {
            throw new RuntimeException("aa");
        } catch (Exception e) {
            String stackTrace = ExceptionUtils.getStackTrace(e);
            System.out.println(stackTrace);
        }
    }


    private static void stringUtils() {
        System.out.println("\n=== stringUtils ===");

        assert StringUtils.isBlank(" ");
        assert StringUtils.isEmpty("");
        assert StringUtils.isAllLowerCase("abd");
        assert StringUtils.isAllUpperCase("ABC");
        assert StringUtils.isAlpha("abc");
        assert StringUtils.isAlphanumeric("abc123");
    }


    private static void arrayUtils() {
        System.out.println("\n=== arrayUtils ===");

        String[] array = {"a", "b", "c"};
        String string = ArrayUtils.toString(array);
        System.out.println(string);

        String string1 = ArrayUtils.toString(null, "Array is null");
        System.out.println(string1);

        int hashCode = ArrayUtils.hashCode(array);
        System.out.println("hashCode: " + hashCode);

        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        assert ArrayUtils.isSameLength(array1, array2);

        int[] array3 = {1, 2, 3};
        assert ArrayUtils.indexOf(array3, 1, 0) == 0;
    }


    private static void systemUtils() {
        System.out.println("\n=== systemUtils ===");

        File javaHome = SystemUtils.getJavaHome();
        System.out.println("javaHome: " + javaHome);

        File userHome = SystemUtils.getUserHome();
        System.out.println("userHome: " + userHome);

        assert SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_8);
    }


    private static void reflectionUtils() {

    }


    @Data
    public class User {

        private String name;
        private String email;

    }
}
