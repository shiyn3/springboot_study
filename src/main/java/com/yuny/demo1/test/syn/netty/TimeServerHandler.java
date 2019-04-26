package com.yuny.demo1.test.syn.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;

public class TimeServerHandler extends ChannelHandlerAdapter{

    private int counter;
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//
            String body=(String)msg;
            System.out.println("the time server receive order :"+ body+" ; the counter is "+ ++counter);
        String currentTimte="QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString():"BAD ORDER";
        currentTimte=currentTimte+System.getProperty("line.separator");
        ByteBuf resp= Unpooled.copiedBuffer(currentTimte.getBytes());
        ctx.writeAndFlush(resp);
    }

//    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//     ctx.flush();
//    }
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
