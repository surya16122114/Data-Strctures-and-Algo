package Stacks;

import java.util.Stack;

public class DecodeString {
    class Solution {
    public String decodeString(String s) {
        
        Stack<Character> st=new Stack<>();
        int n=s.length();
        for(int i=0; i<n; i++){
            char ch=s.charAt(i);
           
           if(ch==']'){
             StringBuilder sb=new StringBuilder();

            while(!st.isEmpty() && st.peek()!='['){
                sb.insert(0, st.pop());

            }
            st.pop();
            StringBuilder numStr=new StringBuilder();

            while(!st.isEmpty() && Character.isDigit(st.peek()))
            numStr.insert(0, st.pop());

            int num=Integer.parseInt(numStr.toString());

            
            StringBuilder converted=new StringBuilder();
            for(int j=0; j<num; j++)
         converted.append(sb);
          for(char c: converted.toString().toCharArray())
           st.push(c);

           }


          

            else{
                st.push(ch);
            }

            }

            StringBuilder ans=new StringBuilder();

     while(!st.isEmpty()){
        ans.append(st.pop());
     }

     return ans.reverse().toString();
        }

  
        
    }
}
