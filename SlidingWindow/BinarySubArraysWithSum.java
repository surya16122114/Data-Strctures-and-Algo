package SlidingWindow;

/*
Leetcode problem link: https://leetcode.com/problems/binary-subarrays-with-sum/description/
Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.

 

Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15
 

Constraints:

1 <= nums.length <= 3 * 104
nums[i] is either 0 or 1.
0 <= goal <= nums.length
 */



public class BinarySubArraysWithSum {

    class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        //at most(k)-atmost(k-1)

        return numSubArrays(nums, goal)-numSubArrays(nums, goal-1);


        
    }


    public int numSubArrays(int[] nums, int goal){
        if(goal<0)
        return 0;


        int left=0;
        int right=0;

        //the trick is to remember that when we add the next element, the count of subarrays increases by the current winodw size...
        //becoz think how many sub arrays end with the current element

int sum=0;
int res=0;

        while(right<nums.length){

            sum+=nums[right];

           while(sum>goal){
            sum-=nums[left];
            left++;
           }

        res+=right-left+1;

        right++;

        }

        return res;
    }
}
    
}
