package Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans=new ArrayList<>();

        Map<Character, Integer> lastIndex=new HashMap<>();

        int n=s.length();

        for(int i=0; i<n; i++){
            lastIndex.put(s.charAt(i), i);
        }

int size=0; 
int end=0;
        for(int i=0; i<n; i++){
            size++;
            end=Math.max(end, lastIndex.get(s.charAt(i)));

            if(i==end){
                ans.add(size);
                size=0;
            }

        }

        return ans;
    }
}
}
