class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int[] minarr = new int[n];
        minarr[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            minarr[i] = Math.min(nums[i], minarr[i + 1]);
        }

    
        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            maxVal = Math.max(maxVal, nums[i]);

            int score = maxVal - minarr[i];

            if (score <= k) {
                return i;
            }
        }

        return -1;
    }
}