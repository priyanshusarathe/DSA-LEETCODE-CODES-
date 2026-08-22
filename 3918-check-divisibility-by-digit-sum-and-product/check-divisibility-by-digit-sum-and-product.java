class Solution {
    public boolean checkDivisibility(int n) {
        int digitsum=0;
        int digitProduct=1;
        int sum=0;
        int val=n;
        while(n!=0){
            digitsum+=n%10;
            digitProduct*=n%10;
            n=n/10;
        }

        sum = digitProduct + digitsum;
        if(val%sum==0){
            return true;
        }
        return false;
    }
}