package com.zd.threadVolatile;

public class TestVolatile {
    public static volatile boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;
            }
            System.out.println("stop");
        });
        thread.start();
        Thread.sleep(1000);
        stop = true;

    }
}
