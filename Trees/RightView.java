package DataStructuresAndAlgo.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightView {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans=new ArrayList<>();
        if(root==null)
        return ans;
        Queue<TreeNode> q=new LinkedList<>();
    
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0; i<size; i++){
                TreeNode curr=q.poll();
                if(i==0)
                ans.add(curr.val);
                if(curr.right!=null)
                q.offer(curr.right);
                if(curr.left!=null)
                q.offer(curr.left);
            }
            
        }
        return ans;
    }
}
}
