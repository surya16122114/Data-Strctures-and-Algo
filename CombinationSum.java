//problem statement: https://leetcode.com/problems/combination-sum/
/*Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
 

Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40
*/
package DataStructuresAndAlgo;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            //since we can use the same element any number of times, we will process the recursion with the same index again
            solve(candidates, target-candidates[index], curr, res, index);
            //remove the current element and process the recursion
            curr.remove(curr.size()-1);
            solve(candidates, target, curr, res, index+1);
        }

        else{
            //if the candidate is greater than we simply skip the element
            solve(candidates, target, curr, res, index+1);
        }
    }
}
