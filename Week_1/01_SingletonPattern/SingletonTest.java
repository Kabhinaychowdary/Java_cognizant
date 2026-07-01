import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SingletonTest {
    public static void main(String[] args) throws InterruptedException {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("First log message.");
        logger2.log("Second log message.");

        if (logger1 == logger2) {
            System.out.println("Success: Both references point to the same Logger instance.");
        } else {
            System.out.println("Failure: Different Logger instances found.");
        }

        int threadCount = 10;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        Set<Integer> hashCodes = ConcurrentHashMap.newKeySet();

        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                Logger tempLogger = Logger.getInstance();
                hashCodes.add(System.identityHashCode(tempLogger));
                tempLogger.log("Log from thread: " + Thread.currentThread().getName());
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("Unique Logger instances found in multi-threaded test: " + hashCodes.size());
        if (hashCodes.size() == 1) {
            System.out.println("Success: Multi-threaded test verified Singleton pattern.");
        } else {
            System.out.println("Failure: Multi-threaded test generated multiple instances.");
        }
    }
}
