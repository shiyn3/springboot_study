package com.yuny.demo1.test.syn.netty;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class TimeClientHandler extends ChannelHandlerAdapter{


        private int counter;
        private byte[] req;

    public TimeClientHandler() {
          req=("QUERY TIME ORDER"+System.getProperty("line.separator")).getBytes();
//          System.out.println("构造方法中req:"+req);
//        firstMessage= Unpooled.buffer(req.length);
//        firstMessage.writeBytes(req);
    }

    public void channelActive(ChannelHandlerContext ctx){
//        ctx.writeAndFlush(firstMessage);
            ByteBuf message=null;
            for(int i=0;i<100;i++){
                message=Unpooled.buffer(req.length);
                message.writeBytes(req);
                ctx.writeAndFlush(message);
            }

    }

    public void channelRead(ChannelHandlerContext ctx,Object msg) throws Exception{
//        ByteBuf buf=(ByteBuf)msg;
//        byte[] req=new byte[buf.readableBytes()];
//        buf.readBytes(req);
//        String body=new String(req,"UTF-8");
//        System.out.println("the time client receive  is :"+body+"; the counter is "+ ++counter);

        String body=(String)msg;
        System.out.println("the time client receive  is :"+body+"; the counter is "+ ++counter);



    }

    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        ctx.close();


    }




}
