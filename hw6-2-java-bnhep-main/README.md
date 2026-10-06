[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=22828597)
# CST370-HW6_2_Java

Write a Java program for hw6_2 that implements the Floyd algorithm to display all-pairs shortest paths as we covered in the class. 

Sample Run 0: Assume that the user typed the following lines

4
0 -1 3 -1
2 0 -1 -1
-1 7 0 1
6 -1 -1 0

The first line (= 4 in the example) indicates that there are four vertices in the input graph. Then the following 4 lines present the distances among the vertices. Note that the value –1 indicates the infinity. For this homework, you can assume that the number of vertices is less than 25.

This is the correct output. In the class, we drew all five matrices such as D(0), D(1), D(2), D(3), and D(4). For the homework, just present the last matrix (= D(4)).

0 10 3 4
2 0 5 6
7 7 0 1
6 16 9 0

Sample Run 1: Assume that the user typed the following lines

3
0 2 -1
-1 0 2
2 -1 0

This is the correct output.

0 2 4
4 0 2
2 4 0
