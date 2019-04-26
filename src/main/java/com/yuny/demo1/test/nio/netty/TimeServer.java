package com.yuny.demo1.test.nio.netty;

public class TimeServer {

        public static void main(String[] args) throws Exception{

                int port =8080;
                if(args !=null && args.length>0){
                    port=Integer.valueOf(args[0]);

                }

                MultiplexerTimeServer  mts=new MultiplexerTimeServer(port);
                new Thread(mts,"NIO-MultiplexerTimeServer-001").start();

        }



}
