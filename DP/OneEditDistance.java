package DP;

public class OneEditDistance {
    class Solution {
    public boolean isOneEditDistance(String s, String t) {
     
        int m=s.length();
        int n=t.length();
        if(Math.abs(m-n)>1)
        return false;

int i=0;
int j=0;

int ans=0;
        while(i<m && j<n){

            if(s.charAt(i)!=t.charAt(j)){
                ans++;


                if(ans>1)
                return false;


                if(m==n)
                {
                    i++;
                    j++;
                }

                else if(m<n){
                    j++;
                }

                else
                i++;

            }

            else{
                i++;
                j++;
            }

        }

        ans+=m-i+n-j;
      

        return ans==1;

        
    }

   
}
    

}
