import java.util.HashSet;

// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3284/
// Write an algorithm to determine if a number n is happy.

// A happy number is a number defined by the following process:

// Starting with any positive integer, replace the number by the sum of the squares of its digits.
// Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
// Those numbers for which this process ends in 1 are happy.
// Return true if n is a happy number, and false if not.


public class HappyNumber{

    public static void main(String[] args) {
        int[] nums = {4,19,2,1,2,4,6};

        Solution sol = new Solution();
        boolean result = sol.isHappy(nums[1]);

        System.out.println("Happy Number? "+result);

    }

}

class Solution {
    public boolean isHappy(int n) {
    
        HashSet<Integer> hSet = new HashSet<>();
        while(!hSet.contains(n)){
            // add to Hashset 
            hSet.add(n);
            // do square and sum
            n = addSquare(n);
            if(n==1)
                return true;
        }
        return false;
    }

    public int addSquare(int n){
        int sum = 0;

        while(n!=0){
            sum += (n%10) * (n%10);
            n = n/10;
        }
        return sum;
    }
}