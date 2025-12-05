package org.example;

public class Main{
    public static void main(String[] args) throws InterruptedException {
        Thread virtual = Thread.ofVirtual().name("Vrtual").start(
                ()->System.out.print("from virtual threads")
        );

        virtual.join();
    }
}