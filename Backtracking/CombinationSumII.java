/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.


Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
 
Leetcode problem link: https://leetcode.com/problems/combination-sum-ii/
 */


package DataStructuresAndAlgo.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //Sort them
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        solve(candidates, target, curr, res, 0);
        return res;
    }

    public void solve(int[] candidates, int target, List<Integer> curr, List<List<Integer>> res, int index){
        //when we got the subset with target sum
        if(target==0){
            res.add(new ArrayList<>(curr));
            return;
        }

        //when we dont find the sum and reached the end of the array
        if(index>candidates.length-1)
        return;
//we only take the current element if it is less than the target if not else case
        if(candidates[index]<=target){
            curr.add(candidates[index]);
            //call for the next element
            solve(candidates, target-candidates[index], curr, res, index+1);
            //remove the current element and process the recursion
            curr.remove(curr.size()-1);
            //process the duplicates
             while(index+1<candidates.length && candidates[index]==candidates[index+1])
                index++;
                
            solve(candidates, target, curr, res, index+1);
        }

        else{
            //if the candidate is greater than we simply skip the element
            solve(candidates, target, curr, res, index+1);
        }
    }
}
}
