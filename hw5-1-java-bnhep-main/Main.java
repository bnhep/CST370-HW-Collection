/*
 * INSTRUCTION:
 *     This is a Java staring code for hw5_1.
 *     When you finish the development, download this file and and submit to Canvas
 *     according to the submission instructions.

 *     Please DO NOT change the name of the main class "Main"
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Title: Heap Operations Max Heap Bottom-Up Insert/Delete
 * Abstract: The program will process inputs to build a max heap using the bottom-up method 
 * and perform various heap operations such as insertions and deletions. The program will accept input from the user
 * starting with the number of elements to be added to the heap, along with the element values themselves. Then
 * the program will read a integer input of the amount of operations to be used on the heap,
 * followed by the operations themselves. The program will output if it is a max heap or not,
 * and the various outputs of the operations performed on the heap. If its not a max heap, the program will build
 * a max heap using the bottom-up method adapted/referenced to the pseudocode in the book
 * and perform the operations on the newly built max heap.
 * Name: Brandon Nhep
 * Date: 2/17/2026
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
 
class Main 
{
    //Global class variables
    static int[] inputArray;
    static int arrayAmount;
    static int operationAmount;
    static int arrSize;
    static ArrayList<ArrayList<String>> operations;
    static int heapMax;
    static boolean isMaxHeap;

    /*
    * Check if the input array is a max heap, based off the definitions of a max heap
    * in the book H[i] ≥ max{H[2i], H[2i + 1]} for i = 1, . . . , ⌊n/2⌋.
    * "define a heap as an array H[1..n] in which every element
    * in position i in the first half of the array is greater than or equal to the elements
    * in positions 2i and 2i + 1"
    * @param arr the array to be checked
    * @returns true if array is a max heap, false otherwise
    */
    static boolean checkMaxHeap(int[] arr, int n) {
        for (int i = 1; i <= n/2; i++) {
            int leftChild = 2 * i;
            int rightChild = 2 * i + 1;
            
            //Check left child
            if (leftChild <= n && arr[i] < arr[leftChild]) {
                return false;
            }
            //Check right child
            if (rightChild <= n && arr[i] < arr[rightChild]) {
                return false;
            }
        }
        return true;
    }

    /*
    * Build a max heap using the bottom-up method adapted/referenced to the pseudocode in the book
    * @param arr the array to be transformed into a max heap
    * @param n the number of elements in the array
    */
    static void buildMaxHeap(int[] arr, int n) {
        for (int i = n/2; i >= 1; i--) {
            int currentIndex = i;
            int value = arr[currentIndex];
            boolean heap = false;

            while (!heap && 2 * currentIndex <= n) {
                int largerChildIndex = 2 * currentIndex;
                
                if (largerChildIndex < n) {
                    if (arr[largerChildIndex] < arr[largerChildIndex + 1]) {
                        largerChildIndex = largerChildIndex + 1;
                    }
                }
                if (value >= arr[largerChildIndex]) {
                    heap = true;
                } else {
                    arr[currentIndex] = arr[largerChildIndex];
                    currentIndex = largerChildIndex;
                }
            }
            arr[currentIndex] = value;
        }
    }

    public static void main(String[] args) {

        //Creating a scanner object to take in input
        Scanner userInput = new Scanner(System.in);

        //Taking in the amount of elements to be added to the heap
        arrayAmount = userInput.nextInt();

        //Initializing the input array to the amount of elements
        inputArray = new int[arrayAmount];

        //Taking in the elements to be added to the heap
        for (int i = 0; i < arrayAmount; i++) {
            inputArray[i] = userInput.nextInt();
        }

        //Taking in the amount of operations to be performed on the heap
        operationAmount = userInput.nextInt();

        //Process the operations to be performed on the heap using 1 based indexing
        operations = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < operationAmount; i++) {
            ArrayList<String> operation = new ArrayList<String>();
            String operationType = userInput.next();
            operation.add(operationType);

            if (operationType.equals("insert")) {
                int insertValue = userInput.nextInt();
                operation.add(Integer.toString(insertValue));
            }
            operations.add(operation);
        }

        //Allocate the heap array to the amount of elements in the input array and with inserted elements in mind
        heapMax = arrayAmount + operationAmount + 1;
        int[] heapArray = new int[heapMax];
        arrSize = arrayAmount;
        System.arraycopy(inputArray, 0, heapArray, 1, arrayAmount);

        //Check if the input array is a max heap
        isMaxHeap = checkMaxHeap(heapArray, arrSize);

        //Output if the input array is a max heap
        if (isMaxHeap) {
            System.out.println("This is a heap.");
        } else {
            System.out.println("This is NOT a heap.");
            buildMaxHeap(heapArray, arrSize);
        }

        //Perform the operations on the heap based on the input operations from before
        for (int i = 0; i < operations.size(); i++) {
            ArrayList<String> operation = operations.get(i);
            String operationType = operation.get(0);

            if (operationType.equals("insert")) {
                int insertValue = Integer.parseInt(operation.get(1));
                arrSize++;
                heapArray[arrSize] = insertValue;
                //CurrentIndex starts at the index of the newly inserted value, 
                //and continues up the heap until it becomes a heap
                int currentIndex = arrSize;
                int value = heapArray[currentIndex];
                boolean heap = false;

                while (!heap && currentIndex > 1) {
                    int parentIndex = currentIndex / 2;
                    //Check if the parent value is less than the current value,
                    //if so swap and continue up the heap
                    if (heapArray[parentIndex] < value) {
                        heapArray[currentIndex] = heapArray[parentIndex];
                        currentIndex = parentIndex;
                    } else {
                        heap = true;
                    }
                }
                heapArray[currentIndex] = value;
            } else if (operationType.equals("deleteMax")) {
                //Remove the max value at the root of the heap, replace it with the last value in the heap,
                //and then continue down the heap until it becomes a heap again
                int maxValue = heapArray[1];
                heapArray[1] = heapArray[arrSize];
                arrSize--;
                int currentIndex = 1;
                int value = heapArray[currentIndex];
                boolean heap = false;

                while (!heap && 2 * currentIndex <= arrSize) {
                    int largerChildIndex = 2 * currentIndex;
                    if (largerChildIndex < arrSize && heapArray[largerChildIndex] < heapArray[largerChildIndex + 1]) {
                        largerChildIndex = largerChildIndex + 1;
                    }
                    if (value >= heapArray[largerChildIndex]) {
                        heap = true;
                    } else {
                        heapArray[currentIndex] = heapArray[largerChildIndex];
                        currentIndex = largerChildIndex;
                    }
                }
                heapArray[currentIndex] = value;
            } else if (operationType.equals("displayMax")) {
                //Output the max value at the root of the heap
                System.out.println(heapArray[1]);
            } else if (operationType.equals("display")) {
                //Display Heap print first value, then space values after
                System.out.print(heapArray[1]);
                for (int j = 2; j <= arrSize; j++) {
                    System.out.print(" " + heapArray[j]);
                }
                System.out.println();
            }
        }
        userInput.close();   
    }
}

