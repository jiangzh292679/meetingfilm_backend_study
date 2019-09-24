package com.mooc.meetingfilm.backend.common.lombokshow;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Slf4j
public class Main {
    
    public static void main(String[] args) throws IOException {
        // 实体上面帮助我们简化冗余代码，增加代码可读性
        UserModel userModel = new UserModel();
        userModel.setId("111");

        UserModel user = UserModel.builder().id("").username("").userpasswd("").build();

        // 日志使用
        log.info("");
        log.error("");

        // 流式对象操作的关闭
        @Cleanup FileInputStream fileInputStream = new FileInputStream(new File(""));

    }

}
