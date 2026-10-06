[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=22608060)
# CST370-HW4_2_Java

(hw4_2) Write a Java program for hw4_2 that conducts the topological sorting based on the Kahn algorithm covered in the lecture. 

Input format: This is a sample input from a user

4 
5
0 1
0 2
0 3
1 3
2 3

The first line (= 4 in the example) indicates that there are four vertices in the graph. For the homework, you can assume that the first vertex starts from the number 0. The second line (= 5 in the example) represents the number of edges in the graph, and following five lines are the edges.

This is the correct output. Your program should display the numbers of incoming degrees of each vertex first. For example, the vertex 3 has three incoming degrees which is represented as “In-degree[3]:3”. After the incoming degree information, your program should display the topological order as you learned in the class.

In-degree[0]:0
In-degree[1]:1
In-degree[2]:1
In-degree[3]:3
Order:0->1->2->3


Note: The order of input adjacent vertices may not always be in ascending numerical order, but your program should always follow the numerical ascending order of adjacent vertices. 

Note: if the input order is:

4 
5
0 2
0 1
0 3
1 3
2 3

The result should be the same as above.
