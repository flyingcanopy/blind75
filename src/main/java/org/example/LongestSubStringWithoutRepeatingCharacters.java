package org.example;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> characterSet = new HashSet<>();
        int left=0;
        int right=0;
        int lengthOfLongestSubString=1;
        while(right<s.length()){
            if(!characterSet.contains(s.charAt(right))){
                // keep expanding the window
                characterSet.add(s.charAt(right));
                lengthOfLongestSubString=Math.max(lengthOfLongestSubString,characterSet.size());
                right++;
            }else{
                // till the duplicate remove the characters
                while(characterSet.contains(s.charAt(right))) {
                    characterSet.remove(s.charAt(left));
                    left++;
                }
            }

        }
        return lengthOfLongestSubString;
    }

}
