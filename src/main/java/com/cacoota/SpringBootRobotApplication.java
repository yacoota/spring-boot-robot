package com.cacoota;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@SpringBootApplication
@EnableScheduling
public class SpringBootRobotApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRobotApplication.class, args);
        log.info("-------------------------------------- 应用程序启动完成 --------------------------------------");
    }


}
