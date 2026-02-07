package Trees;

public class BinaryTreeMaxPathSum {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int answer=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
     maxPath(root);
     return answer;
    }

    public int maxPath(TreeNode root){
        if(root==null)
        return 0;
     int ans1=Math.max(0, maxPath(root.left));
     int ans2= Math.max(0, maxPath(root.right));
     answer=Math.max(answer, root.val+ans1+ans2);
     return root.val+Math.max(ans1, ans2);

     
    }

}
}
