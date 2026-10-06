/*
 * INSTRUCTION:
 *     This is a Java staring code for hw4_2.
 *     When you finish the development, download this file and and submit to Canvas
 *     according to the submission instructions.

 *     Please DO NOT change the name of the main class "Main"
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Title: Topological Sorting using Kahn's Algorithm
 * Abstract: The program conducts the topological sorting based on Kahn Algorithm. 
 * It reads the number of vertices and edges, and then constructs the graph using an adjacency list. 
 * The program calculates the in-degrees of each vertex and uses a queue to perform the topological sorting. 
 * Finally, it outputs the indegrees and the sorted order of vertices. If a cycle is found, it indicates that no order exists.
 * Reference: The logic and pseudocode within lecture video on Kahns Algorithm Module 5 and https://www.youtube.com/watch?v=cIBFEhD77b4& 
 * Name: Brandon Nhep
 * Date: 2/10/2026
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Main 
{
    //Global class variables
    static int verticesAmount;
    static int edgesAmount;
    //List for edge information as an adjacency list
    static ArrayList<ArrayList<Integer>> edgeInfo;
    //Queue data structure as a linked list for FIFO order
    static Queue<Integer> q = new LinkedList<>();
    //Array to track indegrees of each vertex
    static int[] inDegree;
    //Store the topological order of vertices after processing
    static ArrayList<Integer> topologicalOrder = new ArrayList<>();

    public static void main(String[] args) {

        //Creating a scanner object to take in input
        Scanner userInput = new Scanner(System.in);

        //Takes in user input as nextInt, this input will the counter for next amount of inputs
        verticesAmount = userInput.nextInt();
        edgesAmount = userInput.nextInt();

        //Initialize inDegree array after reading verticesAmount
        inDegree = new int[verticesAmount];

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

        //Calculate in-degrees for each vertex going through adjacency list
        //inDegree index is the value at the current index of the adj list
        for (int i = 0; i < verticesAmount; i++) {
            for (int j = 0; j < edgeInfo.get(i).size(); j++) {
                int adjacent = edgeInfo.get(i).get(j);
                inDegree[adjacent]++;
            }
        }

        //Output the inDegrees after calculating
        for (int i = 0; i < verticesAmount; i++) {
            System.out.println("In-degree[" + i + "]:" + inDegree[i]);
        }

        //Add all vertices with in-degree 0 to the queue since no prerequisites
        for (int i = 0; i < verticesAmount; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        //Follows closely to the algorithm instruction in lecture video
        while (!q.isEmpty()) {
            int current = q.remove();
            topologicalOrder.add(current);
            //For each adjacent vertex, decrement its in-degree
            for (int i = 0; i < edgeInfo.get(current).size(); i++) {
                int adjacent = edgeInfo.get(current).get(i);
                inDegree[adjacent]--;
                //If in-degree becomes 0, add to queue
                if (inDegree[adjacent] == 0) {
                    q.add(adjacent);
                }
            }
        }

        //Display topological order
        //If not all vertices were processed, there's a cycle
        if (topologicalOrder.size() < verticesAmount) {
            System.out.println("No Order:");
        } else {
            System.out.print("Order:");
            for (int i = 0; i < topologicalOrder.size(); i++) {
                System.out.print(topologicalOrder.get(i));
                if (i < topologicalOrder.size() - 1) {
                    System.out.print("->");
                }
            }
            System.out.println();
        }
    }
}

