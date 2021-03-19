class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        for(int i = 0; i < intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int roomCount = 0;
        for(int startIndex = 0, endIndex = 0; startIndex < start.length; startIndex++){
            if(start[startIndex] < end[endIndex]){  //if a meeting starts before another meeting ends - we need another room
                roomCount++;
            } else {  //else continue with meetings
                endIndex++;
            }
        }
        
        return roomCount;
        
    }
}

/*
idea - if there is overlap, we need another room?

split into 2 arrays, start and end time and sort both ascending

if a meeting starts before another meeting ends - increment
else no conflict so keep comparing 
*/