package HomeWorks.lesson22;

import HomeWorks.lesson22.deadLockHands.LeftHand;
import HomeWorks.lesson22.deadLockHands.RightHand;
import HomeWorks.lesson22.services.Synchronization;

public class MainMultiThreadTwo {

private static int downCount = 9;

    public static void main(String[] args) throws InterruptedException {
        // Synchronized static METHOD
        System.out.println("Synchronized method ---");
        System.out.println("Start down count... ");
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(MainMultiThreadTwo::synchroStaticMethod);
            thread.start();
        }
        Thread.sleep(100);
        System.out.println("Let's GO!\n");

        // Synchronization on OBJECT
        System.out.println("Synchronization on object ---");
        Synchronization synchroService = new Synchronization();
        Object objectSync = new Object();
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(() -> synchroService.syncroObject(objectSync));
            thread.start();
        }
        Thread.sleep(100);
        System.out.println("Count: " + synchroService.getCounter());

        // Synchronization part of the CODE
        System.out.println("\nSynchronization part of the CODE ---");
        Synchronization synchroServiceTwo = new Synchronization();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> synchroServiceTwo.synchroPart());
            thread.start();
        }
        Thread.sleep(100);


        //wait and notify
        System.out.println("\nwait and notify ---");
        waitNotify();

        //Deadlock - washing hands
        System.out.println("\nDeadlock... ---");
        RightHand rightHand = new RightHand();
        LeftHand leftHand = new LeftHand();
        rightHand.washLeftHand(leftHand);
        leftHand.washRightHand(rightHand);

        Thread threadOne = new Thread(() -> System.out.println(rightHand.washLeftHand(leftHand)));
        Thread threadTwo = new Thread(() -> System.out.println(leftHand.washRightHand(rightHand)));
        threadOne.start();
        threadTwo.start();

    }

    public static synchronized void synchroStaticMethod (){
        System.out.println(Thread.currentThread().getName() + " started");
        for (int i = 0; i < 3; i++) {
            System.out.println("< " + downCount-- + " >");
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }


    public static void waitNotify() throws InterruptedException {
        Object obejctLock = new Object();
        Thread thread = new Thread(() -> {
            synchronized (obejctLock) {
                System.out.println(Thread.currentThread().getName() + ": print alphabet");
                for (int i = 65; i < 91; i++) {
                    System.out.print((char)i + " ");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obejctLock.notify();
            }
        });
        thread.start();
        synchronized (obejctLock) {
            obejctLock.wait();
        }
        System.out.println("\nThread " + Thread.currentThread().getName() + ": Done!");
    }

}
