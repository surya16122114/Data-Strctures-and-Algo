package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();

        int n=nums.length;

        boolean[] visited=new boolean[n];
    solve(nums, res,temp, visited);
        return res;
        
    }

    public void solve(int[] nums,  List<List<Integer>> res, List<Integer> temp,   boolean[] visited){
        if(temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }


        for(int i=0; i<nums.length; i++){
            if(!visited[i]){
                visited[i]=true;
                temp.add(nums[i]);

                solve(nums, res, temp, visited);
                temp.remove(temp.size()-1);
                visited[i]=false;
            }
        }
    }
}
}
