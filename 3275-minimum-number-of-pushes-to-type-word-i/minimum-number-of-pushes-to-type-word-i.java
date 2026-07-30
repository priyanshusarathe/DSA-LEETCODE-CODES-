class Solution {
    public int minimumPushes(String word) {
          int sum =0;
          for(int i=0;i<word.length();i++){
            sum+=(i/8)+1;
          }
          return sum;
          
    }
}