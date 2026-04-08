package task_schedular;

import java.util.Arrays;

public class TaskMaxTime {
    private static int getScheduled(char[] tasks, int n){
        int[] frequency = new int[26];
        for(char task: tasks){
            frequency[task - 'A']++;
        }

        Arrays.sort(frequency);

        int f = frequency[25];
        int m = 1;
        for(int i = 24; i >= 0; i--){
            if(frequency[i] == f){
                m++;
            }else{
                break;
            }
        }

        int calculatedTime = (f - 1)*(n+1)+m;
        return Math.max(tasks.length, calculatedTime);
    }

    public static void main(String[] args){
        System.out.println(getScheduled(new char[]{'A','A','A','B','B','B'}, 2));
    }
}
