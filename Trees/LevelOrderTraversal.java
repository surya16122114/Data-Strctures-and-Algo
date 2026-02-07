package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    
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
    /*
     * Leetcode problem link: https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null)
        return list;

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> li=new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode curr=q.poll();
                li.add(curr.val);
                if(curr.left!=null)
                q.offer(curr.left);
                if(curr.right!=null)
                q.offer(curr.right);

            }
            list.add(li);
        }

        return list;
    }
}
}
