package p1;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

    public static void main(String[] args)
    {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= 10; i++) {
            int taskNumber = i;
            executor.submit(() ->
            {
                System.out.println("Task " + taskNumber + " is starting.");
                try
                {
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
                System.out.println("Task " + taskNumber + " is completed.");
            });
        }
        executor.shutdown();// Shutdown the executor
        try
        {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS))  // Wait for all tasks to finish
            {
                executor.shutdownNow();
            }
        }
        catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
