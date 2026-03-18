import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LongestCycleInAGraph {
    class Solution {

    public void dfs(int node, boolean[] visited, List<List<Integer>> adj, Stack<Integer> stack){
        visited[node]=true;

        for(int neighbor: adj.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor, visited, adj, stack);
            }

        }

        stack.push(node);
    }

        public void dfs1(int node, boolean[] visited, List<List<Integer>> adj, List<Integer> temp){
        visited[node]=true;
        temp.add(node);

        for(int neighbor: adj.get(node)){
            if(!visited[neighbor]){
                dfs1(neighbor, visited, adj, temp);
            }

        }
    }
    public int longestCycle(int[] edges) {

        List<List<Integer>> adj=new ArrayList<>();




        for(int i=0; i<edges.length; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            if(edges[i]==-1)
            continue;
            adj.get(i).add(edges[i]);
        }

        int n=edges.length;
        boolean[] visited=new boolean[n];
        Stack<Integer> stack=new Stack<>();

        for(int i=0; i<n; i++){
            if(!visited[i])
            dfs(i, visited, adj, stack);
        }
        

        List<List<Integer>> transAdj=new ArrayList<>();

        for(int i=0; i<n; i++)
        transAdj.add(new ArrayList<>());

        for(int u=0; u<n; u++){
            for(int v:adj.get(u)){
                transAdj.get(v).add(u);
            }
        }

        Arrays.fill(visited, false);
        int ans=0;

       while(!stack.isEmpty()){
        int node=stack.pop();

        if(!visited[node]){
            List<Integer> res=new ArrayList<>();
            dfs1(node, visited, transAdj, res);
            if(res.size()>1)
            ans=Math.max(res.size(), ans);
        }
       }

       return ans>1? ans:-1;
    }

    
}
}
