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
    public List<TreeNode> allPossibleFBT(int n) {
         List<TreeNode> li = new ArrayList<>();
         
         if(n%2==0){
            return li;
         }

         if(n==1){
         li.add(new TreeNode(0));
         return li;
         }

         for(int leftroot =1;leftroot<n;leftroot+=2){
                int rightroot = n-1-leftroot;

                List<TreeNode> left = allPossibleFBT(leftroot);
                List<TreeNode> right = allPossibleFBT(rightroot);

                for(TreeNode nodel : left){
                    for(TreeNode noder : right){
                        TreeNode root = new TreeNode(0);

                        root.left = nodel;
                        root.right = noder;
                        li.add(root);
                    }
                }

         }
  return li;
    }
}