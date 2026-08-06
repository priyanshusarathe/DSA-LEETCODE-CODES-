class Solution {
    public int smallestNumber(int n, int t) {
          int product=1;
         for(int i=n;i<101;i++){
            int m=i;
            while(m!=0){
                int a = m%10;
                product = product*a;
                m=m/10;
             }
            if(product%t==0){
                return i;
            }
            product=1;
         }
   return 0;
    }
}