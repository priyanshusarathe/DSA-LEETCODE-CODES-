class Solution {
    public int sumSubarrayMins(int[] arr) {
        long ans =0;
        int mod = 1000000007;
        int n = arr.length;
        int [] left = new int[n];
      Stack<Integer> st = new Stack<>();
      for(int i=0;i<n;i++){
         

         while(!st.isEmpty() && arr[st.peek()]>arr[i]){
            st.pop();
         }

         if(st.isEmpty()){
            left[i]=-1;
         }else{
            left[i]=st.peek();
         }
         st.push(i);
      }
      st.clear();

      int [] right = new int[n];
      for(int i=n-1;i>=0;i--){
          

          while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
            st.pop();
          }

          if(st.isEmpty()){
            right[i]=n;
          }else{
            right[i]=st.peek();
          }
          st.push(i);
      }

      for(int i=0;i<n;i++){
          long contribution = (long)arr[i]*(i-left[i])*(right[i]-i);
          ans +=contribution;
          ans = ans%mod;
      }
  return (int)ans;
  }
}