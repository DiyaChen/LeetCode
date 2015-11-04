/*
Course Schedule II 

There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

Hints:
This problem is equivalent to finding the topological order in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
Topological sort could also be done via BFS.
*/

// BFS solution
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
                if(numCourses == 0)
            return new int[0];
        int[] res = new int[numCourses];
        if(prerequisites.length == 0)//if every course does not have prerequisites, then take the courses in increasing order
        {
            for(int i = 0; i< numCourses; i++)
                res[i] = i;
            return res;
        }
        int[] pCounter = new int[numCourses];
        for(int[] a : prerequisites)
            pCounter[a[0]]++;
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i< numCourses; i++)
        {
            if(pCounter[i] == 0)
                queue.add(i);
        }
        int counter = 0;//count result number
        int num = queue.size();//course can be taken 
        while(!queue.isEmpty())
        {
            int top = queue.remove();
            res[counter++] = top;
            for(int[] a : prerequisites)
            {
                if(a[1] == top)
                {
                    pCounter[a[0]]--;
                    if(pCounter[a[0]] == 0)
                    {
                        num++;
                        queue.add(a[0]);
                    }
                }
            }
        }
        if(num == numCourses)
            return res;
        else
            return new int[0];
    }
}