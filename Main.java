/*
The Project For Today is a NumberGuessingGame your groupd of 3 the rul
is as follows:
Computer proposes a number from 1 to 1000.
Human player tries to guess it. One enters a guess and computer tells if the number matches or it is smaller/greater than the proposed one.
Game continues, until player guesses the number.
Ways to Expand: Can add number of lives or any other additions you want. Be
*/
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        int lives = 0;
        int guess = 0;
        int winningNum = (int)((Math.random() + 0.001)*1000);
        String difficulty = "";
        boolean isError = true;
        
        System.out.println();
        System.out.print("Welcome to the Number Guessing Game! \n Please choose a difficulty(easy, medium, hard): ");
        difficulty = scanner.nextLine();
        lives = setLives(difficulty);
        System.out.println("You have " + lives + " lives");
        
        
        while(lives > 0 && winningNum != guess) {
            System.out.println("Guess a number: ");
            while(isError) {
                try {
                    guess = scanner.nextInt();
                    isError = false;
                } catch(Exception e) {
                    System.out.print("You typed an illegal character, please try again: ");
                }
                scanner.nextLine();
            }
            isError = true;
            lives--;
            
            checkGuess(guess, winningNum, lives);
            System.out.println("You have " + lives + " lives left");
        }
        if (lives == 0 && winningNum != guess){
            System.out.println("Game over, you lost. Try again next time!");
            System.out.println("The winning number is " + winningNum);
        }
    }
  

    static int setLives(String difficulty) {
        difficulty = difficulty.toLowerCase();
        switch (difficulty) {
            case "easy":
                return 20;
            case "medium":
                return 10;
            case "hard":
                return 7;
            default:
            System.out.println("Invalid choice, You've been set to the easiest difficulty by default");
                return 30;
        }
    }
    static boolean checkGuess(int guess, int winningNum, int lives){
      if (winningNum==guess){
          System.out.println("Congrats you won!");
          return true;
      }
      else if (winningNum<guess){
          System.out.println("The answer is lower.");
          System.out.println();
          return false;
      }
      else {
          System.out.println("The answer is higher.");
          System.out.println();
          
          return false;
      }

    }
}