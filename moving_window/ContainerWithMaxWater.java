package moving_window;

import java.util.*;

public class ContainerWithMaxWater {
    public static int maxArea(int[] height){
        int left = 0, right = 1;
        int maxArea = 0;
        System.out.println("Initial left: " + left + ", right: " + right + ", maxArea: " + maxArea);
        while(right < height.length){
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            System.out.println("left: " + left + ", right: " + right + ", height[left]: " + height[left] + ", height[right]: " + height[right] + ", currentArea: " + currentArea + ", maxArea: " + maxArea);
            maxArea = Math.max(maxArea, currentArea);
            if(height[left] < height[right]){
                left++;
                System.out.println("Increment left to " + left);
            } else {
                right++;
                System.out.println("Increment right to " + right);
            }
        }
        System.out.println("Final maxArea: " + maxArea);
        return maxArea;
    }

    public static void main(String[] args){
            int[] height = {1,8,6,2,5,4,8,3,7};
            System.out.println("Maximum area of water that can be contained: " + maxArea(height));
        }
}
