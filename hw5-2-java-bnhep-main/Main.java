/*
 * INSTRUCTION:
 *     This is a Java staring code for hw5_2.
 *     When you finish the development, download this file and and submit to Canvas
 *     according to the submission instructions.

 *     Please DO NOT change the name of the main class "Main"
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Title: Linear Probing Hash Table
 * Abstract: This program implements a linear probing hash table and utilizes operations to 
 * insert, search, check table size, and check table status. The program starts by reading in user input,
 * the first integer is the hash table size, the second integer is the number of operations, and the next lines are the
 * actual operations. The program does the operations accordingly and outputs the results. Notable operations are 
 * insert followed by an integer(key), display status followed by an index, tablesize to display the current
 * size of the table, and search for searching a key in the table. The hash table uses linear probing to handle collisions, and
 * monitors a load factor of 0.5 after a new insert to check if rehashing is needed. After inserting a new key,
 * check the load factor and if its more than 0.5, rehash by creating a new hash table the size of the first prime number after doubling 
 * the current table size and reinsert all existing keys into the new table.
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
    static int hashTableSize;
    static int numOperations;
    static ArrayList<ArrayList<String>> operations;
    static int[] hashTable;
    static int numKeys = 0;

    /*
    * Handle inserting a key into the hash table
    * Checks the load factor AFTER inserting a new key
    * If the load factor exceeds 0.5, rehashing is conducted by creating a 
    * new hash table the size of the first prime number after doubling the current table size 
    * and reinserting all existing keys
    * @param key the key to be inserted into the hash table
    */
    public static void insert(int key) {
        int index = key % hashTableSize;
        while (hashTable[index] != -1) {
            index = (index + 1) % hashTableSize;
        }
        hashTable[index] = key;
        numKeys++;
        
        //Check Load factor to rehash
        if ((double) numKeys / hashTableSize > 0.5) {
            rehash();
        }
    }

    /*
    * Rehash the hash table by creating a 
    * new hash table to be the size of the first prime number after doubling the current table size 
    * and reinserting all existing keys into the new table
    */
    public static void rehash() {
        //Find new size and create new hash table
        int newSize = findFirstPrime(hashTableSize * 2);
        int[] newHashTable = new int[newSize];
        Arrays.fill(newHashTable, -1);

        for (int i = 0; i < hashTableSize; i++) {
            if (hashTable[i] != -1) {
                int key = hashTable[i];
                int index = key % newSize;
                while (newHashTable[index] != -1) {
                    index = (index + 1) % newSize;
                }
                newHashTable[index] = key;
            }
        }
        hashTable = newHashTable;
        hashTableSize = newSize;
    }

    /*
    * Display the status of an entry of the table at a given index
    * If the entry is empty, return "Empty", otherwise return the key at that entry
    * @param index the index to check the status of
    * @return the status of the entry at the given index: "Empty" if the entry is empty,
    */
    public static String displayStatus(int index) {
        if (hashTable[index] == -1) {
            return "Empty";
        } else {
            return Integer.toString(hashTable[index]);
        }
    }

    /*
    * Search for a key in the hash table and return true if found, false otherwise
    * @param key the key to search for
    * @return true if the key is found, false otherwise
    */
    public static boolean search(int key) {
        int index = key % hashTableSize;

        while (hashTable[index] != -1) {
            if (hashTable[index] == key) {
                return true;
            }
            index = (index + 1) % hashTableSize;
        }
        return false;
    }
    
    /*
    * Check if a number is prime
    * @param n the number to check
    * @return true if n is prime, false otherwise
    */
    public static boolean checkPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /*
    * Find the first prime number after doubling the current table size
    * @param n the starting number
    * @return the first prime number >= n
    */
    public static int findFirstPrime(int n) {
        while (!checkPrime(n)) {
            n++;
        }
        return n;
    }

    public static void main(String[] args) {

        //Creating a scanner object to take in input
        Scanner userInput = new Scanner(System.in);

        //Input for Hash table size and number of operations
        hashTableSize = userInput.nextInt();
        numOperations = userInput.nextInt();

        //Initialize hash table with -1 for empty values
        hashTable = new int[hashTableSize];
        Arrays.fill(hashTable, -1);

        //Parse the operations and store them in a list of lists
        //[["insert", "5"], ["displayStatus", "3"], ["search", "10"], ["tableSize"]]
        operations = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < numOperations; i++) {
            ArrayList<String> operation = new ArrayList<String>();
            String operationType = userInput.next();
            operation.add(operationType);

            if (operationType.equals("insert")) {
                int insertValue = userInput.nextInt();
                operation.add(Integer.toString(insertValue));
            } else if (operationType.equals("displayStatus")) {
                int index = userInput.nextInt();
                operation.add(Integer.toString(index));
            } else if (operationType.equals("search")) {
                int searchKey = userInput.nextInt();
                operation.add(Integer.toString(searchKey));
            } else if (operationType.equals("tableSize")) {
            }
            operations.add(operation);
        }
        userInput.close();

        // //Checking if operations are stored correctly
        // System.out.println("Stored operations:");
        // for (int i = 0; i < operations.size(); i++) {
        //     System.out.println(operations.get(i));
        // }
        // System.out.println();

        //Process operations by going through the list of lists.
        //[["insert", "5"], ["displayStatus", "3"], ["search", "10"], ["tableSize"]]
        for (int i = 0; i < operations.size(); i++) {
            ArrayList<String> op = operations.get(i);
            String operationType = op.get(0);
            
            if (operationType.equals("insert")) {
                int key = Integer.parseInt(op.get(1));
                //insert key and check load factor for rehashing
                insert(key);
            } else if (operationType.equals("displayStatus")) {
                int index = Integer.parseInt(op.get(1));
                //Output the status of the entry at the given index
                System.out.println(displayStatus(index));
            } else if (operationType.equals("tableSize")) {
                //Output the current size of the hash table
                System.out.println(hashTableSize);
            } else if (operationType.equals("search")) {
                int key = Integer.parseInt(op.get(1));
                //Output the key and whether it was found in the table
                boolean found = search(key);
                System.out.print(key + " ");
                if (found) {
                    System.out.println("Found");
                } else {                    
                    System.out.println("Not found");
                }
            }
        }
    }
}
