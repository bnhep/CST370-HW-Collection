# CST 370 Algorithms

This repository contains programs developed for my algorithms and data structures coursework. Each project focuses on a specific algorithmic technique, data structure, or problem-solving strategy.

## Projects

### Palindrome

This program determines whether a string is a palindrome. It removes non-alphanumeric characters, converts the remaining characters to lowercase, and compares characters from the beginning and end of the string moving toward the center.

Techniques demonstrated:

- String processing
- Two-pointer comparison
- Input normalization

### Closest Pair

This program finds the closest pair of numbers in a collection. The input is sorted first, then adjacent values are compared to determine the minimum distance.

Techniques demonstrated:

- Array sorting
- Minimum-distance comparison
- Sequential array traversal

### Consecutive Range Compression

This program sorts a collection of integers and compresses consecutive values into ranges. For example, values such as `1, 2, 3, 7, 8` are displayed as `1-3 7-8`.

Techniques demonstrated:

- Sorting
- Array traversal
- Consecutive-sequence detection

### Sorting Performance Comparison

This program compares the performance of several sorting algorithms using ascending, descending, and randomly generated input.

Algorithms included:

- Insertion Sort
- Quick Sort
- Quick Sort using Median-of-Three pivot selection

The program measures execution time and compares the performance of the algorithms under different input arrangements.

### Depth-First Search

This program performs a recursive Depth-First Search traversal on a directed graph represented by an adjacency list. Each vertex is assigned a visitation number based on the order in which it is visited.

Techniques demonstrated:

- Graph traversal
- Recursion
- Adjacency lists
- Vertex marking

### Traveling Salesman Problem

This program solves a weighted Traveling Salesman Problem using brute force. It generates every possible permutation of the vertices, calculates the total cost of each route, and selects the least expensive route that returns to the starting vertex.

Techniques demonstrated:

- Brute-force search
- Permutations
- Weighted graphs
- Adjacency matrices

### Topological Sort

This program performs a topological sort using Kahn’s algorithm. It calculates the in-degree of each vertex and uses a queue to process vertices with no remaining prerequisites. If a cycle exists, the program reports that no valid ordering is possible.

Techniques demonstrated:

- Directed graphs
- In-degree calculation
- Queues
- Cycle detection

### Floyd-Warshall

The Floyd-Warshall algorithm calculates the shortest paths between every pair of vertices in a weighted graph. The program uses a matrix representation and progressively considers each vertex as an intermediate point.

Techniques demonstrated:

- Dynamic programming
- All-pairs shortest paths
- Weighted adjacency matrices

### Max Heap

This program creates and manipulates a max heap. It supports bottom-up heap construction, insertion, deletion of the maximum value, displaying the maximum value, and displaying the complete heap.

Techniques demonstrated:

- Heap data structures
- Bottom-up heap construction
- Heap insertion
- Heap deletion
- Sift-up and sift-down operations

### Linear Probing Hash Table

This program implements a hash table using linear probing to resolve collisions. It supports insertion, searching, table status checks, and automatic rehashing when the load factor exceeds 0.5.

Techniques demonstrated:

- Hash tables
- Modular hashing
- Linear probing
- Collision resolution
- Rehashing

### Coin Collection

This program solves the Coin Collection problem using dynamic programming. A robot starts in the upper-left cell of a matrix and can move only right or down. The program calculates the maximum number of coins that can be collected and reconstructs an optimal path.

Techniques demonstrated:

- Dynamic programming
- Matrix-based recurrence relations
- Optimal-path reconstruction
- Backtracking
