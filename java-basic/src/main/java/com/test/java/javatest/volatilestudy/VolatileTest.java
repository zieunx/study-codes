package com.test.java.javatest.volatilestudy;

import java.util.concurrent.TimeUnit;

public class VolatileTest {
    private volatile static boolean running = true;
    // volatile 변수는 main memory 로 바로 저장. 캐시값을 읽지 않는다.

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
    }
}
