package DataStructuresAndAlgo.Trees;
public class GoodNodes {

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
    public int goodNodes(TreeNode root) {
     
//pass max till now
       return getGoodNodes(root, root.val);
        
    }

    public int getGoodNodes(TreeNode root, int maxTillNow){
        if(root==null)
        return 0;
        //id the current val is greater than the max till now, we have to replace max till now and add 1 to count since the current ndoe is a good node, otherwise we will call recursively for its child nodes
        if(root.val>=maxTillNow)
        return 1+getGoodNodes(root.left,root.val)+getGoodNodes(root.right, root.val);
        else
        return getGoodNodes(root.left, maxTillNow)+getGoodNodes(root.right, maxTillNow);

    }
}
}
