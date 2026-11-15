class Solution {
    public int numOfSubarrays(int[] arr) {
        int prefixsum =0;
        int evenc = 1;
        int oddc=0;
        int res =0;
        int mod = 1000000007;
        for(int x : arr){
             prefixsum+=x;
             if(prefixsum%2==0){
                  res+=oddc;
                  evenc++;
             }else{
                  res +=evenc;
                  oddc++;
             }
             res = res%mod;

        }
        return res;
        

    }
}