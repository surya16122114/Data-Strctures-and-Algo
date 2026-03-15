import java.util.ArrayList;
import java.util.Arrays;

public class CriticalAndPseudoCritical {
   class Solution {
    int[] parent;
    int[] size;

    int find(int x){
        if(parent[x]!=x)
        parent[x]=find(parent[x]);

        return parent[x];
    }


    void union(int a, int b){
        int ra=find(a);
        int rb=find(b);
        if(ra!=rb){
            if(size[ra]<size[rb]){
                parent[ra]=rb;
                size[rb]+=size[ra];

            }
            else{
                parent[rb]=ra;
                size[ra]+=size[rb];
            }
        }
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        parent=new int[n];
        size=new int[n];


        int m=edges.length;

        int[][] newEdges=new int[m][4];
     

        for(int i=0; i<m; i++){
            newEdges[i][0]=edges[i][0];
            newEdges[i][1]=edges[i][1];
            newEdges[i][2]=edges[i][2];
            newEdges[i][3]=i;
        }
        Arrays.sort(newEdges, (a,b)->a[2]-b[2]);


        int originalMstWeight=findWeight(newEdges, -1, -1, n);
        List<Integer> critical=new ArrayList<>();
        List<Integer>  pseudoCritical=new ArrayList<>();


        for(int i=0; i<m; i++){
            int weightWithoutEdge=findWeight(newEdges, -1, i,n);

            if(weightWithoutEdge>originalMstWeight){
                critical.add(newEdges[i][3]);
            }
            else{
                int weightWithEdge=findWeight(newEdges,i,-1,n);

                if(weightWithEdge==originalMstWeight){
                    pseudoCritical.add(newEdges[i][3]);
                }
            }
        }

        List<List<Integer>> res=new ArrayList<>();
        res.add(critical);
        res.add(pseudoCritical);
        return res;

        
    }


    public int findWeight(int[][] newEdges, int forceEdge, int skipEdge, int n){

        for(int i=0; i<n; i++){
            parent[i]=i;
            size[i]=1;
        }
        int mst=0;
        int edges=0;
        if(forceEdge!=-1){
            union(newEdges[forceEdge][0], newEdges[forceEdge][1]);

            mst+=newEdges[forceEdge][2];
            edges++;
        }


        //remaining edges;

        for(int i=0; i<newEdges.length; i++){
            if(i==skipEdge)
            continue;

            if(find(newEdges[i][0])!=find(newEdges[i][1])){
                union(newEdges[i][0], newEdges[i][1]);
                mst+=newEdges[i][2];
                edges++;
            }
        }


        if(edges!=n-1)
        return Integer.MAX_VALUE;


        return mst;
    }
} 
}
