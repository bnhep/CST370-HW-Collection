[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=22306130)
# CST370-HW3_1_Java

Write a Java program for hw3_1 that implements the Depth-First Search (DFS) algorithm using a stack and a mark array as you learned in the class. 

Sample Run 0: Assume that the user typed the following lines

3 
2
0 1
1 2

The first line (= 3 in the example) indicates that there are three vertices in the graph. For the homework, you can assume that the first vertex starts from the number 0. The second line (= 2 in the example) represents the number of edges, and following two lines are the edge information. This is the graph with the input information.

This is the correct output. Your program should display the mark array of DFS. For the problem, you can assume that the graph is connected.

Mark[0]:1
Mark[1]:2
Mark[2]:3


Sample Run 1: Assume that the user typed the following lines

5
6
0 1
0 2
0 3
1 3
2 3
3 4

This is the correct output. 

Mark[0]:1
Mark[1]:2
Mark[2]:5
Mark[3]:3
Mark[4]:4


Sample Run 2: Assume that the user typed the following lines

5
6
0 1
0 2
0 3
1 4
2 3
3 4

This is the correct output. 

Mark[0]:1
Mark[1]:2
Mark[2]:4
Mark[3]:5
Mark[4]:3


