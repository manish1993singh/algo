package Binary_Search;

public class PerfectSquare {
    public static boolean isPerfectSquare(int num){
        int low = 0;
        int high = num;
        while(low < high){
            int mid = (high + low)/2;
            int midSq = mid*mid;
            if(midSq == num) return true;
            else if(midSq <= num) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    public static void main(String[] args){
        int num1 = 4;
        System.out.println(isPerfectSquare(num1));
        System.out.println(isPerfectSquare(3));
    }
}