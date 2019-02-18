import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Driver {
    public static void main(String[] args) throws Exception {
        List<Thread> threads = new ArrayList<Thread>();
        Thread thread2=new Thread();
        thread2.start();
        // We will create 500 threads
        for (int i = 0; i < 1; i++) {
            Runnable task = () -> {
                while(true){
                    try {
                        Thread.sleep(6000);
                        return;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            Thread worker = new Thread(task);
            // We can set the name of the thread
            worker.setName(String.valueOf(i));
            // Start the thread, never call method run() direct
            worker.start();
            // Remember the thread for later usage
            threads.add(worker);
        }
        int running = 0;
        do {
            running = 0;
            for (Thread thread : threads) {
                System.out.println(thread.getState());
            }

        } while (true);

    }
}
