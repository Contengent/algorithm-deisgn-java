/**
 * @author 
 *
 *   /\_/\  _     ___
 *  |>'v'<||"| -/\, ,`>
 *     -=Edelstein=-
 * 
 */

package algorithmdesign.project;

import java.math.BigInteger;
import java.util.Scanner;

public class AlgorithmDesignProject {
    public static void main(String[] args) {
        // variables
        Scanner stringInput = new Scanner(System.in);
        int choice;
        int number = 0;
        
        // doWhile loop for menu
        do{
            // main menu
            System.out.println("What would you like to do?:");
            System.out.println("[1] calculate the factorial of a number ");
            System.out.println("[2] calculate if a number is prime");
            System.out.println("[3] calculate the fibbonachi of a number");
            System.out.println("[0] exit");
            choice = stringInput.nextInt();
            
            // filter for main menu && accepting input
            if (choice <= 3 && choice > 0){
                System.out.println("\nYou have selected " + choice + ". Please enter a number: ");
                number = stringInput.nextInt();
            }
            
            // switch filter for getting the desired calculator function
            switch (choice) {
                case 1:
                    factorialAndOut(number);
                    break;
                case 2:
                    primeAndOut(number);
                    break;
                case 3:
                    fibbonachiAndOut(number);
                    break;
                case 0:
                    System.out.println("exiting...");
                    System.exit(0);
                default:
                    System.out.println("Error: Invalid 'choice' input."); // error if result is not in range
                    break;
            }
            
        } while (true); // end of do while loop
        
    }
    
    
    
    private static void factorialAndOut(int input) {
        // This is some weird variable that can store really big numbers
        BigInteger fact = new BigInteger("1");
        
        // main loop
        for (int i = 1; i <= input; i++) {
            // I am actually not sure.
            // I think it might be multiplying bigint by i, then changing bigint to the result
            fact = fact.multiply(new BigInteger(i + ""));
        }
        
        System.out.println(fact);
    }
    
    
    
    private static void primeAndOut(int input) {
        // variables
        long num = input;
        boolean isPrime = true;
        
        // main loop; does the following while i < half of num
        /* Calculating past half is pointless since it will always be a decimal */
        for (int i = 2; i <= num / 2; ++i) {
            // checks if the remainder is == 0
            if (num % i == 0){
                // if remained can equal 0, then it's not a prime.
                isPrime = false;
                break;
            }
        }
        
        // outputting if or if not a prime

        if (isPrime){
            System.out.println(num + " is a prime number.\n");
        } else{
            System.out.println(num + " is not a prime number.\n");
        }
    }
    
    
    
    private static void fibbonachiAndOut(int input){
        // main array in function
        int [] numnum = {0,1,1};        
        
        // main loop in function
        for(int i = 0; i < input - 2; i++){
            // Main calculation
            numnum[2] = numnum[1] + numnum[0];
            
            // Re-setting variables, so calculation works
            numnum[0] = numnum[1];
            numnum[1] = numnum[2];
        }
        // output
        System.out.println("\nAt " + input + " the fibbonachi number is: " + numnum[2]);        
    }
}
