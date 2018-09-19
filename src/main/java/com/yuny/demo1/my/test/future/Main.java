package com.yuny.demo1.my.test.future;

import com.yuny.demo1.my.test.future.Client;
import com.yuny.demo1.my.test.future.Data;

public class Main {

    public static void main(String [] args)throws Exception{

        Client client=new Client();

        Data data= client.request("testmy");
        System.out.println("请求完毕");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("使用真实"+data.getResult());
    }
}
