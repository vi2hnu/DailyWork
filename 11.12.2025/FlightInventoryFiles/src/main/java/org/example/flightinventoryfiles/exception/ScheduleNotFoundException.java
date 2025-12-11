package org.example.flightinventoryfiles.exception;

public class ScheduleNotFoundException extends RuntimeException{
    public ScheduleNotFoundException(String message) {
        super(message);
    }
}
