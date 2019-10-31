package algorithms.solution;

public class Polindrome {

    public static void main(String[] args) {
        System.out.println(isPolindrome("cats"));
        System.out.println(isPolindrome("anna"));
    }

    public static boolean isPolindrome(String sourceString) {
        for (int i = 0; i < sourceString.length() / 2; i++) {
            if (sourceString.charAt(i) != sourceString.charAt(sourceString.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
