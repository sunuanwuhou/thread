package com.example.thread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author qiumeng
 * @version 1.0
 * @description
 * @date 2020/8/13 7:30
 */
public class ReadLockDemo {

    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
    }
}
