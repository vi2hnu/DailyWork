package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

public class Main {

    private static final Queue<Order> orderQueue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Program started at: " + now.format(formatter));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> div = numbers.stream().filter(number -> number % 2 == 0).toList();
        System.out.println("Even numbers: " + div);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 10; i++) {
            orderQueue.add(new Order(i, Math.random() * 1000));
        }

        for (int i = 0; i < 3; i++) {
            executor.submit(() -> {
                while (!orderQueue.isEmpty()) {
                    Order order = orderQueue.poll();
                    if (order != null) processOrder(order);
                }
            });
        }

        executor.shutdown();
    }

    private static void processOrder(Order order) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(Thread.currentThread().getName() + " processed Order " 
                           + order.getId() + " Amount: " + order.getAmount() 
                           + " at " + now.format(formatter));
        try { Thread.sleep(100); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
