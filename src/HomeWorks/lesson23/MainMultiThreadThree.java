package HomeWorks.lesson23;

import HomeWorks.lesson22.deadLockHands.LeftHand;
import HomeWorks.lesson22.deadLockHands.RightHand;
import HomeWorks.lesson23.deadLockBallBouncing.Down;
import HomeWorks.lesson23.deadLockBallBouncing.Up;
import HomeWorks.lesson23.lock.Year;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class MainMultiThreadThree {
    // Lesson 23. MultiThread
    // Homework 19.

    private static AtomicInteger counterAtomic = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        // 1.
        System.out.println("Atomic counter ---");
        ExecutorService executorService =  Executors.newFixedThreadPool(2);
        executorService.execute(() -> {
            decrementAtomicCounter(counterAtomic);
            executorService.shutdown();
        });
        Thread.sleep(100);
        // Result of decreasing atomic variable without sleeping ahd synchronising is stable "-1000", but to avoid unexpected results
        // we stop main thread for a short time to let all child threads to finish their tasks,
        // and additionally synchronise threads in separate method (decrementAtomicCounter)
        System.out.println("Final result of decreasing Atomic Integer variable is: " + counterAtomic);

        // 2. Lock - Unlock
        lockPractice();
        Thread.sleep(7000);

        // 3. Deadlock
        // Jumping ball
        System.out.println("\nDeadlock?");
        Down down = new Down();
        Up up = new Up();
        up.setDown(down);
        down.setUp(up);

        Thread threadOne = new Thread(() -> System.out.println(up.moveDown(down)));
        Thread threadTwo = new Thread(() -> System.out.println(down.moveUp(up)));
        threadOne.start();
        threadTwo.start();

        System.out.println("... Deadlock with delay of one thread //");

    }

    public static synchronized AtomicInteger decrementAtomicCounter (AtomicInteger counterAtomic) {
        for (int i = 0; i < 10000; i++) {
            Thread thread = new Thread(() -> {
            });
            System.out.println("Atomic counter decreased by 1: " + counterAtomic.decrementAndGet());
        }
     return counterAtomic;
    }

    public static void lockPractice() throws InterruptedException {
        Year year = new Year();
        int delay = 500;
        Thread threadFirst = new Thread(new Runnable() {
            @Override
            public void run () {
                try {
                    year.winter(delay);
                    year.spring(delay);
                    year.summer(delay);
                    year.autumn(delay);
                    year.gone();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }});
        Thread threadSecond = new Thread(new Runnable() {
            @Override
            public void run () {
                try {
                    year.winter(delay);
                    year.spring(delay);
                    year.summer(delay);
                    year.autumn(delay);
                    year.gone();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }});
        Thread threadThird = new Thread(new Runnable() {
            @Override
            public void run () {
                try {
                    year.winter(delay);
                    year.spring(delay);
                    year.summer(delay);
                    year.autumn(delay);
                    year.gone();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }});

        threadFirst.start();
        threadSecond.start();
        threadThird.start();
    }

}
