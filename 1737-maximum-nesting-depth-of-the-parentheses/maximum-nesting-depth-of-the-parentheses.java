class Solution {
    public int maxDepth(String s) {
        int counter =0;
        int max = 0;
        for(int i=0;i<s.length();i++){
             char c = s.charAt(i);
             if(c=='('){
                 counter++;
                 max = Math.max(counter,max);
             }else if(c==')'){
                 counter--;
             }else{
                   continue;
             }
        }


        return max;


    }
}