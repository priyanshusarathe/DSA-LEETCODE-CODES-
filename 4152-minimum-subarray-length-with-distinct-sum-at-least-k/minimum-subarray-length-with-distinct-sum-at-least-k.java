class Solution {
    public int minLength(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        long sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            if (!map.containsKey(nums[right])) {
                sum += nums[right];
                map.put(nums[right], 1);
            } else {
             
                map.put(nums[right], map.get(nums[right]) + 1);
            }

            while (sum >= k) {

                ans = Math.min(ans, right - left + 1);

                if (map.get(nums[left]) == 1) {
                    sum -= nums[left];
                    map.remove(nums[left]);
                } else {
                    map.put(nums[left], map.get(nums[left]) - 1);
                }

                left++;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}