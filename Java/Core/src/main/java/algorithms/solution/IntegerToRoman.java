package algorithms.solution;

public class IntegerToRoman {


    public static void main(String[] args) {

        System.out.println(integerToRoman(58)); // LVIII
        System.out.println(integerToRoman(1994)); // MCMXCIV
    }


    public static String integerToRoman(int sourceInt) {
        StringBuilder sb = new StringBuilder();
        while (sourceInt > 0) {
            if (sourceInt - 1000 >= 0) {
                sourceInt -= 1000;
                sb.append("M");
            } else if (sourceInt - 900 >= 0) {
                sourceInt -= 900;
                sb.append("CM");
            } else if (sourceInt - 500 >= 0) {
                sourceInt -= 500;
                sb.append("D");
            } else if (sourceInt - 400 >= 0) {
                sourceInt -= 400;
                sb.append("CD");
            } else if (sourceInt - 100 >= 0) {
                sourceInt -= 100;
                sb.append("C");
            } else if (sourceInt - 90 >= 0) {
                sourceInt -= 90;
                sb.append("XC");
            } else if (sourceInt - 50 >= 0) {
                sourceInt -= 50;
                sb.append("L");
            } else if (sourceInt - 40 >= 0) {
                sourceInt -= 40;
                sb.append("XL");
            } else if (sourceInt - 10 >= 0) {
                sourceInt -= 10;
                sb.append("X");
            } else if (sourceInt - 9 >= 0) {
                sourceInt -= 9;
                sb.append("IX");
            } else if (sourceInt - 5 >= 0) {
                sourceInt -= 5;
                sb.append("V");
            } else if (sourceInt - 4 >= 0) {
                sourceInt -= 4;
                sb.append("IV");
            } else if (sourceInt - 1 >= 0) {
                sourceInt -= 1;
                sb.append("I");
            }
        }
        return sb.toString();
    }
}
