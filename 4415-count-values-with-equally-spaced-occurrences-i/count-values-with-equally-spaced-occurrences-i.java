class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer,ArrayList<Integer>>map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
              if(!map.containsKey(nums[i])){
                   map.put(nums[i],new ArrayList<>());
                   map.get(nums[i]).add(i);
              }else{
                 map.get(nums[i]).add(i);
              }
        }
        int ans=0;

        for(ArrayList<Integer> li : map.values()){
              if(li.size()==3){
                int a = li.get(0);
                int b = li.get(1);
                int c = li.get(2);

                if((b-a)==(c-b)){
                    ans++;
                }
                
              }
        }
  return ans;
    }
}