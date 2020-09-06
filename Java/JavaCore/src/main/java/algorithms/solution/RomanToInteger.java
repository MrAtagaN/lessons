package algorithms.solution;

public class RomanToInteger {

    public static void main(String[] args) {

        System.out.println(romanToInteger("IV")); //4
        System.out.println(romanToInteger("LVIII")); //58
        System.out.println(romanToInteger("MCMXCIV")); //1994
    }

    public static int romanToInteger(String romanInteger) {
        int resultInteger = 0;
        char[] chars = romanInteger.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            resultInteger += toRoman(chars[i]);
            if (i != 0 && toRoman(chars[i]) > toRoman(chars[i - 1])) {
                resultInteger -= toRoman(chars[i - 1]) * 2;
            }
        }
        return resultInteger;
    }

    private static int toRoman(char c) {
        if (c == 'M') {
            return 1000;
        }
        if (c == 'D') {
            return 500;
        }
        if (c == 'C') {
            return 100;
        }
        if (c == 'L') {
            return 50;
        }
        if (c == 'X') {
            return 10;
        }
        if (c == 'V') {
            return 5;
        }
        if (c == 'I') {
            return 1;
        }
        return 0;
    }



}
