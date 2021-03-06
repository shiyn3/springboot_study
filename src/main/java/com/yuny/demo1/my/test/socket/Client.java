package com.yuny.demo1.my.test.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

    private static final int sleep_time=1000*1000*1000;
    public static void main (String [] args)throws Exception{
        Socket client = null;
        PrintWriter writer = null;
        BufferedReader reader = null;
        try {
            client = new Socket();
            client.connect(new InetSocketAddress("localhost", 8000));
            writer = new PrintWriter(client.getOutputStream(), true);
            writer.println("Hello!");
            writer.flush();
            reader = new BufferedReader(new InputStreamReader(
                    client.getInputStream()));
            System.out.println("from server: " + reader.readLine());
        } catch (Exception e) {
        } finally {
            writer.close();
        }


    }


}
