package Trees;

import java.util.Arrays;

public class NumberOfBST {
  class Solution {
    public int numTrees(int n) {
       int[] trees=new int[n+1];
       Arrays.fill(trees, 1) ;

       for(int i=2; i<=n; i++){
        int totalTrees=0;
        for(int root=1; root<=i; root++){
            totalTrees+=trees[root-1]*trees[i-root];
        }

        trees[i]=totalTrees;
       }  


       return trees[n];  
    }
}
}
