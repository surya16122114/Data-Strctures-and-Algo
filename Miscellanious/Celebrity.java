package Miscellanious;

public class Celebrity {
    /* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {

        int[] outdegree=new int[n];
        int[] indegree=new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j)
                continue;
                if( knows(i,j))
                outdegree[i]++;
            }
        }

          for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j)
                continue;
                if( knows(j,i))
                indegree[i]++;
            }
        }



        for(int i=0; i<n; i++){
            if(outdegree[i]==0 && indegree[i]==n-1)
            return i;
        }

        return -1;

       
        
    }
}
}

//leetcode problem link: https://leetcode.com/problems/find-the-celebrity/description/

//time complexity: O(n^2) because of the nested loops to calculate indegree and outdegree for each person.
//space complexity: O(n) because of the two arrays used to store indegree and outdegree for each person.

//we can solve this problem in O(n) time and O(1) space.