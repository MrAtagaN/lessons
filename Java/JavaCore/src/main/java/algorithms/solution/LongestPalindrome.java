package algorithms.solution;

public class LongestPalindrome {


    public static void main(String[] args) {

        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindromeUseStringBuilder("babad"));
        System.out.println(longestPalindromeUseStringBuilder("cbbd"));
    }

    /**
     *Метод находит самую длинную подстроку из s являющейся палиндромом используя StringBuilder
     */
    public static String longestPalindromeUseStringBuilder (String s) {
        String result = "";
        for (int l = 0; l < s.length(); l++) {
            for (int r = l; r <= s.length(); r++) {
                if (r - l + 1 < result.length()) {
                    continue;
                }
                String subStr = s.substring(l, r);
                String reverseStr = new StringBuilder(subStr).reverse().toString();
                if (subStr.equals(reverseStr) && subStr.length() > result.length()) {
                    result = subStr;
                }
            }
        }
        return result;
    }



    /**
     *Метод находит самую длинную подстроку из s являющейся палиндромом
     */
    public static String longestPalindrome(String s) {

        String result = "";

        char[] chars = s.toCharArray();

        for (int l = 0; l < s.length(); l++) {
            for (int r = l; r < s.length(); r++) {
                if (r - l + 1 < result.length()) {
                    continue;
                }
               char[] subArray = getSubArray(chars, l, r);
                if (isPalindrome(subArray) && subArray.length > result.length()) {
                   result = new String(subArray);
                }
            }
        }
        return result;
    }

    private static boolean isPalindrome(char[] charArray) {
        for (int i = 0; i < charArray.length / 2 ; i++) {
           if (charArray[i] != charArray[charArray.length - i - 1]) {
               return false;
           }
        }
        return true;
    }

    private static char[] getSubArray(char[] chars, int l, int r) {
        char[] subArray = new char[r - l + 1];
        for (int i = 0 ; l <= r; l++) {
            subArray[i++] = chars[l];
        }
        return subArray;
    }


}
