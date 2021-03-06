package com.example.thread.ArrayList;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *  集合类不安全问题
 * @author qiumeng
 * @version 1.0
 * @description
 * @date 2020/8/9 16:27
 */
public class ContainerNoSafeDemo {


    public static void main(String[] args) {

        List<String>list=new CopyOnWriteArrayList<>();

        for(int i=0;i<30;i++ ){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,6));
                System.out.println(list);
            },String.valueOf(i)).start();

        }
    }
}
