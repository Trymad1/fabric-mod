package com.trymad.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncDatabase {
    private static final ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void runAsync(Runnable task) {
        executor.submit(task);
    }

    public static void shutdown() {
        executor.shutdown();
    }
}