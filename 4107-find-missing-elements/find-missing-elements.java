class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> li = new ArrayList<>();
        int max=0;
        int min =Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }
        HashSet<Integer> st = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            st.add(nums[i]);
        }

        for(int j=min;j<=max;j++){
             if(!st.contains(j)){
                 li.add(j);
             }
        }
   return li;
    }
}