package backtracking_algo;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    private static List<List<String>> partition(String str){
        List<List<String>> result = new ArrayList<>();
        backtrack(str, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(String s, int start, List<String> currentPath, List<List<String>> result){
        if(start == s.length()){
            result.add(new ArrayList<>(currentPath));
            return;
        }

        for(int end = start + 1; end <= s.length(); end++){
            String subString = s.substring(start, end);

            if(isPalindrome(subString)){
                currentPath.add(subString);
                backtrack(s, end, currentPath, result);
                currentPath.remove(currentPath.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String str){
        int i = 0;
        int j = str.length() -1;
        while(i < j){
            if(str.charAt(i++) != str.charAt(j--)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("aabaa"));
        // Output: [[a, a, b], [aa, b]]
    }
}