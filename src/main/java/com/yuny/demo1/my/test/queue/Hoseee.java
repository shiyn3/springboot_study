package com.yuny.demo1.my.test.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Hoseee {
    private static Integer count=0;
//    private static AtomicInteger count = new AtomicInteger();
    final BlockingQueue<Integer> bq=new ArrayBlockingQueue<Integer>(10);


    private static void AddCount(){
        synchronized(count){
            count++;

            System.out.println("目前总共有" + count);

        }
    }
    private static void jianjianCount(){
        synchronized(count){
            count--;
            System.out.println("目前总共有" + count);

        }
    }





    class Producer implements Runnable{
        private String threadName="";
        public Producer(String threadName){
            this.threadName=threadName;

        }


        public void run(){
            Thread.currentThread().setName(threadName);
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    bq.put(1);
//                    count++;
                    System.out.println(Thread.currentThread().getName()
                            + "目前总共有" + bq.size());
//                    Hoseee.AddCount();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }

        }
    }



    public class Consume implements Runnable{
        private String threadName="";
        public Consume(String threadName){
            this.threadName=threadName;

        }

        public void run(){
            Thread.currentThread().setName(threadName);
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    bq.take();
//                    count--;
                    System.out.println(Thread.currentThread().getName()
                            + "目前总共有" + + bq.size());
//                    Hoseee.jianjianCount();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }


        }

    }

    public static  void main(String [] args)throws Exception{

       Hoseee hosee=new Hoseee();

        new Thread(hosee.new Producer("生产这【第一个线程】")).start();
        new Thread(hosee.new Consume("消费者【第二个线程】")).start();
        new Thread(hosee.new Producer("生产这【第三个线程】")).start();
        new Thread(hosee.new Consume("消费者【第四个线程】")).start();
        new Thread(hosee.new Producer("生产这【第五个线程】")).start();
        new Thread(hosee.new Consume("消费者【第六个线程】")).start();
//        new Thread(hosee.new Producer("生产这【第7个线程】")).start();
//        new Thread(hosee.new Consume("消费者【第8个线程】")).start();

    }

}
