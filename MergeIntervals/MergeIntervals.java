/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
Example 3:

Input: intervals = [[4,7],[1,4]]
Output: [[1,7]]
Explanation: Intervals [1,4] and [4,7] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
 */
 //Leetcode problem link: https://leetcode.com/problems/merge-intervals/
package DataStructuresAndAlgo.MergeIntervals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        //sort by the start time 
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int[] current;
        int[] prev=intervals[0];
        List<int[]> result=new ArrayList<>();
        for(int i=1; i<intervals.length; i++){
            current=intervals[i];
            //if the start time of current is less than the end time of the previous interval obviously we want to merge, but how??
            if(current[0]<=prev[1]){
                //take this example obviously we have to consider the start time of the prev interval as the start tiem of the merged interval but what about the end time??
                //for the end time we have two options.. end time of the prev interval or end time of the current interval
                //[1,3] [2,6]
                prev[1]=Math.max(current[1], prev[1]);
//now the merged becomes prev and we can merge for the rest
            }
            else{
                //what if there is no common to merge..of there is no common we can proceed further but we have to the add the prev to the result
                result.add(prev);
                //Now we processed one item and now we have to make the current as prev
                prev=current;
            }
        }

        //shpuld add the last interval also
        result.add(prev);

        return result.toArray(new int[result.size()][]);
    }
}