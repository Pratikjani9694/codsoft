import java.util.Random;
import java.util.Scanner;

public class GuessingGame
{
  public static void main(String[] args) 
  {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    int score = 0;
    int rounds = 0;

    while (true) 
    {
      int numberToGuess = random.nextInt(100) + 1;
      int attempts = 0;

      System.out.println("Welcome to the guessing game! I'm thinking of a number between 1 and 100.");
      System.out.println("You have 6 attempts to guess the number.");

      while (attempts < 6) 
      {
        System.out.print("Enter your guess: ");
        int guess = scanner.nextInt();
        attempts++;

        if (guess == numberToGuess) 
        {
          System.out.println(" Congratulations! You Won The Game. You guessed the number in " + attempts + " attempts.");
          score += 6 - attempts;
          rounds++;
          break;
        }
        else if (guess < numberToGuess) 
        {
          System.out.println("Too low! Try again.");
        } 
        else 
        {
          System.out.println("Too high! Try again.");
        }
      }

      if (attempts == 6) 
      {
        System.out.println("Sorry, you didn't guess the number. The correct answer was " + numberToGuess + ".");
      }

      System.out.print("Do you want to play again? (y/n): ");
      String response = scanner.next();

      if (response.equalsIgnoreCase("n")) 
      {
        break;
      }
    }

    System.out.println("Your final score is " + score + " in " + rounds + " rounds.");
  }
}
