class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        
        //get indegree of each vertex
        for(int[] prereq : prerequisites){
            inDegree[prereq[0]]++;
        }
        
        
        //populate q with vertices with indegree of 0
        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        
        int possibleCourse = q.size();
        while(!q.isEmpty()){
            int prereq = q.poll();
            for(int[] course: prerequisites){
                if(course[1] == prereq){
                    inDegree[course[0]]--;
                    
                    if(inDegree[course[0]] == 0){
                        q.add(course[0]);
                        possibleCourse++;
                    }
                }
            }
        }
        return possibleCourse == numCourses;
        
    }
}

/*
format
[0,1] mean 0 has a prereq of 1
so 1 -----> 0

Create a graph out of the classes
A -> B

if not cycle, then good

if cycle exists, then not possible
A->B -> A

Idea - Backtracking DFS or BFS?

BFS  idea

if it is a DAG - then BFS will go through the entire graph without loops
count the indegree of each vertex
create q
put vertex with indegree of 0 in q
create variable, number of possible courses = to the number of 0 degree vertexes
loop - while q is not empty:
    take prereq vertex out of q
    decrement the vertexes that prereq is a prerequesite for
    add to q any prereq that now has a value of 0
    increment number of possible courses
    
    
return  possible courses == numcourses
*/