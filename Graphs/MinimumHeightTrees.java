import java.util.*;


public class MinimumHeightTrees {
    class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1)
        return Arrays.asList(0);

        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0; i<n; i++)
        adj.add(new ArrayList<>());

        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }


        int[] degree=new int[n];

        for(int i=0; i<n; i++){
          
            degree[i]=adj.get(i).size();
        }
        
        Queue<Integer> q=new LinkedList<>();

        for(int i=0; i<n; i++){
            if(degree[i]==1)
            q.offer(i);
        }


        int remaining=n;

        while(remaining>2){
            int leafCount=q.size();

            remaining=remaining-leafCount;

            for(int i=0; i<leafCount; i++){
                int leaf=q.poll();

                for(int neighbor: adj.get(leaf)){
                    degree[neighbor]--;

                    if(degree[neighbor]==1)
                    q.offer(neighbor);
                }
            }
        }

return new ArrayList<>(q);

}



    }


}
