package algorithms.solution;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {


    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutRepeatingCharacters("abcabcbb"));
    }



    public static String longestSubstringWithoutRepeatingCharacters(String s) {
        char[] chars = s.toCharArray();
        String result = "";

        for (int l = 0; l < chars.length; l++) {
            for(int r = l; r < chars.length; r++) {
                char[] subArray = getSubArray(chars, l, r);
                if (uniqCharacters(subArray)) {
                    if (subArray.length > result.length()) {
                        result = new String(subArray);
                    }
                } else {
                    r--;
                    l++;
                }
            }
        }
        return result;
    }

    private static char[] getSubArray(char[] chars, int l, int r) {
        char[] subArray = new char[r - l + 1];
        for (int i = 0; l <= r; i++) {
            subArray[i] = chars[l++];
        }
        return subArray;
    }

    private static boolean uniqCharacters(char[] chars) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
           if(!set.add(chars[i])) {
               return false;
           }
        }
        return true;
    }
}
