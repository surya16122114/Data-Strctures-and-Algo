/*
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
Leetcode problem link: https://leetcode.com/problems/subsets-ii/
*/
package DataStructuresAndAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        //Sorting because we can skip the duplicates
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        solve(nums, result, 0, curr);
        return result;
    }

    public void solve(int[] nums, List<List<Integer>> result, int index, List<Integer> curr){
        //If we reach the end of the index, we need to add that subset to the result
        if(index>=nums.length){

            //we are storing copy since we use same curr in our recusrion call.if we dont store copy, our result 
            //list will also update based on the curr since it is storing ref if we are not using the copy
            result.add(new ArrayList<>(curr));
            return;
        }

//Inclue the current element
        curr.add(nums[index]);
        //recursively call to add the next element
        solve(nums, result, index+1, curr);
        //remove the current element
        curr.remove(curr.size()-1);
//check for duplicates..if there is a duplicate we will skip that element
        while(index+1<nums.length && nums[index]==nums[index+1])
        index++;
        //Now call for the next element after removing the current element
        solve(nums, result, index+1, curr);
    }

}
