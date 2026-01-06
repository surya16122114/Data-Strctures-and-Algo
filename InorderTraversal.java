//leetcode poroblem link: https://leetcode.com/problems/binary-tree-inorder-traversal/
package DataStructuresAndAlgo;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
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
