package BinarySearch;

public class MinimumNumberOfDaysToMakeMBouquets {

    class Solution {
        public int minDays(int[] bloomDay, int m, int k) {

            int left=1;
            int right=Integer.MIN_VALUE;

            for(int day: bloomDay)
                right=Math.max(right, day);

            int ans=-1;


            while(left<=right){
                int mid=(left)+(right-left)/2;

                if(isBouquetPossible(bloomDay, m, k, mid)){
                    ans=mid;
                    right=mid-1;
                }
                else
                    left=mid+1;
            }


            return ans;

        }


        public boolean isBouquetPossible(int[] bloomDay, int m, int k, int days){

            int bouquetCount=0;

            int i=0;

            while(i<bloomDay.length){

                int j=i;
                int kCount=0;

                while(j<bloomDay.length && bloomDay[j]<=days && kCount<k){
                    j++;
                    kCount++;
                }

                if(kCount==k){
                    bouquetCount++;
                    if(bouquetCount==m)
                        return true;

                    i=j;



                }

                else{
                    i=j+1;
                }

            }


            return false;
        }
    }
}
