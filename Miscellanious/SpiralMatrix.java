package Miscellanious;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowStart=0;
        int rowEnd=matrix.length-1;
        int columnStart=0;
        int columnEnd=matrix[0].length-1;

List<Integer> list=new ArrayList<>();
    while(rowStart<=rowEnd && columnStart<=columnEnd){

        for(int i=columnStart; i<=columnEnd; i++)
        list.add(matrix[rowStart][i]);

        rowStart++;

        for(int i=rowStart; i<=rowEnd; i++)
        list.add(matrix[i][columnEnd]);
        columnEnd--;

  if (rowStart <= rowEnd) {
        for (int i = columnEnd; i >= columnStart; i--)
            list.add(matrix[rowEnd][i]);
        rowEnd--;
    }
       
if (columnStart <= columnEnd) {
        for (int i = rowEnd; i >= rowStart; i--)
            list.add(matrix[i][columnStart]);
        columnStart++;
    }
    }

    return list;

    }
}
}
