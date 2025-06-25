/*
    Date: 22 June 2025
    This file contains the ElevatorOperations interface which defines the basic actions an elevator should perform — like handling floor requests, processing direction buttons, and starting the elevator system.
 */
public interface ElevatorOperations {
    void requestFloor(int floor);
    void requestFromFloor(int floor, String direction);
    void startElevator();
}

