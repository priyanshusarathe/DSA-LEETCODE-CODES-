class Solution {
    HashSet<Integer> set = new HashSet<>();

    public void helper(int[] digits, boolean[] used, StringBuilder sb) {

        if (sb.length() == 3) {
            int n = Integer.parseInt(sb.toString());

            if (n % 2 == 0) {
                set.add(n);
            }
            return;
        }

        for (int i = 0; i < digits.length; i++) {

            if (used[i]) {
                continue;
            }

            if (sb.length() == 0 && digits[i] == 0) {
                continue;
            }

            used[i] = true;
            sb.append(digits[i]);

            helper(digits, used, sb);

            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }

    public int totalNumbers(int[] digits) {
        helper(digits, new boolean[digits.length], new StringBuilder());
        return set.size();
    }
}       