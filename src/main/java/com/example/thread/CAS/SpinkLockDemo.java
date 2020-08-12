package com.example.thread.CAS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author qiumeng
 * @version 1.0
 * @description
 * @date 2020/8/12 21:31
 */
public class SpinkLockDemo {

    AtomicReference<Thread> threadAtomicReference=new AtomicReference<>();

    public void lock(){

        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        while (!threadAtomicReference.compareAndSet(null,thread)){

        }

    }

    public void unLock(){

        Thread thread = Thread.currentThread();
        threadAtomicReference.compareAndSet(thread,null);

    }


    public static void main(String[] args) {

        //A线程获得
        SpinkLockDemo spinkLockDemo = new SpinkLockDemo();
        new Thread(()->{
            spinkLockDemo.lock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
            spinkLockDemo.unLock();
        },"AA").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Thread(()->{
            spinkLockDemo.lock();
            spinkLockDemo.unLock();
        },"BB").start();

    }
}
