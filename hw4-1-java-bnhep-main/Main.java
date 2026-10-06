/*
 * INSTRUCTION:
 *     This is a Java staring code.
 *     When you finish the development, download this file and and submit to Canvas
 *     according to the submission instructions.

 *     Please DO NOT change the name of the main class "Main"
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Title: Quick sort and Insertion Sort performance comparison
 * Abstract: The program will prompt the user to enter an input size and offers three options for that input.
 * The input options will be ascending order, descending order, or a random order. Afterwards the program will 
 * generate the input based on the user's choice and then sort the input using quick sort, and providing options for the user
 * to use insertion sort as well as the option to run quick sort with median of three. If the input value is less than or equal to 20
 * the program will also output the input generated and the sorted output results for the algorithms or else don't if user chooses not to.
 * Lastly the program will output the time taken for each sorting algorithm to complete and rank them. Utilizes the pseudocode provided in the
 * document for the different sorting algorithms.
 * Reference: The time measurement code https://www.geeksforgeeks.org/java/measure-time-taken-function-java/
 * also https://www.youtube.com/watch?v=dOYieTlItMM, and module 5 documents for the median of three partitioning.
 * Name: Brandon Nhep
 * Date: 2/9/2026
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.Comparator;

class Main 
{
    //Global class variables
    static int inputSize;
    static int inputType;
    static char insertionSortOption;
    static char medianOfThreeOption;
    static int[] inputArray;

    /*
    * Quick sort with first element as pivot, sorting a subarray of the input array from index left to index right
    * Following the pseudocode provided in the document.
    * @param array, index left, index right 
    * @returns sorted array in non-decreasing order
    */
    public static void quickSort(int[] inputArr, int l, int r) {
        if (l < r) {
            int s = partition(inputArr, l, r);
            quickSort(inputArr, l, s - 1);
            quickSort(inputArr, s + 1, r);
        }
    }

    /*
    * Partition method for quick sort, using the first element as the pivot
    * Following the pseudocode provided in the document.
    * @param array, index left, index right 
    * @returns partition of array, split posistion of the pivot element
    */
    public static int partition(int[] inputArr, int l, int r) {
        int pivot = inputArr[l];
        int i = l;
        int j = r + 1;
        //repeat until
        do {
            //repeat until
            do {
                i++;
            } while (inputArr[i] < pivot);
            //repeat until
            do {
                j--;
            } while (inputArr[j] > pivot);
            //swap inputArr[i] and inputArr[j]
            swap(inputArr, i, j);
        } while (i < j);

        //Undo last swap when i >= j
        swap(inputArr, i, j);

        //Swap inputArr[l] and inputArr[j]
        swap(inputArr, l, j);
        return j;
    }

    /*
    * Insertion sort, sorting the input array in non-decreasing order
    * Following the pseudocode provided in the document.
    * @param array, index left, index right 
    * @returns sorted array in non-decreasing order
    */
    public static void insertionSort(int[] inputArr) {      
        for (int i = 1; i < inputSize; i++) {
            int v = inputArr[i];
            int j = i - 1;
            while (j >= 0 && inputArr[j] > v) {
                inputArr[j + 1] = inputArr[j];
                j--;
            }
            inputArr[j + 1] = v;
        }
    }

    /*
    * Quick sort with MedianofThree, sorting a subarray of the input array from index left to index right
    * Following the pseudocode provided in the document.
    * @param array, index left, index right 
    * @returns sorted array in non-decreasing order
    */
    public static void quickSortMedianOfThree(int[] inputArr, int l, int r) {
        if (l < r) {
            int s = partitionMedianOfThree(inputArr, l, r);
            quickSortMedianOfThree(inputArr, l, s - 1);
            quickSortMedianOfThree(inputArr, s + 1, r);
        }
    }

    /*
    * Partition method for quick sort, using the median of three as the pivot
    * After sorting three elements in ascending order, the first and last are already
    * correctly positioned. The median is swapped to position l+1 and only elements
    * from l+1 to r-1 need to be partitioned. Uses explicit boundaries for the inner loops to avoid out of bounds errors.
    * instead of the max boundary in first partition method.
    * Implements the partitioning logic from the pseudocode provided in the document, 
    * with adjustments for the new pivot position and boundaries. Follows the functionality of the Median-Of-Three document
    * in module 5.
    * @param array, index left, index right 
    * @returns partition of array, split posistion of the pivot element
    */
    public static int partitionMedianOfThree(int[] inputArr, int l, int r) {
        //Find the median of the first, middle, and last elements
        int mid = l + (r - l) / 2;
        int median = medianOfThreeIndex(inputArr, l, mid, r);
        
        //Swap median to position l+1
        swap(inputArr, l + 1, median);

        //Partition logic from l+1 to r with pivot at l+1
        int pivot = inputArr[l + 1];
        int i = l + 1;
        int j = r;
        //repeat until
        do {
            //repeat until
            do {
                i++;
            } while (i < r && inputArr[i] < pivot);
            //repeat until
            do {
                j--;
            } while (j > l && inputArr[j] > pivot);
            //swap inputArr[i] and inputArr[j]
            if (i < j) {
                swap(inputArr, i, j);
            }
        } while (i < j);

        //Swap pivot from l+1 to its final position at j
        swap(inputArr, l + 1, j);
        return j;
    }

    /*
    * Method to find the index of the median of the first, middle, and last elements of a subarray
    * Swaps the three elements at positions l, mid, r in ascending order.
    * After swaps: inputArr[l] <= inputArr[mid] <= inputArr[r]
    * Returns the index of the median element.
    * @param array, index left, index mid, index right 
    * @returns index of the median element
    */
    public static int medianOfThreeIndex(int[] inputArr, int l, int mid, int r) {
        //Sort three elements in ascending order
        if (inputArr[l] > inputArr[mid]) {
            swap(inputArr, l, mid);
        }
        if (inputArr[l] > inputArr[r]) {
            swap(inputArr, l, r);
        }
        if (inputArr[mid] > inputArr[r]) {
            swap(inputArr, mid, r);
        }
        return mid;
    }

    /*
    * Method to swap two elements in an array with given indices
    * @param array, index 1, index 2
    * @returns array with the two elements swapped
    */
    public static void swap(int[] inputArr, int i, int j) {
        int temp = inputArr[i];
        inputArr[i] = inputArr[j];
        inputArr[j] = temp;
    }

    public static void main(String[] args) {

        //Creating a scanner object to take in input
        Scanner userInput = new Scanner(System.in);

        //Prompting the user to enter an input size
        System.out.print("Enter input size: ");
        inputSize = userInput.nextInt();
        System.out.println("========== Select Option for Input Numbers ==========");
        //Selecting the input type
        System.out.println("     1. Ascending Order");
        System.out.println("     2. Descending Order");
        System.out.println("     3. Random Order");
        System.out.print("Choose option: ");
        inputType = userInput.nextInt();

        //Generating the input based on the user's choice
        inputArray = new int[inputSize + 1];
        //Generate in ascending order 1,2,3,...,n
        if (inputType == 1) {
            for (int i = 0; i < inputSize; i++) {
                inputArray[i] = i + 1;
            }
        //Generate in descending order n, n-1, n-2,...,1
        } else if (inputType == 2) {
            for (int i = 0; i < inputSize; i++) {
                inputArray[i] = inputSize - i;
            }
        //Generate in random order, range of the random numbers should be 0 to 10*(input size)
        } else if (inputType == 3) {
            Random random = new Random();
            int maxValue = inputSize * 10;
            for (int i = 0; i < inputSize; i++) {
                inputArray[i] = random.nextInt(maxValue + 1);
            }
        } else {
            System.out.println("Invalid option. Please choose 1, 2, or 3.");
            return;
        }
        inputArray[inputSize] = Integer.MAX_VALUE;

        //Run insertion sort(y/n)? y
        //Run quick sort with Median of Three(y/n)? n
        System.out.println();
        System.out.print("Run insertion sort(y/n)? ");
        insertionSortOption = userInput.next().charAt(0);
        System.out.print("Run quick sort with Median of Three(y/n)? ");
        medianOfThreeOption = userInput.next().charAt(0);
        System.out.println();

        //Close the scanner object
        userInput.close();

        //Call the sorting algorithms
        //Make a copy of the input array for each sorting algorithm to ensure they are sorting the same input
        int[] copyForInsertionSort = Arrays.copyOf(inputArray, inputArray.length);
        int[] copyForQuickSort = Arrays.copyOf(inputArray, inputArray.length);
        int[] copyForMedianOfThree = Arrays.copyOf(inputArray, inputArray.length);

        //Declare timing variables
        double durationQuickSort = 0;
        double durationInsertionSort = -1;
        double durationMedianOfThree = -1;

        //Run quick sort with first element as pivot(regular quick sort)
        long start = System.nanoTime();
        quickSort(copyForQuickSort, 0, inputSize - 1);
        long end = System.nanoTime();
        durationQuickSort = (end - start) / 1000000.0;

        //Run insertion sort if the user chose to and calculate the time taken for it to complete
        if (insertionSortOption == 'y' || insertionSortOption == 'Y') {
            start = System.nanoTime();
            insertionSort(copyForInsertionSort);
            end = System.nanoTime();
            durationInsertionSort = (end - start) / 1000000.0; 
        }

        //run quick sort with median of three if the user chooses to
        if (medianOfThreeOption == 'y' || medianOfThreeOption == 'Y') {
            start = System.nanoTime();
            quickSortMedianOfThree(copyForMedianOfThree, 0, inputSize - 1);
            end = System.nanoTime();
            durationMedianOfThree = (end - start) / 1000000.0;
        }

        //Output the genereated input if the input size is less than or equal to 20
        if (inputSize <= 20) {
            //Output the generated input
            System.out.print("Numbers generated: ");
            for (int i = 0; i < inputSize; i++) {
                System.out.print(inputArray[i] + " ");

            }
            System.out.println();
            //Output the sorted output for quick sort
            System.out.print("Quick sort result: ");
            for (int i = 0; i < inputSize; i++) {
                System.out.print(copyForQuickSort[i] + " ");
            }
            System.out.println();

            //Output the sorted output for insertion sort if the user chose to run it
            if (insertionSortOption == 'y' || insertionSortOption == 'Y') {
                System.out.print("Insertion sort result: ");
                for (int i = 0; i < inputSize; i++) {
                    System.out.print(copyForInsertionSort[i] + " ");
                }
                System.out.println();
            }

            //Output the sorted output for quick sort with median of three if the user chose to run it
            if (medianOfThreeOption == 'y' || medianOfThreeOption == 'Y') {
                System.out.print("Quick sort (Median of Three) result: ");
                for (int i = 0; i < inputSize; i++) {
                    System.out.print(copyForMedianOfThree[i] + " ");
                }
                System.out.println();
            }
        }
        System.out.println();
        //Output the time taken for each sorting algorithm to complete and rank them
        System.out.println("==================== Execution Result ====================");
        System.out.println("Quick sort: " + durationQuickSort + " milliseconds");

        if (insertionSortOption == 'y' || insertionSortOption == 'Y') {
            System.out.println("Insertion sort: " + durationInsertionSort + " milliseconds");
        }

        if (medianOfThreeOption == 'y' || medianOfThreeOption == 'Y') {
            System.out.println("Quick sort (Median of Three): " + durationMedianOfThree + " milliseconds");
        }

        //Ranking the algorithms based on their execution time
        System.out.println("==================== Ranking =============================");
        ArrayList<String> algorithmNames = new ArrayList<>();
        ArrayList<Double> algorithmDurations = new ArrayList<>();

        //add names and time based on user options
        algorithmNames.add("Quick sort");
        algorithmDurations.add(durationQuickSort);
        if (insertionSortOption == 'y' || insertionSortOption == 'Y') {
            algorithmNames.add("Insertion sort");
            algorithmDurations.add(durationInsertionSort);
        }
        
        if (medianOfThreeOption == 'y' || medianOfThreeOption == 'Y') {
            algorithmNames.add("Quick sort (Median of Three)");
            algorithmDurations.add(durationMedianOfThree);
        }

        //Sort the algorithms based on execution times
        for (int i = 0; i < algorithmDurations.size() - 1; i++) {
            for (int j = 0; j < algorithmDurations.size() - i - 1; j++) {
                if (algorithmDurations.get(j) > algorithmDurations.get(j + 1)) {
                    //Swap durations
                    double tempDuration = algorithmDurations.get(j);
                    algorithmDurations.set(j, algorithmDurations.get(j + 1));
                    algorithmDurations.set(j + 1, tempDuration);
                    //Swap names
                    String tempName = algorithmNames.get(j);
                    algorithmNames.set(j, algorithmNames.get(j + 1));
                    algorithmNames.set(j + 1, tempName);
                }
            }
        }
        //Print the ranking
        for (int i = 0; i < algorithmNames.size(); i++) {
            System.out.println("(" + (i + 1) + ") " + algorithmNames.get(i));
        }
        System.out.println("==========================================================");
    }
}

