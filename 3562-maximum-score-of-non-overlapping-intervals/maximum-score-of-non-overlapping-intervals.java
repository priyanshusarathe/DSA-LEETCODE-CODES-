class Solution {

    class Result {
        long score;
        List<Integer> indices;

        Result(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    Result[][] dp;
    int[][] arr;
    int n;

    public int[] maximumWeight(List<List<Integer>> intervals) {

        n = intervals.size();

        arr = new int[n][4];

        // left, right, weight, original index
        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort by start
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);

            return Integer.compare(a[1], b[1]);
        });

        dp = new Result[n + 1][5];

        Result answer = solve(0, 0);

        return answer.indices.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    Result solve(int i, int count) {

        if (i == n || count == 4) {
            return new Result(0, new ArrayList<>());
        }

        if (dp[i][count] != null) {
            return dp[i][count];
        }

        // Option 1: Don't take current interval
        Result skip = solve(i + 1, count);

        // Option 2: Take current interval
        int next = findNext(arr[i][1]);

        Result nextResult = solve(next, count + 1);

        List<Integer> takeIndices =
                new ArrayList<>(nextResult.indices);

        takeIndices.add(arr[i][3]);

        Collections.sort(takeIndices);

        Result take = new Result(
                arr[i][2] + nextResult.score,
                takeIndices
        );

        if (better(take, skip)) {
            dp[i][count] = take;
        } else {
            dp[i][count] = skip;
        }

        return dp[i][count];
    }

    int findNext(int end) {

        int left = 0;
        int right = n;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid][0] <= end) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    boolean better(Result a, Result b) {

        if (a.score != b.score) {
            return a.score > b.score;
        }

        int size = Math.min(
                a.indices.size(),
                b.indices.size()
        );

        for (int i = 0; i < size; i++) {

            if (!a.indices.get(i).equals(b.indices.get(i))) {

                return a.indices.get(i) < b.indices.get(i);
            }
        }

        return a.indices.size() < b.indices.size();
    }
}