package HomeWorks.lesson21;

import HomeWorks.lesson21.thread.CallableThread;
import HomeWorks.lesson21.thread.CustomThread;
import HomeWorks.lesson21.thread.RunnableThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MainMultiThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        System.out.println(Thread.currentThread().getName());

        CustomThread threadCustom= new CustomThread();
        threadCustom.setName("Custom");
//        threadCustom.start();

        RunnableThread runnable = new RunnableThread();
        Thread threadRunnable = new Thread(runnable);
        threadRunnable.setName("Runnable");
//        threadRunnable.start();

        CallableThread callable = new CallableThread();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread threadCallable = new Thread(futureTask);
        threadCallable.setName("Callable");
//        threadCallable.start();
//        String resultCallable = futureTask.get();

        threadCustom.start();
//        threadCustom.join();
        threadRunnable.start();
//        threadRunnable.join();
        threadCallable.start();

        System.out.println(futureTask.get());
    }
}
// No mandatory tasks.
// 5. The value can be returned Callable only. CallableThread returns number of completed iterations. Each time it was 1000, but not every time it was latest.
// 5.1. After some restarts results ranged 2997-3000.
// 5.2. Using synchronisation (Thread.sleep(1);) after some restarts results ranged 2803-2910.
// 5.3. With using .join() for waiting executing of threads one by one - after all restarts results ranged 3000-3000.