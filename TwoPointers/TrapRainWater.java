package TwoPointers;
public class TrapRainWater {
    class Solution {
        public int trap(int[] height) {
            int res=0;
            int low=0;
            int high=height.length-1;
    
            int left=height[0];
            int right=height[high];
    
    
            while(low<high){
    
                if(left<right){
                    low++;
                    left=Math.max(left, height[low]);
                    res=res+left-height[low];
                }
    
                else{
                    high--;
                    right=Math.max(right, height[high]);
                    res=res+right-height[high];
                }
            }
    
    
            return res;
    
    
    
    
        }
    }
}
