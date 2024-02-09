import java.util.Scanner;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minimumRange = 1;
        int maximumRange = 100;
        int No_of_attempts = 0;
        int Totalscore = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) { //while true
            int randomNumber = random.nextInt(maximumRange - minimumRange + 1) + minimumRange;
            System.out.println("I have generated a number between the range" + minimumRange + " and " + maximumRange + ". Guess it!");
            int userguess;
            boolean correctAns = false;

            while (!correctAns) {
                System.out.print("Enter your guess: ");
                userguess = scanner.nextInt();
                No_of_attempts++;

                if (userguess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + No_of_attempts + " attempts.");
                    Totalscore++;
                    correctAns = true;
                } else if (userguess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String UserResponse = scanner.next().toLowerCase();
            if (!UserResponse.equals("yes")) {
                playAgain = false;
            }
            No_of_attempts = 0;
        }

        System.out.println("Thanks for playing! Your total score is:"+ Totalscore);
        scanner.close();
    }
}
