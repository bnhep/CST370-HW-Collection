/*
 * INSTRUCTION:
 *     This is a Java staring code for hw3_2.
 *     When you finish the development, download this file and and submit to Canvas
 *     according to the submission instructions.

 *     Please DO NOT change the name of the main class "Main"
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Title: Homework 3-2 Traveling Salesman Problem
 * Abstract: The program reads in input graph data from a user, and processes the data
 * to find the path and cost for the traveling salesman problem using a brute-force permutation approach.
 * The program will first accept the vertices amounts as an integer input, followed by the amount of edges,
 * followed by the edge information which contain the start vertex, end vertex, and cost; and a last
 * input indicating the start of the path. The graph information will be stored in a 2D array as an adjacency 
 * matrix representation, as it will allow to store the cost between vertices. It then generates all possible 
 * permutations of the vertices to check the total travel cost for each permutation. 
 * Finally, it will determine and output the minimum cost path, along with the corresponding cost value.
 * Utilizing a slightly modified version of the given all_permutations procedure to generate permutations 
 * and calculate the cost of each permutation path.
 * Utilizes 2d arrays to create the matrix and store the costs.
 * Helper methods are used from Java Collections class, ArrayList class, and Scanner class.
 * Name: Brandon Nhep
 * Date: 1/27/2026
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
 
class Main 
{
    //Global variables
    static int verticesAmount;
    static int edgesAmount;
    static int startVertex;

    //Adjacency matrix to store graph information
    static int[][] adjacencyMatrix;

    //Path and minimum cost variables
    static ArrayList<Integer> minPath = new ArrayList<>();
    static int minCost = -1;

    /*
    * Permutation method to generate all permutations of the input array
    * utilized from the given all_permutations procedure
    * @param input the array of vertices to generate permutations from
    * @param startindex the starting index for the current permutation
    */
    public static void Permute(int[] input, int startindex) {
        int size = input.length;

        if (size == startindex + 1) {
            // for (int i = 0; i < size; i++) {
            //     System.out.print(input[i] + "  ");
            // }
            // System.out.println();
            costCalculate(input);
            return;
        } else {
            for (int i = startindex; i < size; i++) {
                int temp = input[i];
                input[i] = input[startindex];
                input[startindex] = temp;

                Permute(input, startindex + 1);
                
                temp = input[i];
                input[i] = input[startindex];
                input[startindex] = temp;
            }
        }
    }

    /*
    * Calculate the cost of the current permutation path
    * from starting vertex to the first vertex in the path
    * then through all vertices in the path and back to starting vertex
    * @param array of permutation path vertices
    */
    public static void costCalculate(int[] path) {

        int costCheck = 0;
        int currentVertex = startVertex;

        //Check edge from starting vertex to first vertex in path
        //starting vertex -> path[0]
        if (adjacencyMatrix[currentVertex][path[0]] == -1) {
            return;
        }
        costCheck += adjacencyMatrix[currentVertex][path[0]];
        currentVertex = path[0];

        //Go through the rest of the path
        for (int i = 1; i < path.length; i++) {
            if (adjacencyMatrix[currentVertex][path[i]] == -1) {
                return;
            }
            costCheck += adjacencyMatrix[currentVertex][path[i]];
            currentVertex = path[i];
        }
        
        //Check the last edge from last vertex to starting vertex
        //path[n-1] -> starting vertex
        if (adjacencyMatrix[currentVertex][startVertex] == -1) {
            return;
        }
        costCheck += adjacencyMatrix[currentVertex][startVertex];

        //Check if current cost is less than minimum cost found
        //if so, update minimum cost and path
        if (minCost == -1 || costCheck < minCost) {
            minCost = costCheck;
            minPath.clear();
            for (int i = 0; i < path.length; i++) {
                minPath.add(path[i]);
            }
        }
    }

    public static void main(String[] args) {

        //Creating a scanner object to take in input
        Scanner userInput = new Scanner(System.in);

        //Takes in user input as nextInt, this input will the counter for next amount of inputs
        verticesAmount = userInput.nextInt();
        edgesAmount = userInput.nextInt();        
        
        //Initialize the adjacency matrix with size of verticesAmount x verticesAmount
        adjacencyMatrix = new int[verticesAmount][verticesAmount];

        //Filling the adjacency matrix with -1 to indicate no edges between vertices
        for (int i = 0; i < verticesAmount; i++) {
            Arrays.fill(adjacencyMatrix[i], -1);
        }

        //Take in user input for edge information “source vertex”, “destination vertex”, and “cost”
        for (int i = 0; i < edgesAmount; i++) {
            int sourceVertex = userInput.nextInt();
            int destinationVertex = userInput.nextInt();
            int cost = userInput.nextInt();

            //Update the adjacency matrix with the cost for the given edge
            adjacencyMatrix[sourceVertex][destinationVertex] = cost;
        }

        // //Checking adjacency matrix input in console
        // System.out.println("Adjacency Matrix:");
        // for (int i = 0; i < verticesAmount; i++) {
        //     for (int j = 0; j < verticesAmount; j++) {
        //         System.out.print(adjacencyMatrix[i][j] + " ");      
        //     }
        //     System.out.println();
        // }

        //Take in the starting vertex, last input from user
        startVertex = userInput.nextInt();

        //Creates the array of vertices to generate permutations
        //removes the starting vertex given from user input.
        int[] vertices = new int[verticesAmount - 1];
        int index = 0;
        for (int i = 0; i < verticesAmount; i++) {
            if (i != startVertex) {
                vertices[index++] = i;
            }
        }
        // System.out.println("Permutations:");
        //Generate all permutations of vertices
        Permute(vertices, 0);

        //Output the path and cost
        //Check if a path exists
        if (minCost == -1) {
            //No path exists
            System.out.println("Path:");
            System.out.println("Cost:-1");
        } else {
            //Path found
            System.out.print("Path:");
            System.out.print(startVertex + "->");
            for (int i = 0; i < minPath.size(); i++) {
                System.out.print(minPath.get(i) + "->");
            }
            System.out.println(startVertex);
            System.out.println("Cost:" + minCost);
        }

        //Close the scanner object
        userInput.close();
    }
}

