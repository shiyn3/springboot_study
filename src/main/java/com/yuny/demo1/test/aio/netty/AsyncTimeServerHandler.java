package com.yuny.demo1.test.aio.netty;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

public class AsyncTimeServerHandler implements  Runnable {


    private String host;
    private int port;
    CountDownLatch latch;
    AsynchronousServerSocketChannel asynchronousServerSocketChannel;
    private volatile boolean stop;


    public AsyncTimeServerHandler(String host, int port) {
        this.host = host;
        this.port = port;
        try {
            asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
            asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
            System.out.println("the time server is start in port: " + port);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        latch = new CountDownLatch(1);

        try {
            doAccept();
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }


    }


    private void doAccept()  {
        asynchronousServerSocketChannel.accept(this,new AcceptCompletionHandler());

    }

    public void asynchronousServerSocketChannel(AsyncTimeServerHandler attachment, AcceptCompletionHandler acceptCompletionHandler) {
    }
}
