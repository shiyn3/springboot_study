package com.yuny.demo1.test.aio.netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class AsyncTimeServer  {



    public static void main(String[] args) throws Exception{

        AsyncTimeServerHandler  timeServer=new AsyncTimeServerHandler("127.0.0.1",80);

        new Thread(timeServer,"AIO-AsyncTimeServerHandler-001").start();

    }




}
