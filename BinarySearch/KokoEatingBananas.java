package BinarySearch;

public class KokoEatingBananas {
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            //so the worst k can be the maximum size of piles
            //so start with that size and see whether we can find lesser k
           // k =>1...maxsize
    
           int left=1;
           int right=0;
    
           for(int pile: piles)
           right=Math.max(pile,right);
    
           //initialise answer with max size;
           int res=right;
    
           while(left<=right){
            int mid=left+(right-left)/2;
    
            if(canFinishWithThisK(piles, h, mid)){
                //try the smaller value
                right=mid-1;
                res=mid;
            }
            else{
                left=mid+1;
            }
    
    
           }
    
           return res;
    
    
        }
    
    
        public boolean canFinishWithThisK(int[] piles, int h, int k){
            int hours=0;
    
            for(int pile:piles){
                hours += (pile + k - 1) / k;
    
                if(hours>h)
                return false;
            }
    
          return  hours<=h;
        }
    }
}


//leetcode problem link: https://leetcode.com/problems/koko-eating-bananas/description/