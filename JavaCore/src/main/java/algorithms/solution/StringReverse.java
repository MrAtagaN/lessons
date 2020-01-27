package algorithms.solution;


/**
 * Сортировки: https://habr.com/ru/company/otus/blog/460087/
 */
public class StringReverse {

    public static void main(String[] args) {
        System.out.println(reverse("qwerty"));
    }


    /**
     * Разворот строки
     */
    public static String reverse(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char leftChar = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = leftChar;
        }
        return new String(chars);
    }
}
