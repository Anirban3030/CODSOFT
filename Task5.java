import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        int[] courseCodes = {1, 2, 3, 4};
        String[] courses = {"Full Stack Web Development", "Android Development", "Python for AI", "Game Development"};
        int[] capacities = {30, 20, 60, 15};
        String[] descriptions = {"html, css, js", "kotlin, flutter", "numpy, pandas, data science", "unity"};
        String[] schedules = {"Monday", "Wednesday", "Thursday", "Saturday"};
        String[] timing = {"9:00-1:00", "3:00-7:00", "9:00-1:00", "3:00-7:00"};

        // Display courses
        System.out.println("COURSES OFFERED:");
        for (int i = 0; i < 4; i++) {
            System.out.println("Course Code: " + courseCodes[i]);
            System.out.println("Name: " + courses[i]);
            System.out.println("Capacity: " + capacities[i]);
            System.out.println("Description: " + descriptions[i]);
            System.out.println("Schedule: " + schedules[i]);
            System.out.println("Timing: " + timing[i]);
            System.out.println("---------------------------------------------");
        }

        Scanner scanner = new Scanner(System.in);
        String choice;
        Register register = new Register();
        System.out.println("\n\nSTUDENT GATEWAY: ");
        do {
            System.out.println("\n1. Register course\n2. Drop course\n3. Exit");
            System.out.print("Enter option: ");
            choice = scanner.next();
            System.out.println("\n");
            switch (choice) {
                case "1":
                    register.registerCourses(courses, scanner);
                    break;
                case "2":
                    register.dropCourses(courses, scanner);
                    break;
                case "3":
                    System.out.println("THANK YOU!");
                    System.exit(0);
                default:
                    System.out.println("Enter a valid option");
            }
            System.out.println("Do you want to register/drop more courses?\n['y' for Yes / 'n' for No]");
            choice = scanner.next();
        } while (!choice.equalsIgnoreCase("n"));
    }
}

class Register {
    boolean[] registeredCourses = new boolean[4]; // Array to keep track of registered courses

    // Registration
    void registerCourses(String[] courses, Scanner scanner) {
        System.out.println("------------------- REGISTRATION ----------------");
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter course code to register: ");
        int reg = scanner.nextInt();
        if (reg >= 1 && reg <= courses.length) {
            registeredCourses[reg - 1] = true; // Mark the course as registered
            System.out.println("Registered Course " + courses[reg - 1] + " successfully\n");
        } else {
            System.out.println("Invalid course code. Please enter a valid course code.\n");
        }
    }

    // Drop courses
    void dropCourses(String[] courses, Scanner scanner) {
        System.out.println("------------------- DROP COURSES ----------------");
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter course code to drop: ");
        int reg = scanner.nextInt();

        // Check if the user is registered for the course they want to drop
        if (reg >= 1 && reg <= courses.length) {
            if (registeredCourses[reg - 1]) {
                registeredCourses[reg - 1] = false; // Mark the course as dropped
                System.out.println("Dropped Course " + courses[reg - 1] + " successfully\n");
            } else {
                System.out.println("You are not registered for this course.\n");
            }
        } else {
            System.out.println("Invalid course code. Please enter a valid course code.\n");
        }
    }
}
