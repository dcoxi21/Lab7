package edu.cscc;
import java.util.*;
/**
 * @author Dan Cox
 * RPSLSpock game
 * <p>Program prompts user to play RPSLSpock and enter a selection. Once<br>
 * the user make their selection, the computer's selection is randomly generated<br>
 * from generatePick() method. Determines the winner or a tie and asks user to play again.<br>
 * Loop continues until exit code entered by user.</p>
 *
 */
public class Main {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        /**
         * User's selection
         */
        String h_pick;
        /**
         * Computer's selection
         */
        String c_pick;
        /**
         * User's choice to play again
         */
        String answer;
        /**
         * Ensures User's input is a valid option
         */
        boolean isValid;

        do {
            System.out.println("Let's play rock, paper, scissors, lizard, spock");
            do {
                /**
                 * Prompt for user's input
                 * @param h_pick user's input
                 *
                 */
                System.out.print("Enter your choice: ");
                h_pick = input.nextLine();
                isValid = RPSLSpock.isValidPick(h_pick);
                if (!isValid) {
                    System.out.println(h_pick + " is not a valid choice");
                }
            } while (!isValid);
            /**
             * Computer randomly generates choice.
             * @param c_pick computer's choice
             */
            c_pick = RPSLSpock.generatePick();
            System.out.print("Computer picked " + c_pick + "  ");
            /**
             * Determines winner.
             */
            if (c_pick.equalsIgnoreCase(h_pick)) {
                System.out.println("Tie!");
            } else if (RPSLSpock.isComputerWin(c_pick, h_pick)) {
                System.out.println("Computer wins!");
            } else {
                System.out.println("You win!");
            }
            /**
             * Prompts to play again.
             */
            System.out.print("Play again ('y' or 'n'): ");
            answer = input.nextLine();
        } while ("Y".equalsIgnoreCase(answer));
        System.out.println("Live long and prosper!");
    }
}