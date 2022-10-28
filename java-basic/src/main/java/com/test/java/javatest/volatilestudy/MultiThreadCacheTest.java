package com.test.java.javatest.volatilestudy;

import java.util.concurrent.TimeUnit;

public class MultiThreadCacheTest {
    private static boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        Thread increaseNumberThread = new Thread(() -> {
            int number = 0;
            while (running) {
                number++;
            }
            System.out.printf("stop Thread. number=%d", number);
        });
        increaseNumberThread.start();
        TimeUnit.SECONDS.sleep(1);
        running = false;
        // increaseNumberThread 는 캐싱된 'running' 을 바라보게 되어 변경된 main memory 값을 보지 못하고 무한루프에 빠지다.
    }
}
