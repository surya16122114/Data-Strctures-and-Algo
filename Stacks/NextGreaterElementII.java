package Stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementII {
   class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Stack<Integer> st=new Stack<>();

        int n2=nums2.length;
        Map<Integer, Integer> m=new HashMap<>();

        for(int i=n2-1; i>=0; i--){

            while(!st.isEmpty() && nums2[i]>st.peek())
            st.pop();

            if(!st.isEmpty())
            m.put(nums2[i], st.peek());
            else
            m.put(nums2[i], -1);
            st.push(nums2[i]);
        }

        int n1=nums1.length;
        int[] res=new int[n1];

        for(int i=0; i<n1; i++){
            res[i]=m.get(nums1[i]);
        }

        return res;
    }
} 
}
