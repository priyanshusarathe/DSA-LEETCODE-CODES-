class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> li = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i=1;i<=9;i++){
            q.add(i);
        }
        int len =1;
        while(!q.isEmpty() && len<n){
            len++;
            int s = q.size();
            for(int i=0;i<s;i++){
                 int currnum = q.remove();
                 int lastdigit = currnum%10;
                  if(lastdigit+k<=9){
                    q.add(currnum*10+lastdigit+k);
                  }
                  if(k!=0 && lastdigit-k>=0){
                    q.add(currnum*10+lastdigit-k);
                  }
                 
            }
        }

        while(!q.isEmpty()){
            li.add(q.remove());
        }
        int [] ans = new int[li.size()];
        for(int i=0;i<ans.length;i++){
              ans[i]=li.get(i);
        }
        

 return ans;
    }
}