package HomeWorks.lesson21.service;

import java.util.concurrent.Callable;


public class Counter {
    private static Integer count = 1;

    public static Integer getCount (){
        try {
            Thread.sleep(0); // 1 for synchronisation
        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
            System.out.println("Thread - \"" + Thread.currentThread().getName() + "\". Executing interrupted .");
        }
        System.out.println("Thread - \"" + Thread.currentThread().getName() + "\", count = " + count++) ;
        return count;
    }
}
