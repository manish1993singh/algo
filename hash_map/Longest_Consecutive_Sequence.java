package hash_map;

import java.util.*;
public class Longest_Consecutive_Sequence {

    public static int longestConsecutiveSequence(int[] nums){
        // Use a hash set for O(1) membership checks and to remove duplicates.
        Set<Integer> numSet = new HashSet<>();
        for(int num: nums){
            numSet.add(num);
        }

        int longestStreak = 0;

        // Iterate through each unique number in the set.
        for(int num: numSet){
            // Only start counting from the beginning of a sequence.
            // If num - 1 exists, this num is not the start.
            if(!numSet.contains(num - 1)){
                int currentNum = num;
                int currentStreak = 1;

                // Count upwards while the next consecutive integer exists.
                while(numSet.contains(currentNum + 1)){
                    currentNum += 1;
                    currentStreak += 1;
                }

                // Update the maximum streak length found so far.
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args){
        // Take user input as comma-separated integers in one line.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the elements of the array (comma separated):");
        String input = sc.nextLine();
        String[] inputs = input.split(",");
        int[] nums = new int[inputs.length];
        for(int i = 0; i < inputs.length; i++){
            nums[i] = Integer.parseInt(inputs[i].trim());
        }
        sc.close();

        // Print the length of the longest consecutive sequence.
        System.out.println("Length of longest consecutive sequence is: " + longestConsecutiveSequence(nums));
    }
}