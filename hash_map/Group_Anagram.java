package hash_map;

import java.util.*;

public class Group_Anagram {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //Input list of strings
        System.out.println("Enter the number of strings:");
        String input = sc.nextLine();
        String[] strs = input.split(",");
        sc.close();

        System.out.println("Grouped Anagrams: " + groupAnagrams(strs));

    }

    public static List<List<String>> groupAnagrams(String[] strs){
        Map<String, List<String>> anagramMap = new HashMap<>();
        for(String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStrKey = new String(charArray);
           
            anagramMap.putIfAbsent(sortedStrKey, new ArrayList<>());
            anagramMap.get(sortedStrKey).add(str);
        }
        return new ArrayList<>(anagramMap.values());
    }
}
