package DP;
import java.util.HashMap;
import java.util.Map;

class HouseRobberIII{
    class Solution {
        Map<TreeNode, Integer> robbedParent = new HashMap<>();
        Map<TreeNode, Integer> freeParent = new HashMap<>();
        
        public int rob(TreeNode root) {
            return solve(root, false);
        }
        
        public int solve(TreeNode root, boolean isParentLooted) {
            if (root == null) return 0;
            
           
            if (isParentLooted && robbedParent.containsKey(root)) 
                return robbedParent.get(root);
            if (!isParentLooted && freeParent.containsKey(root)) 
                return freeParent.get(root);
            
            int result;
            if (isParentLooted) {
                result = solve(root.left, false) + solve(root.right, false);
            } else {
                int rob  = root.val + solve(root.left, true)  + solve(root.right, true);
                int skip =            solve(root.left, false) + solve(root.right, false);
                result = Math.max(rob, skip);
            }
            if (isParentLooted) robbedParent.put(root, result);
            else freeParent.put(root, result);
            
            return result;
        }
    }

    /**
 * Definition for a binary tree node.
 */
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
