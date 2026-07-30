class Solution {
    public int maximumProduct(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int x : nums) {
            pq.add(x);
        }

        while (k > 0) {
            int x = pq.remove();
            pq.add(x + 1);
            k--;
        }

        long ans = 1;
        int MOD = 1000000007;

        while (!pq.isEmpty()) {
            ans = (ans * pq.remove()) % MOD;
        }

        return (int) ans;
    }
}