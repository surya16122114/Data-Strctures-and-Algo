package DataStructuresAndAlgo;

public class LongestPalindromicSubstring {
    class Solution {
    public String longestPalindrome(String s) {
        String res="";
        int n=s.length();
        if(n==1 || n==0)
        return s;

        int start=1;
        int end=1;

        int[][] dp=new int[n][n];
        //single character is always a palindrome
        for(int i=0; i<n; i++){
            dp[i][i]=1;
        }
        //dp[i][j] represents whether s[i...j] is a palindrome or not
        //even palindrome of size 2
        for(int i=0; i<n-1; i++){
            if(s.charAt(i)==s.charAt(i+1)){
                 dp[i][i+1]=1;
 start=i;
 end=i+1;
            }

        }
               
//now we will cover for size 3 till n thats y i<=n not i<n
        for(int i=3; i<=n; i++){
            //we are finding whether each i length substring is palindrome or not we r doing that in inner loop
            for(int j=i; j<=n; j++){
                //we are checking if start and end of the substring are euqla and the subtsring excluding starting ans ending are also equal then the whole substring is a plaindrome
                if(s.charAt(j-1)==s.charAt(j-i) && dp[j-i+1][j-2]==1){
                    dp[j-i][j-1]=1;
                    start=j-i;
                    end=j-1;
                }
                else{
                    dp[j-i][j-1]=0;
                }
            }
        }

        for(int i=start; i<=end; i++){
            res+=s.charAt(i);

        }
        return res;
            }
}
}
