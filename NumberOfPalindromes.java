package DataStructuresAndAlgo;

public class NumberOfPalindromes {
    class Solution {
    int count=0;
    public int countSubstrings(String s) {
        if(s==null || s=="")
        return 0;
        int n=s.length();
        for(int i=0; i<n; i++){
                solve(s,i,i);
                solve(s, i, i+1);
        }
    
        return count;
    }

    public void solve(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            count++;
            left--;
            right++;
        }
    }
}
}


//leetcode problem link: https://leetcode.com/problems/palindromic-substrings/description/
//O(n^2) time and O(1) space solution
//The idea is to consider each character and the gap between each pair of characters as the center of a palindrome and expand around it to count all palindromic substrings.
//We do this for both odd-length and even-length palindromes.
