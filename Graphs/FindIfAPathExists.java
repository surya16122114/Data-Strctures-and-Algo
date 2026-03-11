public class FindIfAPathExists {
    class Solution {
       int[] parent;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //using dsu

     
     parent =new int[n];
        for(int i=0; i<n; i++)
        parent[i]=-1;

        for(int[] edge:edges)
        union(edge[0], edge[1]);


        return find(source)==find(destination);
    }


    public int find(int x){
        if(parent[x]<0)
        return x;

        parent[x]=find(parent[x]);

        return parent[x];
    }


    public void union(int a, int b){
        int parentA=find(a);
        int parentB=find(b);

        if(parentA==parentB)
        return;


        if(parent[parentA]<parent[parentB]){
            parent[parentA]=parent[parentA]+parent[parentB];
            parent[parentB]=parentA;
        }
        else{
            parent[parentB]+=parent[parentA];
            parent[parentA]=parentB;
        }
    }
}
}
