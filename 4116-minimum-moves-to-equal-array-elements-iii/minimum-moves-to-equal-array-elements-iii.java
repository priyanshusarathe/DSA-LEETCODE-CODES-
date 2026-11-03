class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int  x : nums){
             max = Math.max(max,x);
        }  
        int operations=0;
        for(int x : nums){
             operations +=Math.abs(max-x);
        } 
        return operations;
        
    }
}