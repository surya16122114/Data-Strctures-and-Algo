package Trees;

public class CheckBST {
    class Solution {
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
    }

    public boolean checkBST(TreeNode root, long mini, long maxi){
        if(root==null)
        return true;

        if(root.val<=mini || root.val>=maxi )
        return false;
    return  checkBST(root.left, mini, root.val) && checkBST(root.right, root.val, maxi);

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
