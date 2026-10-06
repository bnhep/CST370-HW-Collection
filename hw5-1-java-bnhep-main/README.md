[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=22711436)
# CST370-HW5_1_Java

(hw5_1) Write a Java program for hw5_1 to conduct heap operations

Input format: This is a sample input from a user:
5
10 20 30 40 70
5
displayMax
insert 50
insert 15
deleteMax
display

The first line (= 5 in the example) indicates that there are five numbers in the second line (= 10, 20, 30, 40, and 70 in the example). In the program, you can assume that all numbers in the heap are unique (= no duplicates). Your program should read the numbers and display if it’s a max heap or not. If it’s not a max heap, your program should construct a heap with the numbers. 

The third line (= 5 in the example) indicates the number of commands you have to conduct to the heap. The commands include “displayMax”, “insert” (= insert a number to the heap and do the “heapify” to adjust the heap), “deleteMax”, and “display” (= display all nodes in the heap on the screen).
For the “displayMax” command, your program should display “70” on the screen. After that, your program should insert “50” and “15” to the heap. 

For the “deleteMax” command, your program should delete the max (= 70) from the heap. 

For the “display” command, your program should display the nodes in the heap (= 50 40 30 10 20 15)

This is the correct output: 

This is NOT a heap.
70
50 40 30 10 20 15

Sample Run 1: Assume that the user typed the following lines

6
20 10 8 1 3 5
4
display
deleteMax
displayMax
display

This is the correct output: 

This is a heap.
20 10 8 1 3 5
10
10 5 8 1 3

