package com.imooc.hystrix.show.command;

import com.netflix.hystrix.*;
import lombok.Data;

/**
 * @author : jiangzh
 * @program : com.imooc.hystrix.show.command
 * @description :
 **/
@Data
public class CommandDemo extends HystrixCommand<String> {

    private String name;

    public CommandDemo(String name){
        super(Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("CommandHelloWorld"))
                .andCommandPropertiesDefaults(
                        HystrixCommandProperties.defaultSetter()
                            .withRequestCacheEnabled(false) // 请求缓存开关)
                                // 切换线程池隔离还是信号量隔离
//                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)
        ).andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("MyThreadPool"))
         .andThreadPoolPropertiesDefaults(
                 HystrixThreadPoolProperties.defaultSetter()
                    .withCoreSize(2)
                    .withMaximumSize(3).withAllowMaximumSizeToDivergeFromCoreSize(true)
                    .withMaxQueueSize(2)
         ));

        this.name = name;
    }

    // 单次请求调用的业务方法
    @Override
    protected String run() throws Exception {
        String result = "CommandHelloWorld name : "+ name;

//        Thread.sleep(800l);

        System.err.println(result+" , currentThread-"+Thread.currentThread().getName());

        return result;
    }


    @Override
    protected String getCacheKey() {
        return String.valueOf(name);
    }
}
