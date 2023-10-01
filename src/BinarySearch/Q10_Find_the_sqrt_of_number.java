package BinarySearch;

/**
 * Binary Search on Answer.
 */

public class Q10_Find_the_sqrt_of_number {

    /**
     * Binary Search
     * Time Complexity - o(log n)
     * Space Complexity - o(1)
     */
    public static int getSqrtOfNumber(int number){
        int low = 1;
        int high = number;
        int answer = 1;
        while(low <= high){
            int mid = (low + high) / 2;

            if(getSquare(mid) <= number){
                answer = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return answer;
    }

    private static int getSquare(int mid){
        return mid * mid;
    }

    public static void main(String[] args) {

    }


}
