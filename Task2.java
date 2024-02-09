import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of subjects:");
        int Subjects = scanner.nextInt();

        int totalMarks = 0;

        System.out.println("Enter the marks obtained in each subject (out of 100):");
        for (int i = 0; i < Subjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            int marks = scanner.nextInt();
            totalMarks += marks;
        }

        double averagePercentage = (double) totalMarks / Subjects;

        char grade;
        if (averagePercentage >= 90)
        {
            grade = 'A';
        } else if (averagePercentage >= 80)
        {
            grade = 'B';
        } else if (averagePercentage >= 70)
        {
            grade = 'C';
        } else if (averagePercentage >= 60)
        {
            grade = 'D';
        } else if (averagePercentage >= 50)
        {
            grade = 'E';
        }
        else
        {
            grade = 'F';
        }

        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage);
        System.out.println("Your Grade: " + grade);

        scanner.close();
    }
}
