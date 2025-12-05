package org.example;

public class Main {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread thread = new Thread(worker);
        thread.start();
    }
}