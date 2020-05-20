package com.zd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
public class HelloController {

    ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<Runnable>(5));

    @GetMapping("get")
    public String main(Integer id) {
        ThreadInterrupt interrupt = new ThreadInterrupt(id);
        executor.execute(interrupt);

        executor.submit(new Runnable() {
            public void run() {
                System.out.println("线程启动");
            }
        });
//        Thread thread = new Thread(interrupt);
//        thread.start();
        System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" +
                executor.getQueue().size() + "，已执行玩别的任务数目：" + executor.getCompletedTaskCount());

        return "hello";
    }
}
