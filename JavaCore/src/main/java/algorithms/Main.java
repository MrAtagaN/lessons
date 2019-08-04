package algorithms;


/**
 * Сортировки: https://habr.com/ru/company/otus/blog/460087/
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(reverse("qwerty"));
    }


    /**
     * Факториал
     */
    public static int factorial(int number) {
        int result;
        if (number < 0) {
            return 0;
        }

        if (number > 1) {
            result = number * factorial(number - 1);
        } else {
            return 1;
        }
        return result;
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
