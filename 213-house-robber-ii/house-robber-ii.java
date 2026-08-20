class Solution {

    public int robRange(int[] nums, int start, int end) {

        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i <= end; i++) {

            int skip = prev1;
            int take = nums[i] + prev2;

            int curr = Math.max(skip, take);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int case1 = robRange(nums, 1, n - 1); // skip first
        int case2 = robRange(nums, 0, n - 2); // skip last

        return Math.max(case1, case2);
    }
}