import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Binary_search_value_range {
    // This function finds the kth smallest element in the inputList using binary search on the value range.
    // It does NOT modify the input list.
    public int findKthSmallest(List<Integer> inputList, int kthPosition) {
        int minValueInRange = 1, maxValueInRange = 20; // Range of possible values in the list
        int kthSmallestValue = -1; // Will hold the answer

        System.out.println("Starting binary search for kth smallest value...");
        System.out.println("Initial value range: min=" + minValueInRange + ", max=" + maxValueInRange);

        // Binary search over the value range
        while (minValueInRange <= maxValueInRange) {
            int midValue = minValueInRange + (maxValueInRange - minValueInRange) / 2;
            int countOfElementsLessOrEqual = countLessOrEqual(inputList, midValue);

            System.out.println("Checking midValue=" + midValue + ": countOfElementsLessOrEqual=" + countOfElementsLessOrEqual);

            if (countOfElementsLessOrEqual >= kthPosition) {
                kthSmallestValue = midValue; // Store as potential answer
                System.out.println("Found at least " + kthPosition + " elements <= " + midValue + ". Updating answer to " + midValue);
                maxValueInRange = midValue - 1; // Try to find a smaller valid value
                System.out.println("Narrowing search to lower half: min=" + minValueInRange + ", max=" + maxValueInRange);
            } else {
                minValueInRange = midValue + 1;
                System.out.println("Not enough elements <= " + midValue + ". Searching upper half: min=" + minValueInRange + ", max=" + maxValueInRange);
            }
        }

        System.out.println("Binary search complete. kth smallest value is " + kthSmallestValue);
        return kthSmallestValue;
    }

    // Helper function: Counts how many elements in inputList are less than or equal to the given value
    private static int countLessOrEqual(List<Integer> inputList, int value) {
        int count = 0;
        for (int element : inputList) {
            if (element <= value) {
                count++;
            }
        }
        System.out.println("Count of elements <= " + value + " is " + count);
        return count;
    }

    public static void main(String[] args) {
        System.out.println("running");
        // Example input: [8, 10, 4, 3, 20, 15]
        List<Integer> inputList = new ArrayList<Integer>(Arrays.asList(8, 10, 4, 3, 20, 15));
        int kthPosition = 2; // We want the 2nd smallest element
        // Call the function and print the result
        int kthSmallestValue = new Binary_search_value_range().findKthSmallest(inputList, kthPosition);
        System.out.println(kthSmallestValue); // Output should be 4
    }

}
