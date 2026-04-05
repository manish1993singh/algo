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
        String s = "abacacbcbb";
        System.out.println("Length of longest substring without repeating characters: " + lengthOfLongestSubstring(input));
    }
}


//longest substing without repeating character is solved with left to right shrinking and growing window pattern.
//It maintains the map of char and the index it appeard.
//It maintains two pointers left and right.
//right keeps moving in a loop, while left waits till a duplicate char is encoutered which is between left and right pointers.
//window keeps growing
//In case of duplicate char, the left is shifted after the char.
//That way the window has srunked to expell the duplicate char it had earliear found.
//It injects the char with its new index.
//It keeps computing the max length with right - left in each loop
//It compares it with previously found max length and picks the max among those.
