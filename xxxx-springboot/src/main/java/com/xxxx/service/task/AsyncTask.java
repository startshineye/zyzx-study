package com.xxxx.service.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncTask {

    /**
     * 异步调用:不返回数据
     */
    @Async
    public void noReurnTask(){
       System.out.println("Thread noReurnTask start:"+Thread.currentThread().getName()+" "+System.currentTimeMillis());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread noReurnTask end:"+Thread.currentThread().getName()+" "+System.currentTimeMillis());
    }

    /**
     * 异步返回数据
     * @return
     */
    @Async
    public Future<String> haveReturnTask(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new AsyncResult<String>("异步回调返回数据！");
    }
}
