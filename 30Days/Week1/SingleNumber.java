// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3283/
// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
// Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?

public class SingleNumber{
    class Solution {
        public int singleNumber(int[] nums) {
            for (int i=1;i<nums.length; i++) {
                nums[0] ^= nums[i]; 
            }
            
            return nums[0];        
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2,4,6};

        SingleNumber obj = new SingleNumber();
        SingleNumber.Solution sol = obj.new Solution();

        int result = sol.singleNumber(nums);

        System.out.println(result);

    }

}

