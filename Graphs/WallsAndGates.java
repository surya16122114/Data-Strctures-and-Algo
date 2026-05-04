package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m=rooms.length;
        int n=rooms[0].length;

        Queue<int[]> q=new LinkedList<>();

        boolean[][] visited=new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(rooms[i][j]==0){
                    visited[i][j]=true;
                    q.offer(new int[]{i,j,0});
                }
            }
        }


        int[] dx={0, 0, 1, -1};
        int[] dy={-1, 1, 0, 0};

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int row=curr[0];
            int col=curr[1];
            int steps=curr[2];
            rooms[row][col]=steps;
            for(int i=0; i<4; i++){
                int nr=row+dx[i];
                int nc=col+dy[i];

                if(nr>=0 && nr<m && nc>=0 && nc<n && !visited[nr][nc] && rooms[nr][nc]!=-1){
                    q.offer(new int[]{nr, nc, steps+1});
                  
                    visited[nr][nc]=true;
                }
            }
        }


    
        
    }
}
}
