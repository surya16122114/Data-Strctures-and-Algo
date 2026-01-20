package DataStructuresAndAlgo.TwoPointers;

public class ValidPalindrome {
    class Solution {
    public boolean isPalindrome(String s) {



        //Approach 3 O(n) and O(1)
int i=0; 
int j=s.length()-1;
while(i<=j){
    while(i<j && !Character.isLetterOrDigit(s.charAt(i)))
    i++;
    while(i<j && !Character.isLetterOrDigit(s.charAt(j)))
    j--;

    if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j)))
    return false;
    i++;
    j--;
}

return true;

        /*
        Approach--1
        naive approach..O(n) amd O(n)
        StringBuilder  sb=new StringBuilder();
        for(char ch: s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                sb.append(Character.toLowerCase(ch));
            }
        }

        String newString=sb.toString();
        int n=newString.length();
        int i=0;
        int j=n-1;
        while(i<=j){
            if(newString.charAt(i)!=newString.charAt(j))
            return false;
            i++;
            j--;
        }
        return true;
        */


//Approach---2 using recursion O(n) and O(n) for recursion stack
       // return solve(s, 0, s.length()-1);
    }

    // public boolean solve(String s, int l, int r){
    //     if(l>=r)
    //     return true;

    //     while(l<r && !Character.isLetterOrDigit(s.charAt(l)))
    //     l++;
    //      while(l<r && !Character.isLetterOrDigit(s.charAt(r)))
    //      r--;

    //      if(Character.toLowerCase(s.charAt(l))!=Character.toLowerCase(s.charAt(r)))
    //      return false;

    //      return solve(s,l+1, r-1);
    // }
}
}
