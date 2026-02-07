import java.util.Stack;

public class MinStack {
   class MiniStack {
    Stack<Integer> st;
    //To store the minimum value
    Stack<Integer> minStack;

    public MiniStack() {
        st=new Stack();
        minStack=new Stack();
    }
    
    public void push(int val) {
        st.push(val);
        if(minStack.isEmpty() || val<=minStack.peek())
        minStack.push(val);
        
    }
    
    public void pop() {
        if(st.isEmpty())
        return;
       int topElement= st.pop();
        if(topElement==minStack.peek())
        minStack.pop();
        
    }
    
    public int top() {
        return st.peek();

        
    }
    
    public int getMin() {
        return minStack.peek();
        
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
