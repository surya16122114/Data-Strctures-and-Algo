package BinarySearch;
import java.util.Arrays;

public class MagneticForceBetweenTowBalls {
    class Solution {
        public int maxDistance(int[] position, int m) {

            Arrays.sort(position);

            int n=position.length;
            int ans=0;
            int minGap=1;
            int maxGap=position[n-1]-position[0];

            int left=minGap;
            int right=maxGap;


            while(left<=right){
                int mid=(left)+(right-left)/2;

                if(canPlace(position, m, mid)){
                    ans=mid;
                    left=mid+1;

                }
                else{
                    right=mid-1;
                }
            }

            return ans;

        }


        public boolean canPlace(int[] position, int m, int gap){

            int count=1;

            int lastPos=position[0];


            for(int i=1; i<position.length; i++){
                if(position[i]-lastPos>=gap)
                {
                    count++;

                    lastPos=position[i];
                }


                if(count==m)
                    return true;
            }

            return false;


        }
    }
}
