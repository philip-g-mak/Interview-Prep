class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]); //sorts ascending
        
        for(int i =0; i < intervals.length -1; i++){
            if(intervals[i][1] > intervals[i+1][0])
                return false;
        }
        return true;
    }
}

/*
idea - sort the intervals by start time, then check to see if there is overlap
*/