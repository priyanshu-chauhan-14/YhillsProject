/*
    Date: 22 June 2025
    This is the main file where the program starts running. It acts like the control room — taking user input, offering menu choices, and sending commands to the Elevator class.
 */

import java.util.*;

public class ElevatorSystem {
    public static void main(String[] args) {
        Elevator elevator = new Elevator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Yhills Elevator System Started =====");

        while (true) {
            System.out.println("\n1. Request from Inside Elevator");
            System.out.println("2. Request from a Floor (Up/Down)");
            System.out.println("3. Start Elevator");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 : {
                    System.out.print("Enter floor number (0 to 10): ");
                    int floor = scanner.nextInt();
                    elevator.requestFloor(floor);
                }
                case 2 : {
                    System.out.print("Enter floor number (0 to 10): ");
                    int floor = scanner.nextInt();
                    System.out.print("Direction (UP/DOWN): ");
                    String dir = scanner.next();
                    elevator.requestFromFloor(floor, dir);
                }
                case 3 : elevator.startElevator();
                case 4 : {
                    System.out.println("Exiting system. Goodbye!");
                    System.exit(0);
                }
                default : System.out.println("Invalid choice!");
            }
            scanner.close();
        }
    }
}

