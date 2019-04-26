package com.yuny.demo1.test.nio.netty;

import java.net.Socket;

public class TimeClient {

    public static Socket socket=null;
    public static int BUFFER_SIZE=1024;
    private static int port=8080;

    public static void main(String [] args)throws  Exception{
//         Selector  selector= Selector.open();
//        TimeClient  tc=new TimeClient();
//
//
//        SocketChannel clientChannel= SocketChannel.open();
//        clientChannel.configureBlocking(false);
//        socket=clientChannel.socket();
//        socket.setReuseAddress(true);
//        socket.setReceiveBufferSize(BUFFER_SIZE);
//        socket.setSendBufferSize(BUFFER_SIZE);
//        boolean connected= clientChannel.connect(new InetSocketAddress("127.0.0.1",port));


//        if(connected){
//            clientChannel.register(selector, SelectionKey.OP_READ,tc.ioHandler());
//
//        }
//        else{
//            clientChannel.register(selector, SelectionKey.OP_ACCEPT,tc.ioHandler());
//
//        }
        int port=8080;
        String host="127.0.0.1";
        TimeClientHandle   timeClient=new TimeClientHandle(host,port);

        new Thread(timeClient,"NIO-TimeClientHandle-001").start();

    }
}
