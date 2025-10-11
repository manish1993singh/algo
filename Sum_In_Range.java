import java.util.ArrayList;
import java.util.Arrays;

public class Sum_In_Range {
    public int numRange(ArrayList<Integer> A, int B, int C) {
        
        int count = 0;
        for(int i = 0; i < A.size(); i++){
            int sum = 0;
            int nextEleIndex = i;
            while(nextEleIndex <= A.size() - 1){
                int nextEle = A.get(nextEleIndex);
                sum += nextEle;
                nextEleIndex++;
                if(sum >= B && sum <= C ){
                    count++;   
                }
                else if(sum > C){
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        // ArrayList<Integer> list = new ArrayList<>(Arrays.asList(80, 97, 78, 45, 23, 38, 38, 93, 83, 16, 91, 69, 18, 82, 60, 50, 61, 70, 15, 6, 52, 90 ));
        // int result = new Sum_In_Range().numRange(list, 99, 269);


        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(76, 22, 81, 77, 95, 23, 27, 35, 24, 38, 15, 90, 19, 46, 53, 6, 77, 96, 100, 85, 43, 16, 73, 18, 7, 66 ));
        int result = new Sum_In_Range().numRange(list, 98, 290);
        
        // ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 5, 1, 0, 2));
        // int result = new Sum_In_Range().numRange(list, 6, 8);
        System.out.println(result);
    }
}