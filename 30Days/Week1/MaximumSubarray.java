// Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

// Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
// We use maxValue to store the maximum value
// currentRunningSum to calculate new sum when ilterate through the array
// Check if new numer make current sum greater or less
// Greater: add more to current sum
// Less: assign new numer to current sum
// Compare maxValue with currentSum to check if it has better sum

public class MaximumSubarray{
    class Solution {
        // O(n) Kadane Algo
        // public int maxSubArray(int[] nums) {
        //     int maxSumValue = Integer.MIN_VALUE;
        //     int currentSum = 0;
        //     for(int i : nums){
        //         currentSum = Math.max(currentSum+i, i); // remove negative sum or numbers
        //         maxSumValue = Math.max(currentSum, maxSumValue);
        //     }
        //     return maxSumValue;            
        // }

        // O(nLogn) Divide and conquer
        public int maxSubArray(int[] nums) {
            return maxSubArray(nums, 0, nums.length-1);
        }
        public int maxSubArray(int[] nums, int start, int end) {
            if(start==end){
                return nums[start];
            }

            int mid = (start+end)/2;
            int leftSum = maxSubArray(nums, start, mid);
            int rightSum = maxSubArray(nums, mid+1, end);
            int crossSum = maxCrossSum(nums, start, mid, end);

            System.out.println("left="+leftSum+" right="+rightSum+" cross="+crossSum);

            return Math.max(leftSum, Math.max(rightSum, crossSum));
        }
        private int maxCrossSum(int[] nums, int start, int mid, int end){
            int leftSum  = Integer.MIN_VALUE;
            int rightSum  = Integer.MIN_VALUE;
            int tempSum = 0;

            for(int i =  mid; i >= start ; i--){
                tempSum += nums[i];
                if(tempSum > leftSum)
                    leftSum = tempSum;
            }

            tempSum = 0;
            for(int i =  mid+1; i <= end ; i++){
                tempSum += nums[i];
                if(tempSum > rightSum)
                    rightSum = tempSum;
            }
            return Math.max(leftSum + rightSum, Math.max(leftSum, rightSum));
        }
    }


    
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,14};
        
        MaximumSubarray obj = new MaximumSubarray();
        MaximumSubarray.Solution sol = obj.new Solution();
        int result = sol.maxSubArray(nums);

        System.out.println(result);

    }

}

