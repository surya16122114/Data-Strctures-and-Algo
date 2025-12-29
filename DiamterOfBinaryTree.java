package DataStructuresAndAlgo;
/* 
leetcode problem link: https://leetcode.com/problems/diameter-of-binary-tree/
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.
*/
public class DiamterOfBinaryTree {
    class Solution {
    int diameter=0;
    public int height(TreeNode root){
        if(root==null)
        return 0;
        int lh=height(root.left);
        int rh=height(root.right);
        diameter=Math.max(diameter, lh+rh);
        //Diamter is the sum of left height and right height
        return 1+Math.max(lh, rh);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
}
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
}
