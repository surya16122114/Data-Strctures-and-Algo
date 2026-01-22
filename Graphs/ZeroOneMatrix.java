import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        boolean[][] visited=new boolean[m][n];

        int[][] res=new int[m][n];

        Queue<Tuple> q= new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]==0){
                    q.offer(new Tuple(i,j,0));
                    visited[i][j]=true;
                }
            }
        }
int dx[]={-1,1,0,0};
int dy[]={0,0,-1,1};
        while(!q.isEmpty()){
            Tuple t=q.poll();
            int currrow=t.row;
            int currcol=t.col;
            int steps=t.steps;
            res[currrow][currcol]=steps;


            for(int i=0; i<4; i++){
                int nr=currrow+dx[i];
                int nc=currcol+dy[i];

                if(nr>=0 && nc>=0 && nr<m && nc<n && !visited[nr][nc]){
                    visited[nr][nc]=true;
                    q.offer(new Tuple(nr,nc, steps+1));
                }
            }
        }

        return res;
    }
}

class Tuple{
    int row;
    int col;
    int steps;
    public Tuple(int row, int col, int steps){
        this.row=row;
        this.col=col;
        this.steps=steps;
    }
}
}
