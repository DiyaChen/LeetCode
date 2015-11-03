/*
Course Schedule 

There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

Hints:
This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
Topological sort could also be done via BFS.
*/

// BFS solution
public class Solution{
    public boolean canFinish(int numCourses, int[][] prerequisites) {   // [course, prerequisite]
        if(prerequisites == null){
            return true;
        }
        int len = prerequisites.length;
        if(numCourses == 0 || len == 0){
            return true;
        }
     
        // counter for number of prerequisites
        int[] pCounter = new int[numCourses];// index: course ID; value: number of prerequisites
        for(int[] a : prerequisites){
            pCounter[a[0]]++;
        }
     
        //store courses that have no prerequisites
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++){
            if(pCounter[i]==0){
                queue.add(i);
            }
        }
     
        // number of courses that have no prerequisites
        int numNoPre = queue.size();
        while(!queue.isEmpty()){
            int top = queue.remove();//remove course without prerequisites
            for(int[] a : prerequisites){
                if(a[1] == top){
                    pCounter[a[0]]--;
                    if(pCounter[a[0]] == 0){
                        numNoPre++;
                        queue.add(a[0]);
                    }
                }
            }
        }     
        return numNoPre == numCourses;
    }
}

// DFS solution
public class Solution{
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null){
            return false;
        }
        int len = prerequisites.length;
        if(numCourses == 0 || len == 0){
            return true;
        }

        // use the map to store what courses depend on a course 
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();    // <prerequisite, courses>

        for(int[] a: prerequisites){
            if(!map.containsKey(a[1])){
                List<Integer> list = new ArrayList<Integer>();
                list.add(a[0]);
                map.put(a[1], list);
            }else{
                map.get(a[1]).add(a[0]);
            }
        }

        //track visited courses
        int[] visit = new int[numCourses];  // -1: visiting; 1: visited; 0: not touch

        for(int i = 0; i < numCourses; i++){
            if(!noCircle(map, visit, i))
                return false;
        }
        return true;
    }
     
    private boolean noCircle(Map<Integer, List<Integer>> map, int[] visit, int i){
        if(visit[i] == -1) return false;
        if(visit[i] == 1)  return true;
        visit[i] = -1;
        if(map.containsKey(i)){ // it is a prerequisite of others so it can generate child nodes and may form a circle in the future
            for(int j: map.get(i)){
                if(!noCircle(map, visit, j)) 
                    return false;
            }
            visit[i] = 1;
        }else{  // it is not a prerequisite of others so it can be the end of the line and it cannot generate child node
            visit[i] = 1;
        }     
        return true;
    }
}