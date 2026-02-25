package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        res.add(new ArrayList<>());
        solve(res, ans, 0, nums);
        return res;
        
    }

       public void solve(List<List<Integer>> res, List<Integer> ans, int index, int[] nums){



        if(index>nums.length-1)
        return;
        
              ans.add(nums[index]);
               res.add(new ArrayList<>(ans));

        solve(res, ans, index+1, nums);
        ans.remove(ans.size()-1);

        
  
        solve(res, ans, index+1,nums);
       

      

    }
}
}
