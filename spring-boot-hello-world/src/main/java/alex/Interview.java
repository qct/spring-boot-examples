package alex;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * <p>Created by quchentao on 2018/3/20.
 */
public class Interview {

    private static Map<String, Long> calc(int[] input, int numOfThread) {
        long start = System.currentTimeMillis();
        ExecutorService executorService = new ThreadPoolExecutor(numOfThread, numOfThread, 60L, TimeUnit.SECONDS,
            new SynchronousQueue<>());
        int unit = input.length / numOfThread;
        AtomicLong finalResult = new AtomicLong(0L);
        for (int i = 0; i < numOfThread; i++) {
            int finalI = i;
            executorService.execute(() -> {
                long result = 0L;
                for (int j = finalI * unit; j < (finalI + 1) * unit ; j++) {
                    result += input[j];
                }
                finalResult.addAndGet(result);
            });
        }

        long end = System.currentTimeMillis();
        long elapse = end - start;

        shutdownGracefully(executorService);
        Map<String, Long> resultMap = new HashMap<>();
        resultMap.put("result", finalResult.longValue());
        resultMap.put("time", elapse);
        return resultMap;
    }

    private static void shutdownGracefully(ExecutorService executorService) {
        executorService.shutdown(); // Disable new tasks from being submitted
        try {
            // Wait a while for existing tasks to terminate
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow(); // Cancel currently executing tasks
                // Wait a while for tasks to respond to being cancelled
                if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                    System.err.println("Pool did not terminate");
                }
            }
        } catch (InterruptedException ie) {
            // (Re-)Cancel if current thread also interrupted
            executorService.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }

    private Map<String, Long> calcStream(int[] input, int numOfThread) {
        return Collections.emptyMap();
    }

    private static int[] genericRandomArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = new Random().nextInt(10000);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] randomArray = genericRandomArray(100);
        Map<String, Long> calc = calc(randomArray, 10);
        System.out.println(calc);
    }
}
