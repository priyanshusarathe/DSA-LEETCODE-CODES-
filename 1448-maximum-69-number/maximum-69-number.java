class Solution {
    public int maximum69Number (int num) {
        // int val = num;
        // int max = Integer.MIN_VALUE;
        // int len = 0;
        // while(val!=0){
        //     val = val/10;
        //     len++;
        // }
        String val = String.valueOf(num);
        char [] ch = val.toCharArray();

        for(int i=0;i<ch.length;i++){
            if(ch[i]=='6'){
                ch[i]='9';
                break;
            }
        }
        return Integer.parseInt(new String(ch));
        

    }
}