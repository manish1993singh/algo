import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    private static boolean checkPresence(ArrayList<Integer> arr){
        // Check if any element is even
        return arr.stream().anyMatch(x -> x % 2 == 0);
    }

    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 3, 5, 2, 4, 6));  // 1D ArrayList
        System.out.println(checkPresence(arr));  // Output: true (2, 4, 6 are even)
    }
}
