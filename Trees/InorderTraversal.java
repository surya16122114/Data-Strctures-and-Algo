//leetcode poroblem link: https://leetcode.com/problems/binary-tree-inorder-traversal/
package Trees;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
   static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        public TreeNode(int val) { this.val = val; }
      public  TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        callInorder(root,res);
        return res;

    }

    public void callInorder(TreeNode root, List<Integer> res){
        if(root==null)
            return ;
        callInorder(root.left, res);
        res.add(root.val);
        callInorder(root.right, res);
    }


}
