class Solution {

    public boolean helper(int i, int j, String s, String p) {

        if (i < 0 && j < 0)
            return true;

        if (j < 0)
            return false;

        if (i < 0) {
            while (j >= 0) {
                if (p.charAt(j) != '*')
                    return false;
                j -= 2;
            }
            return true;
        }

        if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
            return helper(i - 1, j - 1, s, p);
        }

      
        if (p.charAt(j) == '*') {


            boolean notTake = helper(i, j - 2, s, p);

            boolean take = false;

            if (j > 0 &&
                (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i))) {

                take = helper(i - 1, j, s, p);
            }

            return take || notTake;
        }

        return false;
    }

    public boolean isMatch(String s, String p) {
        return helper(s.length() - 1, p.length() - 1, s, p);
    }
}