package Trees;

public class SerAndDeser {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        dfsSerialize(root, sb);
        return sb.toString();


        
    }

    public void dfsSerialize(TreeNode root, StringBuilder sb){

        if(root==null){
            sb.append("#,");
            return;
        }

        sb.append(root.val).append(",");
        dfsSerialize(root.left, sb);
        dfsSerialize(root.right, sb);



    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.isEmpty())
        return null;

        String[] arr=data.split(",");
        //this idx is for traversing through the array for all recursive calls
        int[] idx=new int[1];
        return dfsDeserialize(arr, idx);
    }


    public TreeNode dfsDeserialize(String[] arr, int[] idx){
        String s=arr[idx[0]++];
        if(s.equals("#"))
        return null;
        TreeNode root=new TreeNode(Integer.parseInt(s));
        root.left=dfsDeserialize(arr, idx);
        root.right=dfsDeserialize(arr, idx);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}
