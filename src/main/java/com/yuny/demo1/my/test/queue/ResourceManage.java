package com.yuny.demo1.my.test.queue;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class ResourceManage {

    private final Semaphore semaphore;
    private boolean resourceArray[];

    private final ReentrantLock lock;

    public ResourceManage() {
        this.semaphore = new Semaphore(10,true);
        this.lock=new ReentrantLock(true);
        this.resourceArray=new  boolean[10];

        for(int i=0;i<10;i++){
            resourceArray[i]=true;
        }
    }

    /*
    使用厕所资源
     */
    public void useResource(int userId){
        try {
        semaphore.acquire();

        int num=getResourceId();
        System.out.println("当前坑"+num+"正在被使用...");

        Thread.sleep(2000);//使用耗时

         System.out.println("坑"+num+"使用完毕");
        resourceArray[num] = true;//退出这个坑

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            semaphore.release();
        }

    }


    /*
    随机占坑
     */
    public int getResourceId(){
        int id=-1;
        lock.lock();
        try {
            for(int i=0;i<10;i++){
                if(resourceArray[i]){

                    resourceArray[i]=false;
                    id=i;
                    break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return id;
    }

}



