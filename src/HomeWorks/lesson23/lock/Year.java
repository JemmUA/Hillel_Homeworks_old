package HomeWorks.lesson23.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Year {
    Lock lock = new ReentrantLock();

    public void winter (int delay) throws InterruptedException {
        lock.lock();
        System.out.print("\b"+(char)862);
        Thread.sleep(delay);
    }

    public void spring (int delay) throws InterruptedException {
        System.out.print("\b"+"\\");
        Thread.sleep(delay);
    }

    public void summer (int delay) throws InterruptedException {
        System.out.print("\b"+"|");
        Thread.sleep(delay);
    }

    public void autumn (int delay) throws InterruptedException {
        System.out.print("\b"+"/");
        Thread.sleep(delay);
        System.out.print("\b");
        lock.unlock();
    }

    public void gone(){
        System.out.println("One more year passed");

    }
}
