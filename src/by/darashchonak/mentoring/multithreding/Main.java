package by.darashchonak.mentoring.multithreding;

import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        SyncList list = new SyncList();
        Random rand = new Random();

        Runnable t1 = () -> {
            for (int j = 0;; j++){
                list.add(rand.nextInt(100));
            }
        };

        Runnable t2 = () -> {
            while (true) {
                System.out.println("Current sum: " +
                        list.getValues().stream().collect(Collectors.summingInt(Integer::intValue)));
            }
        };

        Runnable t3 = () -> {
            while(true){
                System.out.println("sqrt: " +
                        Math.sqrt(list.getValues()
                                .stream()
                                .map(value -> Math.sqrt(value))
                                .collect(Collectors.summingDouble(Double::doubleValue))));
            }
        };


        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();

    }
}
