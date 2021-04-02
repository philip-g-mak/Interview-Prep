class Solution {
    public int[] searchRange(int[] nums, int target) {
        int index = findIndex(nums, target);
        System.out.println(index);
        int[] ret = new int[2];
        if(index == -1) return new int[]{-1,-1};
        
        int left = index;
        int right = index;
        
        while(left >= 0 && nums[left] == target){
            left--;
        }
        
        while(right < nums.length && nums[right] == target){
            right++;
        }
        
        if(left == -1) {
            left = 0;
        } else {left++;}
        if(right == nums.length){ 
            right = nums.length -1;
        } else {
            right--;
        }
        
        ret[0] = left;
        ret[1] = right;
        
        return ret;
    }
    
    public int findIndex(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        
        int mid = left + (right-left)/2;
        
        while(left <= right){
            mid = left + (right-left)/2;
            if(nums[mid] == target)
                return mid;
            
            if(nums[mid] < target){
                left = mid+1;
            } else {
                right = mid-1;
            } 
        }
        
        return -1;
        
    }
}