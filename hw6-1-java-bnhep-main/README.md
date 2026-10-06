[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=22828584)
# CST370-HW6_1_Java

Write a Java program for hw6_1 to collect maximum number of coins on an n x m board which was covered in the class.

Sample Run 0: Assume that the user typed the following lines

5 6
0 0 0 0 1 0
0 1 0 1 0 0
0 0 0 1 0 1
0 0 1 0 0 1
1 0 0 0 1 0

The first line (= 5 and 6 in the example) indicates that the board has 5 rows and 6 columns. From the second line, the configuration of the board is presented. The number 1 indicates that there is a coin on the cell, while the number 0 means no coin. For the homework, you can assume that the board size is less than or equal to 25 x 25.

This is the correct output. Note that the coordinate of the starting cell is (1,1) and the destination is (5,6). Your program should display maximum coins and path to collect them. When backtracking from the destination cell, if there is more than one optimal path, your solution should always pick the path from the left, not from the top. 

    Max coins:5
    Path:(1,1)->(2,1)->(2,2)->(2,3)->(2,4)->(3,4)->(3,5)->(3,6)->(4,6)->(5,6)


Sample Run 1: Assume that the user typed the following lines. Again, when backtracking from the destination spot, your solution should always pick the path from the left, not from the top, if there is more than one optimal path.

4 5
0 0 0 1 0
0 1 1 1 0
1 1 1 0 1
0 0 0 0 0

This is the correct output. 

Max coins:4
Path:(1,1)->(2,1)->(3,1)->(3,2)->(3,3)->(3,4)->(3,5)->(4,5)

