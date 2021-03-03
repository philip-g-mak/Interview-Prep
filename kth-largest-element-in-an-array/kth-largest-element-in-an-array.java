class Solution {
    public int findKthLargest(int[] nums, int k) {
        return kthHelper(nums, 0, nums.length -1, k);
        
    }
    
    public int kthHelper(int[] nums, int startIndex, int endIndex, int k){
        int pivotIndex = endIndex;
        int leftPointer = startIndex;  //write Index
        int rightPointer = pivotIndex -1; //readElement
        
        
        //swap elements such that all elements less than pivot to left and greater than to right
        while(leftPointer <= rightPointer){
            if(nums[rightPointer] < nums[pivotIndex]){
                swap(nums, leftPointer, rightPointer);
                leftPointer++;
            } else{
                rightPointer--;
            }
        }
        
        //move pivot to the correct position
        //pivot is now located at left index
        //left is pivot 
        swap(nums, leftPointer, pivotIndex);
        
        int pivotRank = nums.length - leftPointer;
        if(pivotRank == k){
            return nums[leftPointer];
        }
        if (pivotRank < k) // too large, recurse on left helf 
            return kthHelper(nums, startIndex, leftPointer-1, k);
        else  // too small, recurse on right half
            return kthHelper(nums, leftPointer+1 , endIndex, k);
        
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    
}


/*
    Idea  - Sort array, then take the kth
    
    O(nlogn)
    
    o(1) space

    decent lol
    
    idea - go through array once
    keep track of the relavive order 
    
    idea 
    
    Quick Select - based on quick sort
    
    L is left pointer
    R is right pointer
    P is pivot
    
    if L is > P 
        swap elements in  L and R
    continue until L is at R
     L       R P
    [6,2,1,5,3,4] pivot = 4
    [3,2,1 |4| 5,6] move pivot s/t all elements smaller 
               5,6
     
    L       R P
    [3,2,1,5,6,4] pivot = 4
    
           L R P
    [3,2,1,6,5,4] pivot = 4
    
    once L is next to R 
    swap P and L
             R
             P   
           P L  
    [3,2,1,4,5,6] pivot = 4
    
    what side to recurse on??
    
    


    2nd largest in a list of 6
    that means 1 element is larger
    and 4 elements are smaller 


*/


