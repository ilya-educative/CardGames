package com.blocker.cardgames.roundmaster.tes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RoundMaster {
    public static void main(String[] args) {
        System.out.println("Creating players");
        
        int playerCount = 3;
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            players.add(new Player());
        }

        int rounds = 3;

        ExecutorService executorService = Executors.newFixedThreadPool(playerCount);
        try {
            for (int i = 0; i < rounds; i++) {
                System.out.println("Round " + (i + 1));

                CountDownLatch latch = new CountDownLatch(playerCount);
                for (Player player : players) {
                    player.setLatch(latch);
                    executorService.execute(player);
                }

                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("All players have done their actions.");
            }

        } finally {
            System.out.println("Done");
            executorService.shutdown();
        }
    }
}
class Player implements Runnable {
    private State state = State.InProgress;
    private CountDownLatch latch;

    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        Random random = new Random();
        long decisionMakingTime = random.nextLong(1000L, 5000L);
        try {
            Thread.sleep(decisionMakingTime);
            state = State.Completed;
            System.out.println(Thread.currentThread().getName() + " completed his action in " + decisionMakingTime);
            latch.countDown();
        } catch (InterruptedException e) {
            state = State.Completed;
            throw new RuntimeException(e);
        }
    }

    enum State {
        InProgress, Completed
    }
}
