package moving_window;

import java.util.*;

public class Longest_SubString {
    public static int lengthOfLongestSubstring(String s){
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int left = 0, maxLength = 0;
        for(int right = 0; right < s.length(); right++){
            char currentChar = s.charAt(right);
            if(charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= left){
                left = charIndexMap.get(currentChar) + 1;
            }
            charIndexMap.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
            
        }

        return maxLength;
        
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String input = sc.nextLine();
        String s = "abcabcbb";
        System.out.println("Length of longest substring without repeating characters: " + lengthOfLongestSubstring(input));
    }
}
