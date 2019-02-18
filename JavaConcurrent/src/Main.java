import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 Ping N web sites in parallel.
 The ping simply does a GET, and looks at the first header line.
 This example could be applied to many sorts of similar tasks.
 <P>No time-out is used here. As usual, be wary of warm-up 
 of the just-in-time compiler. You might want to use -Xint.
 */
public final class Main {
    private static final Integer[] SLEEPING_TIME = new Integer[]{10000,1000,20000,1000};
    /** Run this tool. */
    public static final void main(String... args) {
        Main checker = new Main();
        try {
//            log("Parallel, report each as it completes:");
            checker.pingAndReportEachWhenKnown();

//            log("Parallel, report all at end:");
//            checker.pingAndReportAllAtEnd();
//
//            log("Sequential, report each as it completes:");
//            checker.pingAndReportSequentially();
        }

        catch(Exception ex){
            log("Bad URL: " + ex.getCause());
        }
        log("Done.");
    }


    void pingAndReportEachWhenKnown()  throws InterruptedException, ExecutionException  {
        int numThreads = 4; //max 4 threads
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        CompletionService<PingResult> compService = new ExecutorCompletionService<>(executor);
        int x=1;
        for(Integer url : SLEEPING_TIME){
            Task task = new Task(x++,url);
            compService.submit(task);
        }

        for(Integer url : SLEEPING_TIME){
            Future<PingResult> future = compService.take();
            log(future. get());
        }

        executor.shutdown(); //always reclaim resources
    }


    void pingAndReportAllAtEnd() throws InterruptedException, ExecutionException {
        int numThreads = 40; //max 4 threads
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        Collection<Callable<PingResult>> tasks = new ArrayList<>();
        int x=1;
        for(Integer url : SLEEPING_TIME){
            tasks.add(new Task(x++ ,url));
        }

        List<Future<PingResult>> results = executor.invokeAll(tasks);

        for(Future<PingResult> result : results){
            PingResult pingResult = result.get();
            log(pingResult);
        }

        executor.shutdown(); //always reclaim resources
    }

    private static void log(Object msg){
        System.out.println(Objects.toString(msg));
    }

    private final class Task implements Callable<PingResult> {
        Task(Integer ORDER,Integer TIMING){
            this.ORDER = ORDER;
            this.TIMING = TIMING;
        }

        @Override public PingResult call() throws Exception {
            return pingAndReportStatus(ORDER,TIMING);
        }
        private final Integer ORDER;
        private final Integer TIMING;
    }

    private PingResult pingAndReportStatus(Integer ORDER,Integer TIMING) throws   InterruptedException {
        PingResult result = new PingResult();
        result.ORDER = ORDER;
        result.TIMING = TIMING;
            System.out.println(">>"+ORDER);
            Thread.sleep(TIMING);
            System.out.println(">>>>>>"+ORDER);
        return result;
    }

    private static final class PingResult {
        Integer ORDER;
        Integer TIMING;
        @Override public String toString(){
            return "Result: Order" + ORDER + " sleep=" + TIMING  ;
        }
    }
} 