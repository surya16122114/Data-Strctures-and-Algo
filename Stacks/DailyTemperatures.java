import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {
    class Solution {
    
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
         int[] res = new int[n];
        Deque<Integer> st = new ArrayDeque<>(); // store indices

        for (int i = n-1; i >=0; i--) {
           //pop until you find bigger element than current element
            while (!st.isEmpty() &&  temperatures[i]>=temperatures[st.peek()]) {
                st.pop();
            }
            //if u find bigger element, add the difference of index to the result array
            if(!st.isEmpty()){
                res[i]=st.peek()-i;
            }

            st.push(i);
        }
        return res;
        
    }
}
}
