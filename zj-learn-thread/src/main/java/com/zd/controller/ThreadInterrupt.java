package com.zd.controller;

public class ThreadInterrupt implements Runnable {
    private Integer id;

    public ThreadInterrupt(Integer id) {
        this.id = id;
    }

    public void run() {
        System.out.println("正在执行task " + id);
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("执行完毕 " + id);
    }
}
