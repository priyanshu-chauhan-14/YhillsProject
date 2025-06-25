/*
    Date: 22 June 2025
    This file contains the actual Elevator class which handles all the internal logic for moving between floors, storing and processing requests, and pausing when it stops.
    Enter the two different floor numbers and it will drop you one by one 
 */
import java.util.*;

public class Elevator implements ElevatorOperations {
    private int currentFloor = 0;
    private String direction = "UP";
    private final int MAX_FLOOR = 10;
    private final int MIN_FLOOR = 0;

    private Set<Integer> requestsUp = new TreeSet<>();
    private Set<Integer> requestsDown = new TreeSet<>(Collections.reverseOrder());

    private boolean running = true;

    @Override
    public void requestFloor(int floor) {
        if (floor < MIN_FLOOR || floor > MAX_FLOOR) return;

        if (floor > currentFloor) {
            requestsUp.add(floor);
        } else if (floor < currentFloor) {
            requestsDown.add(floor);
        }
    }

    @Override
    public void requestFromFloor(int floor, String dir) {
        if (floor < MIN_FLOOR || floor > MAX_FLOOR) return;

        if ("UP".equalsIgnoreCase(dir)) {
            requestsUp.add(floor);
        } else {
            requestsDown.add(floor);
        }
    }

    @Override
    public void startElevator() {
        while (running) {
            if ("UP".equals(direction)) {
                processRequests(requestsUp, "UP");
                direction = "DOWN";
            } else {
                processRequests(requestsDown, "DOWN");
                direction = "UP";
            }

            if (requestsUp.isEmpty() && requestsDown.isEmpty()) {
                System.out.println("No more requests. Elevator is idle.");
                break;
            }
        }
    }

    private void processRequests(Set<Integer> requests, String dir) {
        Iterator<Integer> it = new ArrayList<>(requests).iterator();
        while (it.hasNext()) {
            int targetFloor = it.next();
            moveToFloor(targetFloor);
            requests.remove(targetFloor);
        }
    }

    private void moveToFloor(int targetFloor) {
        while (currentFloor != targetFloor) {
            if (currentFloor < targetFloor) currentFloor++;
            else currentFloor--;

            System.out.println("Moving... Current Floor: " + currentFloor);
            sleep(1000); 
        }

        System.out.println("Stopped at Floor: " + currentFloor + " (Pausing 2 seconds)");
        sleep(2000); // 2 second pause 
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.println("Error during sleep: " + e.getMessage());
        }
    }
}
