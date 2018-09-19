package com.yuny.demo1.my.test.socket;

import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

public class EchoClient implements Runnable {

    private static final int sleep_time=1000*1000*1000;
    private static ExecutorService tp= Executors.newCachedThreadPool();
    private PrintWriter writer=null;

    private Socket client=null;
    public EchoClient(){


    }
    public EchoClient(Socket client){
        this.client=client;

    }


    @Override
    public void run() {
        try {
            client = new Socket();
            client.connect(new InetSocketAddress("localhost", 8000));
            writer = new PrintWriter(client.getOutputStream(), true);
            writer.print("H");
            LockSupport.parkNanos(sleep_time);
            writer.print("e");
            LockSupport.parkNanos(sleep_time);
            writer.print("l");
            LockSupport.parkNanos(sleep_time);
            writer.print("l");
            LockSupport.parkNanos(sleep_time);
            writer.print("o");
            LockSupport.parkNanos(sleep_time);
            writer.print("!");
            LockSupport.parkNanos(sleep_time);
            writer.println();
            writer.flush();
        }catch(Exception e)
        {
        }
        finally {
            writer.close();
        }




    }

    public static void main (String [] args)throws Exception{

        //测试延迟类型客户端
        EchoClient ec=new EchoClient();
        new Thread(ec).start();

    }

}
