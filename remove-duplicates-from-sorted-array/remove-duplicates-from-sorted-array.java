class Solution {
    public int removeDuplicates(int[] nums) {
        int readIndex = 0;
        int writeIndex = 0;
        
        if(nums.length == 0 || nums.length == 1){
            return nums.length;
        }
        
        while(readIndex < nums.length){
            if(nums[readIndex] != nums[writeIndex]){
                writeIndex++;
                nums[writeIndex] = nums[readIndex];
            }
            readIndex++;
        }
        
        return writeIndex +1;
    }
}

/*
idea 

read index will be at or ahead of write index

if read index value is the same as write index value, then increment read index
if read index value is different that write index value, then increment write index and set it to the read index value

*/