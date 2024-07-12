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
    // public boolean isBalanced(TreeNode root) {
    //     if(root==null){
    //         return true;
    //     }
    //     int difference = Math.abs(maxDepth(root.left) - maxDepth(root.right));
    //     if (difference <= 1){
    //         if (isBalanced(root.left)
    //             && isBalanced(root.right)){
    //                 return true;
    //             }
    //         return false;
    //     }
    //     return false;

    // }

    // public int maxDepth(TreeNode root) {
    //     if (root == null){
    //         return 0;
    //     }

    //     return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    // }

    // T: O(N) ; You explore through each node once relative to the root (N or N-1 or N-2 etc...)
    //         ; But this changes based on where you are it could be O(height)
    // public int height(TreeNode node){
    //     if(node==null){
    //         return 0;
    //     }
    //     return Math.max(height(node.left), height(node.right)) + 1;
    //  }        

	
    // // T: O(?) 
    // // S: O()
    // public boolean isBalanced(TreeNode root){
    //     if (root == null) 
    //         return true;

        
    //     if(1 >= Math.abs( height(root.left) - height(root.right) )){
    //         return isBtime alanced(root.left) && isBalanced(root.right);
    //     }
           
    //     return false; 
    // }

    public boolean isBalanced(TreeNode root){
    if (root == null){
        return true;
    }

    int leftH = height(root.left);
    int rightH = height(root.right);
    return Math.abs(leftH - rightH) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node){
        if (node == null){
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));

    }

}
