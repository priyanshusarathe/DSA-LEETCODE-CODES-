class Solution {
    public int countCommas(int n) {
        if(n<1000){
            return 0;
        }

        int count=0;
        int val = 1000;
        while(val<=n){
              count++;
              val++;
        }
    return count;
    }
}