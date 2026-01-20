package DataStructuresAndAlgo.DP;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartioning {
    class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> res= new ArrayList<>();
        List<String> currStringList=new ArrayList<>();
       solve(res, s,0, currStringList);
       return res;

    }

    public void solve(List<List<String>> res, String s, int index,  List<String> currStringList){
        if(index==s.length()){
            res.add(new ArrayList<>(currStringList));
            return;
        }
//for loop is for to make sure we conisder all cut positions
        for(int i=index; i<s.length(); i++){
            String part = s.substring(index, i + 1);
            if(!isPalindrome(part))
            continue;
            //recursion is for partitioning the string such that whether we get a palindrome or not after partioning
            currStringList.add(part);
            solve(res, s, i+1, currStringList);
            currStringList.remove(currStringList.size()-1);

        }
    }

    public boolean isPalindrome(String s){
        int i=0; 
        int j=s.length()-1;

        while(i<=j){
            if(s.charAt(i)!=s.charAt(j))
            return false;

            i++;
            j--;
        }

        return true;

    }
}

// solve(index=0, st=[])
// |
// |-- for i=0  -> s[0..0] = "a"  (palindrome)
// |    st.add("a")
// |    solve(index=1, st=["a"])
// |    |
// |    |-- for i=1  -> s[1..1] = "a"  (palindrome)
// |    |    st.add("a")
// |    |    solve(index=2, st=["a","a"])
// |    |    |
// |    |    |-- for i=2  -> s[2..2] = "b"  (palindrome)
// |    |    |    st.add("b")
// |    |    |    solve(index=3, st=["a","a","b"])
// |    |    |    |
// |    |    |    '-- index==3 -> add ["a","a","b"] to res
// |    |    |    st.remove("b")   (backtrack)
// |    |    |
// |    |    '-- end loop at index=2
// |    |    st.remove("a")   (backtrack)
// |    |
// |    |-- for i=2  -> s[1..2] = "ab" (NOT palindrome) 
// |    |
// |    '-- end loop at index=1
// |    st.remove("a")   (backtrack)
// |
// |-- for i=1  -> s[0..1] = "aa" (palindrome)
// |    st.add("aa")
// |    solve(index=2, st=["aa"])
// |    |
// |    '-- for i=2  -> s[2..2] = "b" (palindrome) 
// |         st.add("b")
// |         solve(index=3, st=["aa","b"])
// |         |
// |         '-- index==3 -> add ["aa","b"] to res
// |         st.remove("b")   (backtrack)
// |
// |    '-- end loop at index=2
// |    st.remove("aa")   (backtrack)
// |
// '-- for i=2  -> s[0..2] = "aab" (NOT palindrome)

// -- end loop at index=0
}
