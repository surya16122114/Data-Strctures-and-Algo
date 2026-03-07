package Backtracking;

public class NQueensII {
   class Solution {
    int count=0;
    public int totalNQueens(int n) {
        char[][] nQueens=new char[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                nQueens[i][j]='.';
            }
        }

    solve(nQueens,0,n);
        return count;
    }


    public void solve(char[][] nQueens, int row, int n){

        //if we reach out of rows
        if(row==n){
            count++;
            return;

        }


        //now try to put in different colums


        for(int col=0; col<n; col++){
            if(isSafe(nQueens, row, col)){
                nQueens[row][col]='Q';

                //now call for diff row


                solve(nQueens, row+1, n);

                nQueens[row][col]='.';
            }
        }
    }


    public boolean isSafe(char[][] nQueens, int row, int col){


//column check;
        for(int i=0; i<row; i++){
            if(nQueens[i][col]=='Q')
            return false;
        }



        //left diagonal check

         for(int i=row, j=col; i>=0 && j>=0; i--, j--){
            if(nQueens[i][j]=='Q')
            return false;
        }


//right diagonal check
        for(int i=row, j=col; i>=0 && j<nQueens.length; i--, j++){
            if(nQueens[i][j]=='Q')
            return false;
        }

        return true;

    }



} 
}


//leetcode problem link: https://leetcode.com/problems/n-queens-ii/description/
