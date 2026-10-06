# CST 370 Algorithms

This repository contains programs developed for my algorithms and data structures coursework. Each project focuses on a specific algorithmic technique, data structure, or problem-solving strategy.

## String Processing

### hw1_1 — Palindrome

This program determines whether an input string is a palindrome. It removes symbols and spaces, converts the remaining characters to lowercase, and compares characters from the beginning and end of the string while moving toward the center.

## Sorting and Array Algorithms

### hw2_1 — Closest Distance

This program finds the closest pair of numbers from a collection of integers. The input values are sorted in ascending order, and adjacent values are compared to determine the minimum distance and all pairs that share that distance.

### hw2_2 — Ascending Order

This program sorts a collection of integers in ascending order and displays consecutive values as ranges. For example, consecutive values such as `1, 2, 3` are displayed as `1-3`.

### hw4_1 — Sorting Performance Comparison

This program compares the performance of Insertion Sort and Quick Sort. It generates input in ascending, descending, or random order, sorts the values using multiple algorithms, measures execution time, and ranks the results.

The program includes:

- Insertion Sort
- Quick Sort using the first element as the pivot
- Quick Sort using Median-of-Three pivot selection

## Graph Algorithms

### hw3_1 — Depth-First Search

This program performs a recursive Depth-First Search on a graph represented by an adjacency list. Vertices are marked according to the order in which they are visited.

### hw3_2 — Traveling Salesman Problem

This program solves the Traveling Salesman Problem using a brute-force permutation approach. It generates every possible order of the vertices, calculates the total cost of each route, and selects the lowest-cost route that returns to the starting vertex.

### hw4_2 — Topological Sorting

This program performs a topological sort using Kahn’s Algorithm. It calculates the in-degree of each vertex and uses a queue to process vertices with no incoming edges. If the graph contains a cycle, the program reports that no valid ordering exists.

### hw6_2 — Floyd-Warshall Algorithm

This program uses the Floyd-Warshall Algorithm to calculate the shortest paths between every pair of vertices in a weighted graph. It stores the graph in a matrix and repeatedly checks whether using an intermediate vertex creates a shorter path.

## Data Structures

### hw5_1 — Max Heap Operations

This program builds and manipulates a Max Heap. It checks whether an input array is already a heap, builds a heap using the bottom-up method when necessary, and supports insertion, deletion of the maximum value, and heap display operations.

### hw5_2 — Linear Probing Hash Table

This program implements a hash table using modular hashing and linear probing to resolve collisions. It supports inserting keys, searching for keys, displaying table entries, checking the table size, and rehashing when the load factor becomes greater than 0.5.

## Dynamic Programming

### hw6_1 — Coin Collection

This program solves the Coin Collection problem using dynamic programming. A robot begins in the upper-left cell of a matrix and can move only right or down. The program calculates the maximum number of coins that can be collected and reconstructs an optimal path through the matrix.
