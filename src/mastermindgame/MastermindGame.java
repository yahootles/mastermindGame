/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermindgame;

/**
 *
 * @author antho6229
 */
import java.util.Scanner;

public class MastermindGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create scanner
        Scanner kinput = new Scanner(System.in);

        //declare variables
        int[] solution;
        int[] guess;
        int lengthOfSolution = 0, numberOfOptions = 0;

        System.out.println("Welcome to Mastermind!");
        lengthOfSolution = getLengthOfSolution(kinput);
        numberOfOptions = getNumberOfOptions(kinput);

        solution = generateSolution(lengthOfSolution, numberOfOptions);
        System.out.println("A sequence has been generated. It is " + lengthOfSolution + " numbers long, and each number can be 1-" + numberOfOptions + ".");

    }

    /**
     * Returns an integer between 3 and 10 inclusive that the user inputs upon a
     * prompt
     *
     * @param scan
     * @return
     */
    public static int getLengthOfSolution(Scanner scan) {
        int length = 0;
        boolean isValidInput = false;

        do {
            System.out.println("Enter the length of the combination(integer between 3 and 10 inclusive):");
            try {
                length = Integer.parseInt(scan.nextLine());
                if (length < 3 || length > 10) {
                    throw new Exception("");
                }
                isValidInput = true;
            } catch (Exception e) {
                System.out.println("That is not a valid input.");
                isValidInput = false;
            }
        } while (!isValidInput);

        return length;

    }

    /**
     * Returns an integer between 3 and 8 inclusive that the user inputs upon a
     * prompt
     *
     * @param scan
     * @return
     */
    public static int getNumberOfOptions(Scanner scan) {
        int length = 0;
        boolean isValidInput = false;

        do {
            System.out.println("Enter the number of pin options(integer between 3 and 8 inclusive):");
            try {
                length = Integer.parseInt(scan.nextLine());
                if (length < 3 || length > 8) {
                    throw new Exception("");
                }
                isValidInput = true;
            } catch (Exception e) {
                System.out.println("That is not a valid input.");
                isValidInput = false;
            }
        } while (!isValidInput);

        return length;

    }

    /**
     * Generates an array of random integers of a user specified length with the
     * integers being in a range the user specifies
     *
     * @param length
     * @param numOptions
     * @return
     */
    public static int[] generateSolution(int length, int numOptions) {
        int[] randSeq = new int[length];

        for (int i = 0; i < randSeq.length; i++) {
            randSeq[i] = (int) (Math.random() * numOptions + 1);
        }

        return randSeq;
    }

    public static int[] getGuess(Scanner scanner, int numGuesses, int maxValue) {
        boolean valid = false;
        String[] splitInput;
        String input;
        int[] finalGuess = new int[numGuesses];
        
        System.out.println("Enter your guess with spaces between the numbers(ex. 4 1 4 3 2:");

        do {
            try {
                input = scanner.nextLine();

                splitInput = input.split(" ");

                for (int i = 0; i < splitInput.length; i++) {
                    finalGuess[i] = Integer.parseInt(splitInput[i]);
                    if(finalGuess[i] < 1 || finalGuess[i] > maxValue){
                        throw new Exception();
                    }
                }
                
                valid = true;
                
            } catch (Exception e) {
                System.out.println("That is not a valid input. Please enter a valid guess:");
            }
        } while (valid != true);

        return finalGuess;
    }
    
    /**
     * Does a bubble sort on an array, then returns the array
     * @param array
     * @return 
     */
    public static int[] bubbleSort(int[] array){
         //declare local variables
        boolean sorted = false;
        int temp = 0;
        
        //loop that runs unil sorted
        while(sorted == false){
            sorted = true;
            for(int i = 0; i < array.length - 1; i++){
                //test to see if the smaller index contains a larger number
                if(array[i] > array[i+1]){
                    //switch places
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    sorted = false;
                }
            }
        }
        temp += 0;
        //returns the sorted array
        return array;
    }
}
