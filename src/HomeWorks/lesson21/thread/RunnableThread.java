package HomeWorks.lesson21.thread;

import HomeWorks.lesson21.service.Counter;

public class RunnableThread implements Runnable{
    @Override
    public void run() {
        System.out.println("Runnable thread: " + Thread.currentThread().getName());
        for (int i = 0; i < 1000; i++) {
            Counter.getCount();
        }
    }
}
