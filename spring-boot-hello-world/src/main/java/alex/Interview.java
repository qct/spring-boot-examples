package alex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * <p>Created by quchentao on 2018/3/20.
 */
public class Interview {

    private Map<String, Long> calc(int[] input, int numOfThread) {
        long start = System.currentTimeMillis();
        ExecutorService executorService = new ThreadPoolExecutor(numOfThread, numOfThread, 60L, TimeUnit.SECONDS,
            new SynchronousQueue<>());
        int unit = input.length / numOfThread;
        List<Future<Long>> resultFutures = new ArrayList<>(numOfThread);
        for (int i = 0; i < numOfThread; i++) {
            int finalI = i;
            Future<Long> future = executorService.submit(() -> {
                long result = 0L;
                for (int j = finalI * unit + 1; j < finalI * (unit + 1); j++) {
                    result += input[j];
                }
                return result;
            });
            resultFutures.add(future);
        }

        AtomicLong result = new AtomicLong(0L);
        resultFutures.forEach(f -> {
            try {
                result.addAndGet(f.get());
            } catch (InterruptedException | ExecutionException e) {
                //thorw logic exception.
                e.printStackTrace();
            }
        });

        long end = System.currentTimeMillis();
        long elapse = end - start;

        Map<String, Long> resultMap = new HashMap<>();
        resultMap.put("result", result.longValue());
        resultMap.put("time", elapse);
        return resultMap;
    }

    private Map<String, Long> calcStream(int[] input, int numOfThread) throws InterruptedException {
        return Collections.emptyMap();
    }
}
