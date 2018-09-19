package com.yuny.demo1.my.test.future;

public class FutureData implements Data {

    protected  boolean isReady =false;
    protected RealData realData=null;


    public synchronized  void setData(RealData realData){
            if(isReady){
                return;

            }
            this.isReady=true;
            this.realData=realData;
            notifyAll();
    }


    @Override
    public  synchronized  String getResult() {
        while(!isReady){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return realData.getResult();
    }
}
