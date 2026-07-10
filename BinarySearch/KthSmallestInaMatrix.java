package BinarySearch;

public class KthSmallestInaMatrix {
    class Solution {
        public int kthSmallest(int[][] mat, int k) {
            // code here

            int left=mat[0][0];
            int n=mat.length;


            int right=mat[n-1][n-1];
            int ans=right;


            while(left<=right){
                int mid=left+(right-left)/2;

                int count=countLessThanMid(mat, k, mid);

                if(count>=k){
                    ans=mid;
                    right=mid-1;
                }
                else
                    left=mid+1;
            }

            return ans;

        }

        public int countLessThanMid(int[][] mat, int k, int target){

            int count=0;
            int n=mat.length;

            int i=n-1;
            int j=0;

            while(i>=0 && j<n){
                if(mat[i][j]<=target){
                    count+=i+1;
                    j++;
                }
                else
                    i--;
            }

            return count;
        }
    }

}
