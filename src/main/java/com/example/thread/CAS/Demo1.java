package com.example.thread.CAS;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 *
 *
 *
 * @author qiumeng
 * @version 1.0
 * @description
 * @date 2020/8/5 15:02
 */
public class Demo1 {


    public static void main(String[] args) {

        // AtomicInteger atomicInteger = new AtomicInteger(5);
        // System.out.println(atomicInteger.compareAndSet(5,7));//true
        // System.out.println(atomicInteger.compareAndSet(5,5));//true
        // System.out.println(atomicInteger.compareAndSet(5,8));//false
        //
        // int andIncrement = atomicInteger.getAndIncrement();
        //
        // AtomicReference<User> atomicReference = new AtomicReference();

        AtomicStampedReference atomicStampedReference = new AtomicStampedReference(2,1);

        atomicStampedReference.compareAndSet(2,3,1,1+1);

        System.out.println(atomicStampedReference.getReference());
        System.out.println(atomicStampedReference.getStamp());


    }
}
