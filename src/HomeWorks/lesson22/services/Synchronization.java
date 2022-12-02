package HomeWorks.lesson22.services;

public class Synchronization {
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void syncroObject(final Object object) {
        synchronized (object) {
            for (int i = 0; i < 4; i++) {
                System.out.println("Synchro on object: " + Thread.currentThread().getName() + " Counter: " + counter++);
            }
        }
    }

    public void synchroPart() {
        for (int i = 0; i < 3; i++) {
            System.out.println("NOT synchronized: " + Thread.currentThread().getName());
        }
        synchronized (this) {
            for (int i = 0; i < 3; i++) {
                System.out.println("Synchronized : " + Thread.currentThread().getName());
            }
        }
    }

}
