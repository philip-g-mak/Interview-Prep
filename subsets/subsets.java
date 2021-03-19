class Solution {
    List<List<Integer>> ret = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        //Arrays.sort(nums);
        backtrack(nums, new ArrayList(), 0);
        return ret;
    }
    
    public void backtrack(int[] nums, List<Integer> tempList, int start){
        ret.add(new ArrayList(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(nums, tempList, i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}

/*
idea: backtracking

sort the list
then add and remove the list 
*/