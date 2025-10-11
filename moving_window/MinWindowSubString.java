package moving_window;

import java.util.HashMap;
import java.util.*;

public class MinWindowSubString {
//provide comment on each line for explanation
    public static String minWindow(String s, String t){
        // If either string is empty, return empty string
        if(s.length() == 0 || t.length() == 0){
            System.out.println("Input string or pattern is empty.");
            return "";
        }
        // Map to store the count of each character in t
        Map<Character, Integer> dictT = new HashMap<>();

        // Count each character in t and store in dictT
        for(Character c: t.toCharArray()){
            dictT.put(c, dictT.getOrDefault(c, 0)+ 1);
        }
        System.out.println("dictT: " + dictT);

        // Map to store the count of characters in the current window
        Map<Character, Integer> windowCounts = new HashMap<>();
        int left = 0, right = 0; // Window pointers
        int valid = 0; // Number of characters that meet the required count
        int minLength = Integer.MAX_VALUE; // Minimum window length found
        int start = 0; // Start index of the minimum window

        // Expand the window by moving right pointer
        while(right < s.length()){
            char c = s.charAt(right); // Get the character at right pointer
            System.out.println("Window expand: right=" + right + ", char='" + c + "'");
            right++; // Move right pointer forward

            // If character is needed, update windowCounts
            if(dictT.containsKey(c)){
                windowCounts.put(c, windowCounts.getOrDefault(c, 0)+1);
                System.out.println("windowCounts after adding: " + windowCounts);
                // If the count matches the required count, increment valid
                if(windowCounts.get(c).intValue() == dictT.get(c).intValue()){
                    valid++;
                    System.out.println("valid incremented: " + valid);
                }
            }
            // When all required characters are matched
            while(valid == dictT.size()){
                System.out.println("All required characters matched. left=" + left + ", right=" + right + ", minLength=" + minLength);
                // Update minimum window if current window is smaller
                if(right - left < minLength){
                    minLength = right - left;
                    start = left;
                    System.out.println("New minLength found: " + minLength + ", start=" + start);
                }

                char d = s.charAt(left); // Get the character at left pointer
                System.out.println("Window shrink: left=" + left + ", char='" + d + "'");
                left++; // Move left pointer forward to shrink window

                // If character is needed, update windowCounts
                if(dictT.containsKey(d)){
                    // If count is exactly what is needed, decrement valid
                    if(windowCounts.get(d).intValue() == dictT.get(d).intValue()){
                        valid--;
                        System.out.println("valid decremented: " + valid);
                    }
                    // Decrement the count in windowCounts
                    windowCounts.put(d, windowCounts.get(d) - 1);
                    System.out.println("windowCounts after removing: " + windowCounts);
                }
            }
        }

        // If no valid window found, return empty string; otherwise, return substring
        if (minLength == Integer.MAX_VALUE) {
            System.out.println("No valid window found.");
            return "";
        } else {
            System.out.println("Result window: start=" + start + ", minLength=" + minLength + ", substring='" + s.substring(start, start + minLength) + "'");
            return s.substring(start, start + minLength);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string s:");
        String s = sc.nextLine();
        System.out.println("Enter the string t:");
        String t = sc.nextLine();
        sc.close();
        String result = minWindow(s, t);
        System.out.println("Minimum window substring: " + result);
    }
    
}
