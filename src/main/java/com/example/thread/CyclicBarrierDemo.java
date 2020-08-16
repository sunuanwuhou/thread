package com.example.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * @author qiumeng
 * @version 1.0
 * @description
 * @date 2020/8/16 20:42
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("最后执行的主线程");
        });

        for(int i=1;i<=7;i++ ){

            final  int temp=i;

            new Thread(()->{
                System.out.println("线程"+temp+"执行");
                try {
                    cyclicBarrier.await();
                    System.out.println("线程"+temp+"在主线程执行完毕后执行");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }).start();
        }

    }
}
