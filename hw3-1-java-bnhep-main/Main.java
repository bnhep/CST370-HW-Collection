/*
 * INSTRUCTION:
 *     This is a Java staring code for hw3_1.
 *     When you finish the development, download this file and and submit to Canvas
 *     according to the submission instructions.

 *     Please DO NOT change the name of the main class "Main"
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Title: Homework 3-1 Depth First Search
 * Abstract: The program takes integer inputs from the user and applies a depth first search algorithm
 * referencing the pseudocode given in the book/homework doc and outputs the marked vertices array each line, 
 * The first input will be the number of vertices, second input will be number of edges, and the next pairs of integer 
 * will be the edge information where the paired numbers are the vertices from vertex1->vertex2 etc.. 
 * It utilizes a way to keep track of the edge information, mark array, and utilizes
 * implicit stack with the recursive function. Uses ArrayLists to keep track of the edge information as 
 * an adjacency list to store adjacent vertices. Helper methods are used from Java Collections class, ArrayList class, and Scanner class.
 * Name: Brandon Nhep
 * Date: 1/26/2026
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

class Main 
{
    //Global class variables
    static int verticesAmount;
    static int edgesAmount;
    //List for edge information as an adjacency list
    static ArrayList<ArrayList<Integer>> edgeInfo;

    //Mark array to keep track of visited vertices
    static int[] markArray;

    //Count for the recursive call, number to give when encountered/visited
    static int count = 0;

    /*
    * Recursive DFS function that marks the vertices as visited
    * and gives them a number based on the order they were visited
    * @param the vertex to start the DFS recursion
    */
    public static void dfs(int v) {
        count++;
        markArray[v] = count;
        //Visit all neighbors of v in ascending order
        //pseudocode reference: for each vertex w in V adjacent to v do
        for (int i = 0; i < edgeInfo.get(v).size(); i++) {
            int vertex = edgeInfo.get(v).get(i);
            if (markArray[vertex] == 0) {
                dfs(vertex);
            }
        }
    }

    public static void main(String[] args) {
        
        //Creating a scanner object to take in input
        Scanner userInput = new Scanner(System.in);

        //Takes in user input as nextInt, this input will the counter for next amount of inputs
        verticesAmount = userInput.nextInt();
        edgesAmount = userInput.nextInt();

        //Create the adjacency list
        edgeInfo = new ArrayList<>();
        for (int i = 0; i < verticesAmount; i++) {
            edgeInfo.add(new ArrayList<>());            
        }

        //Populates the adjacency list reading in the edge information inputs
        //the index of the loop represents the first vertex, the value at that index is the list of adjacent vertices to it
        //edgeInfo.get(i) = list of vertices adjacent to vertex i
        for (int i = 0; i < edgesAmount; i++) {
            int vertex1 = userInput.nextInt();
            int vertex2 = userInput.nextInt();
            edgeInfo.get(vertex1).add(vertex2);
        }

        //Sort the list in ascending order to make it easier to navigate
        //Similar to how adjacency list is alphabetically ordered in book
        for (int i = 0; i < verticesAmount; i++) {
            Collections.sort(edgeInfo.get(i));
        } 
        
        //Mark array initialization, all values set to 0 by default
        //pseudocode- mark each vertex in V with 0 as a mark of being “unvisited”
        markArray = new int[verticesAmount];

        //DFS() main from pseudocode, call for each vertex
        for (int i = 0; i < verticesAmount; i++) {
            if (markArray[i] == 0) {
                dfs(i);
            }
        }

        //Output the mark array for each vertex
        for (int i = 0; i < verticesAmount; i++) {
            System.out.println("Mark[" + i + "]:" + markArray[i]);
        }

        //close the scanner object
        userInput.close();
    }
}

