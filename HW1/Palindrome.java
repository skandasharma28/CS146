package Hw1;

import java.util.Arrays;

public class Palindrome {
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        
        s = s.replace(" ", "").replace("-", "").replace("+", "").replace("!", "").replace(",", "").replace(".","").replace("?", "");
 

        int j = 0;

        char[] array = s.toCharArray();
        char[] reverseArray = new char[array.length];

        for (int i = array.length - 1; i >= 0; i--) {
            reverseArray[j] = array[i];
            j++;
        }

        return Arrays.equals(array, reverseArray);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("Maam"));
        System.out.println(isPalindrome("Ma'am"));
        System.out.println(isPalindrome("Was it a car or a cat I saw?"));
        System.out.println(isPalindrome("The cat is here, here is the cat"));
    }
}

