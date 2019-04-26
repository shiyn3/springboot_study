package com.yuny.demo1.test.aio.netty;

public class AsyncTimeClient {


    public static void main (String[] args) throws Exception{

        new Thread(new AsyncTimeClientHandler("127.0.0.1",80),"AIO-AsyncTimeClientHandler-001").start();

    }


}
