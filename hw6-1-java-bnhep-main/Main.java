/*
 * INSTRUCTION:
 *     This is a Java staring code for hw6_1.
 *     When you finish the development, download this file and and submit to Canvas
 *     according to the submission instructions.

 *     Please DO NOT change the name of the main class "Main"
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Title: Coin Collection Problem - Max coins optimal path
 * Abstract: The program will find the best path to collect the maximum number of coins that can be collected in a matrix
 * starting from the leftmost row/column(cell) of the matrix and moving to the right or down until it reaches the rightmost row/column(cell).
 * It will first prompt the user to input the number of rows and columns of the matrix, then it will prompt the user to input the values of the matrix
 * which will be the number of coins in each row/column(cell). The value will either be a 0 or 1, 0 for no coin and 1 for a coin. 
 * The program will then calculate the maximum number of coins that can be collected and the path taken to collect those coins,
 * and output the results to the user. Utilizes the pseudocode provided in the book under page 289 and references the lecture's
 * matrix creation recurrence logic and backtracking.
 * Name: Brandon Nhep
 * Date: 2/23/2026
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
 
class Main 
{
    //Global variables
    static int rowAmount;
    static int colAmount;
    static int[][] initialMatrix;
    static int[][] finalMatrix;
    
    /*
    * This function will setup the table based off the initialized matrix
    * which contains the number of coins in each cell. It will use the formula F[i][j] = max(F[i-1][j], F[i][j-1]) + C[i][j]
    * to fill out the table and find the maximum number of coins that can be collected at each cell. 
    * The function updates the global table finalMatrix with the maximum number of coins 
    * that can be collected at each cell.
    * @param none
    * @param none
    */
    public static void coinSetup() {
        //"Coins outside the board" are initialized to 0
        finalMatrix = new int[rowAmount + 1][colAmount + 1];
        
        //F[i][j] = max(F[i-1][j], F[i][j-1]) + C[i][j]
        //Calculate the maximum number of coins that can be collected at each cell
        for (int i = 1; i <= rowAmount; i++) {
            for (int j = 1; j <= colAmount; j++) {
                finalMatrix[i][j] = Math.max(finalMatrix[i - 1][j], finalMatrix[i][j - 1]) + initialMatrix[i][j];
            }
        }
    }

    /*
    * Go through the final calculated matrix and backtrack to find the path taken to collect the maximum number of coins
    * that can be collected at each cell. Start from bottommost right corner of the matrix and move up or left
    * depending on which cell has more counted compared to the current cell.
    * If the cell above has more coins than the current cell then move up, if the cell to the left has 
    * more coins than the current cellt then move left. If both cells have the same amount of coins, then preference left.
    * Keeps track of the cell coordinates and the backtracked path until it reaches the topmost left corner of the matrix.
    * Then output the path taken to collect the maximum number of coins.
    * @param the final calcualted matrix
    * @param none
    */
    public static void backtrack(int[][] F) {
        LinkedList<String> path = new LinkedList<>();
        int i = rowAmount;
        int j = colAmount;
        
        //Start from destination and go backwards stops at 1,1
        while (i > 1 || j > 1) {
            //Save the path in linked list
            path.addFirst("(" + i + "," + j + ")");

            //Prefer left when there's a tie
            if (i == 1) {
                j--; 
            } else if (j == 1) {
                i--;
            } else if (F[i][j - 1] >= F[i - 1][j]) {
                j--;
            } else {
                i--;
            }
        }
        //Add the starting cell
        path.addFirst("(1,1)");
        
        //Output the path
        System.out.print("Path:");
        for (int k = 0; k < path.size(); k++) {
            System.out.print(path.get(k));
            if (k != path.size() - 1) {
                System.out.print("->");
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {

        //Creating a scanner object to take in input
        Scanner userInput = new Scanner(System.in);
        
        //Prompting the user to input the number of rows and columns of the matrix
        rowAmount = userInput.nextInt();
        colAmount = userInput.nextInt();

        //Creates a matrix to store the number of coins in each cell, and takes in the values from the user
        //Coins outside the board are 0, starts from index cell (1,1) to (rowAmount, colAmount)
        initialMatrix = new int[rowAmount + 1][colAmount + 1];
        for (int i = 1; i <= rowAmount; i++) {
            for (int j = 1; j <= colAmount; j++) {
                initialMatrix[i][j] = userInput.nextInt();
            }
        }

        //Close the scanner object
        userInput.close();

        //Configure the table to find the maximum number of coins that can be collected
        coinSetup();
         
        System.out.println("Max coins:" + finalMatrix[rowAmount][colAmount]);
        // for (int i = 0; i <= rowAmount; i++) {
        //     for (int j = 0; j <= colAmount; j++) {
        //         System.out.print(finalMatrix[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        //Backtrack to find the path
        backtrack(finalMatrix);
    }
}

