class Solution {
    public int maxArea(int[] height) {
       int i=0;
       int j=height.length-1;
       int max =0;
       int min=Integer.MAX_VALUE;
       int dis=0;
     while(i<j){
        min=Math.min(height[i],height[j]);
        dis = j-i;
        max=Math.max(max,min*dis);
        if(height[i]<height[j]){
              i++;
        }else{
            j--;
        }

     }
  return max;
    }
}