class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int idx = n/2;
        int num= nums[idx];
        int operations=0;
        for(int x : nums){
             operations +=Math.abs(num-x);
        }
        return operations;
        
    }
}