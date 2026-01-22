import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {
    class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> q=new ArrayDeque<>();
        for(int i=0; i<m ; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2)
                q.offer(new int[]{i,j});
            }
        }

        int timer=0;
        int dx[]={-1, 1, 0, 0};
        int dy[]={0,0,-1, 1};



        while(!q.isEmpty()){
            int size=q.size();
            boolean haveURottedThisMinute=false;
            for(int i=0; i<size; i++){
                int[] curr=q.poll();
                int r=curr[0];
                int c=curr[1];

                for(int k=0; k<4; k++){
                    int nr=r+dx[k];
                    int nc=c+dy[k];

                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        q.offer(new int[]{nr, nc});
                        //if u dont put this when u dont have anything to rot, the timer still increases. But it should not happen.
                        haveURottedThisMinute=true;
                    }
                }
            }

            if(haveURottedThisMinute)
            timer++;
        }
 for(int i=0; i<m ; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1)
                return -1;
            }
        }
  return timer;   }

   
}
}


