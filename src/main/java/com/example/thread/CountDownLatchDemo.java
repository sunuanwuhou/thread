package com.example.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author qiumeng
 * @version 1.0
 * @description
 * @date 2020/8/14 7:35
 */
public class CountDownLatchDemo {

    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();
        c.await();
        System.out.println("3");

    }

}
