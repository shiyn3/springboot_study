package com.yuny.demo1.my.test.queue;

public class ResourceUser implements Runnable{
    private ResourceManage resourceManage;
    private int userId;

    public ResourceUser(ResourceManage resourceManage,int userId){
        this.resourceManage=resourceManage;
        this.userId=userId;

    }

    public void run(){
        System.out.print("userId:"+userId+"准备使用资源...\n");
        resourceManage.useResource(userId);
        System.out.print("userId:"+userId+"使用资源完毕...\n");
    }


    public static void main (String[] args)throws Exception{
        //创建100个线程模拟100个要使用资源
        Thread[] userThread=new Thread[100];
        ResourceManage resourceManage=new ResourceManage();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new ResourceUser(resourceManage,i));//创建多个资源使用者
            userThread[i] = thread;
        }
        for(int i = 0; i < 100; i++){
            Thread thread = userThread[i];
            try {
                thread.start();//启动线程
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }

}
