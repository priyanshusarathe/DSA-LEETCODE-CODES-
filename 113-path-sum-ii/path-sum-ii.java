/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int v
 
 
 al) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void helper(TreeNode root,List<List<Integer>> li,List<Integer> ans,int sum,int target){
         if(root==null){
            return;
         }
          sum+=root.val;
          ans.add(root.val);
            if(root.left==null && root.right==null){
                if(sum==target){
                    li.add(new ArrayList<>(ans));
                }
            }
            helper(root.left,li,ans,sum,target);
            helper(root.right,li,ans,sum,target);
           
           ans.remove(ans.size()-1);

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> li = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        helper(root,li,ans,0,targetSum);
        return li;
        
    }
}