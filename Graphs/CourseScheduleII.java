import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseScheduleII {
    
}class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
             List<List<Integer>> adj=new ArrayList<>();

          
             Stack<Integer> st=new Stack<>();
        int m=numCourses;
         int[] res=new int[m];
        boolean[] visited=new boolean[m];
        boolean[] dfsVisited=new boolean[m];

        for(int i=0; i<m; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
    int course = p[0];
    int prereq = p[1];
    adj.get(prereq).add(course); 
}

        for(int i=0; i<m; i++){
            if(!visited[i] ){
                if(detectCycle(adj,visited, dfsVisited,i, st))
                return new int[]{};
            }
        }
int i=0;
      while(!st.isEmpty()){
        res[i++]=st.pop();
      }

      return res;
    }


    public boolean detectCycle(List<List<Integer>> adj,boolean[] visited, boolean[] dfsVisited, int start, Stack<Integer> st){
        visited[start]=true;
        dfsVisited[start]=true;

        for(int neighbor:adj.get(start)){
            if(!visited[neighbor]){
                if(detectCycle(adj,visited, dfsVisited, neighbor,st)) return true;
            }

            else if(dfsVisited[neighbor])
            return true;
        }

        dfsVisited[start]=false;
        st.push(start);
        return false;
    }
}

