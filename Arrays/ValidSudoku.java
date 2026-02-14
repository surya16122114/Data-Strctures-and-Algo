import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
    class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowHashSet=new HashMap<>();
         Map<Integer, Set<Character>> colHashSet=new HashMap<>();
          Map<String, Set<Character>> squareHashSet=new HashMap<>();

          for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]=='.')
                continue;

                String squareKey=i/3+","+j/3;

                rowHashSet.putIfAbsent(i, new HashSet<>());
                 colHashSet.putIfAbsent(j, new HashSet<>());
                  squareHashSet.putIfAbsent(squareKey, new HashSet<>());

                  if(rowHashSet.get(i).contains(board[i][j]) ||colHashSet.get(j).contains(board[i][j])
                  || squareHashSet.get(squareKey).contains(board[i][j]))

                  return false;


                  rowHashSet.get(i).add(board[i][j]);
                  colHashSet.get(j).add(board[i][j]);
                  squareHashSet.get(squareKey).add(board[i][j]);

            }


          }


          return true;
    }
}
}
