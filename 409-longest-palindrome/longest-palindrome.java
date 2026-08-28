class Solution {
    public int longestPalindrome(String s) {
        if(s.isEmpty() || s.length()==1){
            return s.length();
        }
        int [] freq = new int[128];
        for(char c : s.toCharArray()){
            freq[c]++;
        }
        int res=0;
        for(int i=0;i<128;i++){
           int val = freq[i];
           res+=(val/2)*2;
           if(res%2==0 && val%2==1){
            res++;
           }
        }
    return res;
    }
}