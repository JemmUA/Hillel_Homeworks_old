package HomeWorks.lesson21.thread;

import HomeWorks.lesson21.service.Counter;

public class CustomThread extends Thread{
    @Override
    public void run() {
        System.out.println("Custom thread: " + Thread.currentThread().getName());
        for (int i = 0; i < 1000; i++) {
            Counter.getCount();
        }
    }
}
