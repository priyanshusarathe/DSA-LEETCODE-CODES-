class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int num:nums){
              min = Math.min(num,min);
        }
        int operations = 0;
        for(int num : nums){
             operations += num-min;

        }
        return operations;
        
    }
}