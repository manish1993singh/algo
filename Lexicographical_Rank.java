import java.util.*;

public class Lexicographical_Rank {
    public int findRank(String A) {
        int n = A.length();
        int rank = 1; // Ranks are 1-based
        int mod = 1000003; // To avoid overflow for large calculations
        int rank_2 = 1;
        // Factorial values for efficient computation
        int[] factorial = new int[n + 1];
        computeFactorials(factorial, n, mod);

        for (int i = 0; i < n; i++) {
            int smallerChars = countSmallerChars(A, i);
            int smallerCharCount_2 = smallerChars(A.charAt(i), A, i);
            int permutation_1 = factorial[n - i - 1]; // (n - i - 1)! % mod
            int permutation_2 = permutation(n - i - 1);

            rank = (rank + smallerChars * factorial[n - i - 1]) % mod;
            rank_2 = (rank_2 + smallerCharCount_2 * permutation_2) % mod;
        }

        return rank;
    }

    private void computeFactorials(int[] factorial, int n, int mod) {
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = (factorial[i - 1] * i) % mod;
        }
    }

    private int countSmallerChars(String A, int index) {
        int count = 0;
        char current = A.charAt(index);
        for (int i = index + 1; i < A.length(); i++) {
            if (A.charAt(i) < current) {
                count++;
            }
        }
        return count;
    }

    public int smallerChars(char c, String s, int index){
                int count = 0;
                for(int i = index + 1; i < s.length(); i++){
                    if(c > s.charAt(i)){
                        count++;
                    }
                }
                return count;
            }
            
            public int permutation(int value){
                int permutation = 1;
                while(value > 1){
                    permutation = (permutation * value--)%1000003;
                }
                permutation = permutation%1000003;
                return permutation;
            }

    public static void main(String[] args) {
        Lexicographical_Rank solution = new Lexicographical_Rank();
        String A = "ZCSFLVHXRYJQKWABGT";
        System.out.println("Rank of the string \"" + A + "\": " + solution.findRank(A));
    }
}


// public class Lexicographical_Rank {
//     public int findRank(String A) {
//         //iterate over each character in the String
//         //compute the rank in each iteration and keep adding the rank
//         //rank computation logic:
//         //find all the smaller characters after the current character in the string position
//         //compute the permutation for the current position and multiply by all smaller charaters as it will
//         //repeat for each character
//         int rank = 1;
//         int size = A.length();
//         for(int i = 0; i < size; i++){
//             int smallerCharCount = smallerChars(A.charAt(i), A, i);
//             int permutation = permutation(size - 1 - i);
//             rank = (rank + smallerCharCount * permutation)%1000003;
//         }
        
//         return rank;
//     }
    
//     public int smallerChars(char c, String s, int index){
//         int count = 0;
//         for(int i = index + 1; i < s.length(); i++){
//             if(c > s.charAt(i)){
//                 count++;
//             }
//         }
//         return count;
//     }
    
//     public int permutation(int value){
//         int permutation = 1;
//         while(value > 1){
//             permutation *= value--;
//         }
//         permutation = permutation%1000003;
//         return permutation;
//     }

//     public static void main(String[] args) {
//         Lexicographical_Rank solution = new Lexicographical_Rank();
//         String A = "ZCSFLVHXRYJQKWABGT";
//         System.out.println("Rank of the string \"" + A + "\": " + solution.findRank(A));
//     }
// }

