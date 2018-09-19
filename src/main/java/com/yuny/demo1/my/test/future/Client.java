package com.yuny.demo1.my.test.future;

public class Client {


    public Data request(final String queryStr){
        final FutureData fd=new FutureData();

        new Thread(){
                public void run(){

                    RealData rd=new RealData(queryStr);

                    fd.setData(rd);

                }

        }.start();
        return fd;
    }
}
