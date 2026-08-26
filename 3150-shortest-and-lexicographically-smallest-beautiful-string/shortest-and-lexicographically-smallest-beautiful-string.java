class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        String ans = "";
        int left = 0;
        int count = 0;

        for (int right = 0; right < s.length(); right++) {

            if (s.charAt(right) == '1') {
                count++;
            }
      
            while (count > k) {
                if (s.charAt(left) == '1') {
                    count--;
                }
                left++;
            }

           
            while (left <= right && s.charAt(left) == '0') {
                left++;
            }

            if (count == k) {
                String curr = s.substring(left, right + 1);

                if (ans.equals("") ||
                    curr.length() < ans.length() ||
                    (curr.length() == ans.length() && curr.compareTo(ans) < 0)) {

                    ans = curr;
                }
            }
        }

        return ans;
    }
}