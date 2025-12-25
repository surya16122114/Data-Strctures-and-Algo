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