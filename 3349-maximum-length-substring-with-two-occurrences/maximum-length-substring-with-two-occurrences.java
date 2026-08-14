class Solution {
    public int maximumLengthSubstring(String s) {
       int [] ch = new int[26];
        int maxlen=0;
        int left=0;
        for(int right=0;right<s.length();right++){
                          

                
            ch[s.charAt(right) - 'a']++;
           while (ch[s.charAt(right) - 'a'] > 2) {
                ch[s.charAt(left) - 'a']--;
                left++;
            }
                        maxlen = Math.max(maxlen,right-left+1);
                  
        }
   return maxlen;
    }
}