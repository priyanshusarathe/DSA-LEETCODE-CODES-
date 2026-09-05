class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int [] prefix = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
             max = Math.max(nums[i],max);
             prefix[i]= max;
        }
        int [] suffix = new int[n];
        int min = Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
              min = Math.min(nums[i],min);
              suffix[i]=min;
        }

        for(int i=0;i<nums.length;i++){
            int val = prefix[i]-suffix[i];
            if(val<=k){
                return i;
            }
        }
  return -1;
    }
}