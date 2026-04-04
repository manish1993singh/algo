package moving_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sub_array_k_element {
    
    public static int findFrequency(List<Integer> arr, int k){
        int count = 0;
        int currentSum = 0;

        Map<Integer, Integer> frequencyMap = new HashMap<>(Map.of(0,1));

        for(int i: arr){

            currentSum += i;

            int frequencyKey = currentSum - k;
            if(frequencyMap.containsKey(frequencyKey)){
                count += frequencyMap.get(frequencyKey);
            }
            
            frequencyMap.put(currentSum, frequencyMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static List<List<Integer>> findSubarray(List<Integer> arr, int k){
        int currentSum = 0;
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        indexMap.put(0, new ArrayList<>(List.of(-1)));
        List<List<Integer>> result = new ArrayList<>();

        for(int currentIndex = 0; currentIndex < arr.size(); currentIndex++){
            int currentNum = arr.get(currentIndex);
            currentSum += currentNum;
            int compliment = currentSum - k;
            if(indexMap.containsKey(compliment)){

                for(int startIndex: indexMap.get(compliment)){
                    result.add(arr.subList(startIndex+1, currentIndex+1));
                }
            }
            indexMap.computeIfAbsent(currentSum, key -> new ArrayList<>()).add(currentIndex);
        }

        return result;
    }

    public static void main(String[] arr){
        List<Integer> input1 = List.of(1,2,3,3,2,-2);
        int k1 = 3;
        System.out.println(findFrequency(input1, k1));
        System.out.println(findSubarray(input1, k1));

        List<Integer> input2 = List.of(1,1,2,3,-2,0, -2, 4, 0,1);
        int k2 = 3;
        System.out.println(findFrequency(input2, k2));
        System.out.println(findSubarray(input2, k2));

        List<Integer> input3 = List.of(1,-1,5,-2,3);
        int k3 = 3;
        System.out.println(findFrequency(input3, k3));
        System.out.println(findSubarray(List.of(1,-1,5,-2,3), k3));
    }
}
