package Monotonic_stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Next_hot_day {

    private static List<Integer> getNextHotDay(List<Integer> temperatures){
        List<Integer> result = new ArrayList<>(Collections.nCopies(temperatures.size(), 0));
        Stack<Integer> monotonicStack = new Stack<>();

        for(int i = 0; i < temperatures.size(); i++){
            int currentTemp = temperatures.get(i);
            while (!monotonicStack.empty() && currentTemp > temperatures.get(monotonicStack.peek())) {

                int lastTemperatureIndex = monotonicStack.pop();
                result.set(lastTemperatureIndex, i - lastTemperatureIndex);
                
            }

            monotonicStack.push(i);
        }

        return result;
    }


    public static void main(String[] args){
        System.out.println(getNextHotDay(List.of(73,74,75,71,69,72,76,73)));
    }
}
