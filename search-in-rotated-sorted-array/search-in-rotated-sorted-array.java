class Solution {
    public int search(int[] nums, int target) 
    {
        int start = 0;
        int end = nums.length -1;
        
        while(start <= end){
            int mid = start + (end-start)/2;
            
            if(nums[mid]== target) return mid;
            else
            if(nums[mid] >= nums[start]){
                if(target >= nums[start] && target < nums[mid]){
                    end =mid -1;
                }else {
                    start = mid+1;
                }
            } else {
                if(target <= nums[end] && target > nums[mid]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        
        return -1;
    }
}

/*
do binary search - sorta


idea - the pivot could be anywhere
    so the changing of left and right pointers matters based on where the pivot occured
    
    check if num[mid] >= num[start]{
        check if target should be in range of start to mid 
            if true -> end = mid -1
            if false ->start = mid+1
    if num[mid] < num[start]{
        check if target should be in range of mid to end
            if true -> start = mid+1
            if false -> end = mid-1
    }
            
        
    }
*/