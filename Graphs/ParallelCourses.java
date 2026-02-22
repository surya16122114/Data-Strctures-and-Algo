import java.util.*;
import java.util.LinkedList;

public class ParallelCourses {

    class Solution {
    public int minimumSemesters(int n, int[][] relations) {

        Queue<Integer> q=new LinkedList<>();
        int semesters=0;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
          for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for(int[] rel: relations)
        adj.get(rel[0]).add(rel[1]);
        int[] indegree=new int[n+1];


        for(int i=1; i<=n; i++){
            for(int neighbor: adj.get(i)){
                indegree[neighbor]++;
            }
        }


        for(int i=1; i<=n; i++){
            if(indegree[i]==0)
            q.offer(i);
        }


int reachableCourses=0;
        while(!q.isEmpty()){
            int qsize=q.size();
               semesters++;

            for(int i=0; i<qsize; i++){
                int node=q.poll();
             
             reachableCourses++;

                for(int neighbor: adj.get(node)){
                  indegree[neighbor]--;

                  if(indegree[neighbor]==0)
                  q.offer(neighbor);
                }
            }
        }


        return reachableCourses!=n?-1:semesters;
        
    }
}
    
}
