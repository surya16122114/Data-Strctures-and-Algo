package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
       

        List<List<Integer>> res=new ArrayList<>();


        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i]==nums[i-1])
            continue;
                int j=i+1;
                 int k=nums.length-1;
                while(j<k){
                    
                    if(nums[i]+nums[j]+nums[k]==0){
                            List<Integer> ans=new ArrayList<>();

                            ans.add(nums[i]);
                             ans.add(nums[j]);
                              ans.add(nums[k]);
                              res.add(ans);

                              while(j<k && nums[j]==nums[j+1]){
                                j++;
                              }

                              while(j<k && nums[k]==nums[k-1])
                              k--;


                              j++;
                              k--;
                    }

                    else if(nums[i]+nums[j]+nums[k]>0)
                    k--;

                    else
                    j++;
                }

        }

        return res;
     
    }
}
}


//leetcode problem link: https://leetcode.com/problems/3sum/description/
