/*
 * INSTRUCTION:
 *     This is a Java staring code for hw6_2.
 *     When you finish the development, download this file and and submit to Canvas
 *     according to the submission instructions.

 *     Please DO NOT change the name of the main class "Main"
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Title: Floyd's Algorithm All Pairs Shortest Path
 * Abstract: This program implements Floyd's algorithm to find the shortest paths between all pairs of vertices in a weighted graph.
 * The program will start by taking in user input for the number of vertices in the input graph. The next following lines
 * will be the values/weights of the edges between the vertices. A -1 value will represent infinity, meaning there is 
 * no direct path between the vertices also makes sure that the diagonals are 0, assumption that all values are non-negative and greater
 * than 0. Output the last matrix after running Floyd's algorithm. References the book's pseudocode, lecture, and hint in the doc.
 * Name: Brandon Nhep
 * Date: 2/24/2026
 */
import java.util.Scanner;

class Main 
{
    //Global variables
    static int verticesAmount;
    static int[][] initialMatrix;

    /*
    * Implements floyd's algorithm to find the shortest paths between all pairs of vertices in a weighted graph.
    * Checks if path are not infinity(-1) before updating the distance, then updates the distance if the new distance
    * is less than the current distance or if the current distance is infinity(-1) since it will be better than infinity.
    * Also double checks if i and j are the same vertex to skip the iteration since the distance from a vertex to itself is always 0.
    * Reference the pseudocode in the book and the hint in the doc.
    * @param none
    * @return returns the final matrix
    */
    public static int[][] floydsAlgorithm() {
        //Initialize the to Update matrix with the initial matrix values
        //D ← W
        int[][] finalMatrix = new int[verticesAmount][verticesAmount];
        for (int i = 0; i < verticesAmount; i++) {
            for (int j = 0; j < verticesAmount; j++) {
                finalMatrix[i][j] = initialMatrix[i][j];
            }
        }

        //for k ← 1 to n do
        for (int k = 0; k < verticesAmount; k++) {
            //for i ← 1 to n do
            for (int i = 0; i < verticesAmount; i++) {
                //for j ← 1 to n do
                for (int j = 0; j < verticesAmount; j++) {
                    //if i = j then continue/skip to the next iteration of the loop
                    if (i == j) {
                        continue;
                    }
                    //If both paths are not infinity(-1) then find the new distance to compare with current
                    //if either path is infinity(-1) then there is no path
                    if (finalMatrix[i][k] != -1 && finalMatrix[k][j] != -1) {
                        int updateDist = finalMatrix[i][k] + finalMatrix[k][j];
                        //Updates minimum distance if the new distance is less than the current distance
                        //or if current distance is infinity(-1) since it will be better than infinity.
                        if (finalMatrix[i][j] == -1 || updateDist < finalMatrix[i][j]) {
                            finalMatrix[i][j] = updateDist;
                        }
                    }
                }
            }
        }
        //return D
        return finalMatrix;
    }

    public static void main(String[] args) {

        //Creating a scanner object to take in input
        Scanner userInput = new Scanner(System.in);
        
        //Prompting the user to input the number of vertices in the graph
        verticesAmount = userInput.nextInt();

        //Filling the initial matrix with the user input values
        initialMatrix = new int[verticesAmount][verticesAmount];
        for (int i = 0; i < verticesAmount; i++) {
            for (int j = 0; j < verticesAmount; j++) {
                initialMatrix[i][j] = userInput.nextInt();
            }
            initialMatrix[i][i] = 0;
        }

        // //Testing output of the initial matrix
        // for (int i = 0; i < verticesAmount; i++) {
        //     for (int j = 0; j < verticesAmount; j++) {
        //         System.out.print(initialMatrix[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        //Close the scanner object
        userInput.close();

        //Floyd's algorithm
        int[][] finalMatrix = new int[verticesAmount][verticesAmount];
        finalMatrix = floydsAlgorithm();

        //Output the final matrix after running Floyd's algorithm
        for (int i = 0; i < verticesAmount; i++) {
            for (int j = 0; j < verticesAmount; j++) {
                if (j > 0) {
                    System.out.print(" ");
                }
                System.out.print(finalMatrix[i][j]);
            }
            System.out.println();
        }
    }
}

