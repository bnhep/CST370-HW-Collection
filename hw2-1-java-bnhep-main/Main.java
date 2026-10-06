/*
 * INSTRUCTION:
 *     This is a Java staring code for hw2_1.
 *     When you finish the development, download this file and and submit to Canvas
 *     according to the submission instructions.
 *
 *     Please DO NOT change the name of the main class "Main"
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Title: Homework2 Closest Distance
 * Abstract: The program reads in inputs from a user and displays the closest distance between two numbers among all input numbers.
 * The first number entered by the user will represent the amount of inputs that should be taken after, It will accept the
 * specified number of inputs and place them in a sorted array, where it will be iterated through to determined the closest 
 * distance among the pair of numbers within the array. It will save the minimum distance, iterate through the array 
 * again to find the pairs that have that minimum distance and output the results. Results will display the minimum distance 
 * and the pairs. Utilizes java's scanner, array, and collections util library.
 * Name: Brandon Nhep
 * Date: 1/19/2026
 */
 
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

class Main 
{
    public static void main(String[] args) {

        //Creating a scanner object to take in input
        Scanner userInput = new Scanner(System.in);

        //Takes in user input as nextInt, this input will the counter for next amount of inputs
        int counterInput = userInput.nextInt();

        //Creates an array to store the inputs after the input determining the amount of inputs after
        int[] inputArray = new int[counterInput];
        for (int i = 0; i < counterInput; i++) {
            inputArray[i] = userInput.nextInt();
        }

        //Sorts the array in ascending order
        Arrays.sort(inputArray);

        //Iterate through the array to determine the minimum distance
        //First pair distance as the start comparison
        int minDistance = inputArray[1] - inputArray[0];
        //Iterate through next pair
        for (int i = 1; i < inputArray.length - 1; i++) {
            //Distance between the next highest number and the current number
            int distanceCheck = inputArray[i + 1] - inputArray[i];
            if (distanceCheck < minDistance) {
                minDistance = distanceCheck;
            }
        }

        //Prints out the minimum distance
        System.out.println("Min Distance:" + minDistance);

        //Iterate through array again to find pairs with the minimum distance and output them
        for (int i = 0; i < inputArray.length - 1; i++) {
            int distanceCheck = inputArray[i + 1] - inputArray[i];
            if (distanceCheck == minDistance) {
                System.out.println("Pair:"+ inputArray[i] + " " + inputArray[i + 1]);
            }
        }   

        //Checking the sorted array
        // for (int i = 0; i < inputArray.length; i++) {
        //     
        //     System.out.println(inputArray[i]);        
        // }
        //System.out.print(Arrays.toString(inputArray));  
    }
}

