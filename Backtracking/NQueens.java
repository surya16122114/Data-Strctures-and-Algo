package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res=new ArrayList<>();
        char[][] nQueens=new char[n][n];
        for(int i = 0; i < n; i++) {
    for(int j = 0; j < n; j++) {
        nQueens[i][j] = '.';
    }
}

        solve(nQueens, 0, res);

        return res;
        
    }


    public void solve(char[][] nQueens, int row, List<List<String>> res){
        if(row==nQueens.length)
        {
            res.add(construct(nQueens));
            return;
        }

        for(int col=0; col<nQueens.length; col++){
            if(isSafe(nQueens, row, col)){
                nQueens[row][col]='Q';

                solve(nQueens, row+1, res);

                nQueens[row][col]='.';
            }
        }
    }


    public boolean isSafe(char[][] nQueens, int row, int col){


        for(int i=0; i<row; i++){
            if(nQueens[i][col]=='Q')
            return false;
        }


        for(int i=row, j=col; i>=0 && j>=0; i--, j--){
            if(nQueens[i][j]=='Q')
            return false;
        }

        for(int i=row, j=col; i>=0 && j<nQueens.length; i--, j++){
            if(nQueens[i][j]=='Q')
            return false;
        }

        return true;
    }



    public List<String> construct(char[][] nQueens){
        List<String> temp=new ArrayList<>();
        for(char[] row: nQueens){
            temp.add(new String(row));
        }

        return temp;
    }
}
}

//leetcode problem link: https://leetcode.com/problems/n-queens/description/