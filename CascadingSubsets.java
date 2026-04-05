import java.util.ArrayList;
import java.util.List;

public class CascadingSubsets {
    
    public List<List<Integer>> generateSubsets(int[] nums) {
        // Start with a list containing one empty subset: [[]]
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        // Process each number in the input array one by one
        for (int num : nums) {
            int size = result.size();
            
            // Take all existing subsets and create NEW ones by adding 'num'
            for (int i = 0; i < size; i++) {
                // Create a copy of the existing subset
                List<Integer> newSubset = new ArrayList<>(result.get(i));
                // Add the current number to the copy
                newSubset.add(num);
                // Add this new subset back into our results list
                result.add(newSubset);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        CascadingSubsets solver = new CascadingSubsets();
        int[] nums = {1, 2, 3, 4};
        System.out.println("All Subsets: " + solver.generateSubsets(nums));
    }
}