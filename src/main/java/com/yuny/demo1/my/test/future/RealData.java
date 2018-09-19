package com.yuny.demo1.my.test.future;

import com.yuny.demo1.my.test.future.Data;

public class RealData implements Data {

    protected  final  String result ;
//    protected  final  boolean isReady=false;
    public RealData(String para)  {
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<10;i++){
            sb.append(para);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }

        }

        result=sb.toString();

    }

    @Override
    public String getResult() {
        return result;
    }
}
