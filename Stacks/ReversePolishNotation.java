import java.util.Stack;

public class ReversePolishNotation {
    class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();

        for(int i=0; i<tokens.length; i++){
           
            if(tokens[i].equals("+")){
                int a=st.pop();
                int b=st.pop();
                int ans=b+a;
                st.push(ans);

            }
            else if(tokens[i].equals("-")){
                int a=st.pop();
                int b=st.pop();
                 int ans=b-a;
                st.push(ans);

            }
            else if(tokens[i].equals("*")){
                int a=st.pop();
                int b=st.pop();
                 int ans=b*a;
                st.push(ans);

            }
            else if(tokens[i].equals("/")){
                int a=st.pop();
                int b=st.pop();
                 int ans=b/a;
                st.push(ans);

            }

            else{
               st.push(Integer.parseInt(tokens[i]));

            }
        }

        return st.pop();
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
