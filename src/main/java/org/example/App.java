package org.example;

/**
 * <a href="https://neetcode.io/problems/is-palindrome?list=blind75">Valid Palindrome</a>
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        App a = new App();
        System.out.println(a.isPalindrome("aba1##"));
    }
    public boolean isPalindrome(String s) {

        char[] sentence = s.toCharArray();
        int left=0;
        int right=s.length()-1;
        while(left<right){

            if(!Character.isLetterOrDigit(sentence[left])) {
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(sentence[right])){
                right--;
                continue;
            }

            if(Character.toLowerCase(sentence[left])!=Character.toLowerCase(sentence[right])){
               return false;
            }
            left++;
            right--;
        }
        return true;



    }
}

