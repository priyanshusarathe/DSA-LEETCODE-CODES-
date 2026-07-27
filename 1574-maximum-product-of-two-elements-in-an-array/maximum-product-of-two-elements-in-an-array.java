class Solution {

    public int maxProduct(int[] nums) {
            PriorityQueue<Integer> q = new  PriorityQueue(Collections.reverseOrder());
            for(int i=0;i<nums.length;i++){
                q.add(nums[i]);
            }
            int a=q.remove();
            int b = q.remove();
            return(a-1)*(b-1);
    }
}