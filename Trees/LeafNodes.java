package Trees;

import java.util.ArrayList;
import java.util.List;

public class LeafNodes {


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
class Solution {
      
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
      
        while(root!=null){
            List<Integer> leaves=new ArrayList<>();
            
            root=getLeafNodes(root, leaves);
           

            res.add(leaves);


        }

        return res;
        
    }

    public TreeNode getLeafNodes(TreeNode root, List<Integer> leaves){
        if(root==null)
        return null;
        if(root.left==null && root.right==null){
            leaves.add(root.val);
            return null;

        }
        root.left=getLeafNodes(root.left, leaves);
        root.right=getLeafNodes(root.right, leaves);

        return root;
    }


}
}
