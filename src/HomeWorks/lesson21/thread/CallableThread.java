package HomeWorks.lesson21.thread;

import HomeWorks.lesson21.service.Counter;

import java.util.concurrent.Callable;

public class CallableThread implements Callable <String> {
    @Override
    public String call() {
        System.out.println("Callable thread: " + Thread.currentThread().getName());
        int i = 0;
        for (; i < 1000; i++) {
            Counter.getCount();
        }
        return "\nCallable threat. Iterations completed: " + i;
    }
}
