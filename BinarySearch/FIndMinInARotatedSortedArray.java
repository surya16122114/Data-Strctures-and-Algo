package BinarySearch;

public class FIndMinInARotatedSortedArray {
    class Solution {
        public int findMin(int[] nums) {
            int ans=Integer.MAX_VALUE;
            
            int left=0;
            int right=nums.length-1;
            while(left<=right){
                int mid=left+(right-left)/2;
    
                if(nums[left]<=nums[mid]){
                    ans=Math.min(ans, nums[left]);
                    left=mid+1;
                }
                else
                {
                    ans=Math.min(ans, nums[mid]);
                    right=mid-1;
                }
            }
    
    
            return ans;
        }
    }
}

//leetcode problem link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/