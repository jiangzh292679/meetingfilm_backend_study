package com.imooc.hystrix.show.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
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
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("CommandHelloWorld")));

        this.name = name;
    }

    // 单次请求调用的业务方法
    @Override
    protected String run() throws Exception {
        String result = "CommandHelloWorld name : "+ name;

        Thread.sleep(800l);

        System.err.println(result+" , currentThread-"+Thread.currentThread().getName());

        return result;
    }
}
