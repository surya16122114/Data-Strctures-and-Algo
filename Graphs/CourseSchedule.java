import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj=new ArrayList<>();
        int m=numCourses;
      
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
                if(detectCycle(adj,visited, dfsVisited,i))
                return false;
            }
        }

        return true;
        
    }


    public boolean detectCycle(List<List<Integer>> adj,boolean[] visited, boolean[] dfsVisited, int start){
        visited[start]=true;
        dfsVisited[start]=true;

        for(int neighbor:adj.get(start)){
            if(!visited[neighbor]){
                if(detectCycle(adj,visited, dfsVisited, neighbor)) return true;
            }

            else if(dfsVisited[neighbor])
            return true;
        }

        dfsVisited[start]=false;
        return false;
    }
}
}
