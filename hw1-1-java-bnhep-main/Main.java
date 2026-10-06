/*
 * INSTRUCTION:
 *     This is a Java staring code for hw1_1.
 *     When you finish the development, download this file and and submit to Canvas
 *     according to the submission instructions.
 * 
 *     Please DO NOT change the name of the main Class "Main"
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Title: hw1_1 Palindrome
 * Abstract: The program takes in a user input as a string and strips away all symbols leaving only 
 * a string of alphanumerical characters that are lowercased. It then checks the string to see if its a palindrome
 * by comparing the characters from the beginning and end of the string moving towards the center.
 * They are considered a palindrome if the characters match when compared from both ends.
 * If they are a not a palindrome output FALSE else if they are output TRUE. 
 * The program will use two functions one to strip the original string of its symbols
 * and returning a new string lowercased, and another to initiate the check on the modified string for the palindrome.
 * Utilizes helper methods from Character, Stringbuilder, and String classes.
 * Name: Brandon Nhep
 * Date: 01/13/2026
 */

import java.util.Scanner;

class Main 
{
    /*
    * Method to take in a user input string and recreate it by only using alphanumerical characters and ignoring symbols.
    * Utilizing the helper methods of Character, StringBuilder, and String class.
    * Takes in user input string, iterates through the string by each char and checks if they are a letter or digit, appends
    * a lowercased char to the stringbuilder if true, it then converts the stringbuilder into a string and returns the final string.
    * @param user input string
    * @returns the string with stripped symbols and lowercase to compare
    */
    public static String stripSymbols(String s) {

        //Creating a new stringbuilder to avoid appending to the original string
        //since strings are immutable in java
        StringBuilder strippedInput = new StringBuilder();

        //Iterating through initial string by each char
        //and checking if they are a letter or digit, if so append to the new
        //stringbuilder then converts to string, lowercase the char in new string
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                strippedInput.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        s = strippedInput.toString();
        //System.out.println("Stripping Symbols: " + s.toLowerCase());
        return s;
    }

    /*
    * Main logic method to check if the stripped string is a palindrome.
    * Takes in the stripped string from the previous method and uses two indexes
    * one that starts from index 0 and another that starts at the end using length of string minus 1.
    * loops through the string checking the characters of both indexes, if they are not the same return false
    * Else increase the first index and decrease the last index until they meet. If they meet then it's a palindrome
    * Returns a string of TRUE or FALSE.
    * @param final input string that was stripped of symbols
    * @returns string TRUE or FALSE
    */
    public static String checkPalindrome(String s) {

        //creates the indexes to check first and last letters
        int first = 0;
        int last = s.length() - 1;

        //for loop to check if the letters are a match
        //loops until meeting at the center of the string
        //return false if not the same
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(last)) {
                return "FALSE";
            }
            last--;
        }
        return "TRUE";
    }
    
    public static void main(String[] args) {

        //Creating a scanner object to take in input
        Scanner userInput = new Scanner(System.in);

        //Takes in user input as nextLine
        String input = userInput.nextLine();

        //receive the newly created string as lowercase and stripped of symbols
        String finalString = stripSymbols(input);
        
        //call method to check if palindrome
        finalString = checkPalindrome(finalString);

        //output the results of the palindrome check
        System.out.println(finalString);

        //close the scanner just in case
        userInput.close();
    }
}

