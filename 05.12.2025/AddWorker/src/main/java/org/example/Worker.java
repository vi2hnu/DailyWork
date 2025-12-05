package org.example;

public class Worker implements Runnable{

    void add(int a,int b){
        System.out.print(a+b);
    }

    @Override
    public void run() {
        add(1,2);
    }
}
