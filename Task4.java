import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Task4 {
    private static final int TotalQuestion = 5;
    private static final String[] Question = {
            "Which Indian city is known as the 'City of Dreams'?",
            "Who is known as the 'Father of the Indian Constitution'?",
            "Who was the first woman Prime Minister of India?",
            "Who wrote the Indian national anthem, 'Jana Gana Mana'",
            "Which Indian state is known as the 'Land of the Tigers'"
    };
    private static final String[][] option = {
            {"A. Mumbai", "B. Delhi", "C. Kolkata", "D. Bangalore"},
            {"A. Jawaharlal Nehru", "B. Sardar Vallabhbhai Patel", "C. Dr. B.R. Ambedkar", "D. Mahatma Gandhi"},
            {"A. Sonia Gandhi", "B. Indira Gandhi", "C. Pratibha Patil", "D. Mamata Banerjee"},
            {"A. Rabindranath Tagore", "B. Mahatma Gandhi", "C. Subhas Chandra Bose", "D. Jawaharlal Nehru"},
            {"A. Rajasthan", "B. Madhya Pradesh", "C. Kerala", "D. West Bengal"}
    };
    private static final char[] correctanswer = {'A', 'C', 'B', 'A', 'B'};
    private static int scoreobtained = 0;
    private static final Timer timer = new Timer();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Quiz Game!");
        for (int i = 0; i < TotalQuestion; i++) {
            System.out.println("Question no. " + (i + 1) + ": " + Question[i]);
            for (String option : option[i]) {
                System.out.println(option);
            }
            String userAnswer = "";
            TimerTask task = new TimerTask() {
                public void run() {

                    System.out.println("\nTime's up! Moving to the next question. press enter for next question");
                    System.out.println("Better Luck Next Time");
                    synchronized (scanner) {
                        scanner.notify();
                    }
                }
            };
            timer.schedule(task, 10000); // Timer set for 10 seconds (10000 milliseconds)
            System.out.print("Your answer (A/B/C/D) (under 10 sec): ");
            try {
                userAnswer = scanner.nextLine().toUpperCase();
                task.cancel(); // Cancel the timer if the user answers before time is up
            } catch (Exception e) {
                System.out.println("Error: Failed to read user's input.");
                break; // Stop the quiz if an error occurs
            }
            if (!userAnswer.isEmpty()) {
                char givenanswer = userAnswer.charAt(0);
                if (givenanswer == correctanswer[i]) {
                    System.out.println("Correct!");
                    scoreobtained++;
                } else {
                    System.out.println("Incorrect!");
                    System.out.println("Better Luck Next Time");
                }
            }
        }
        System.out.println("Your Total score: " + scoreobtained + "/" + TotalQuestion);
        scanner.close();
    }
}
