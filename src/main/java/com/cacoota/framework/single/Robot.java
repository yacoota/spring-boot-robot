package com.cacoota.framework.single;

import com.cacoota.framework.multiple.RobotRegister;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.TimeUnit;

@Component
@Scope("prototype")
@Slf4j
public class Robot {

    @Autowired
    private RobotRegister register;

    @PostConstruct
    public void init() {
        register.register(this);
    }

    @PreDestroy
    public void destory() {
    }

    @Setter
    @Getter
    private RobotHelper helper;

    @Getter
    private int count = RandomUtils.nextInt(5,10);

    public void start() {
        this.helper.start();
        log.info("机器人{}启动成功， 助手{}启动成功。", this, this.helper);
    }

    public void stop() {
        this.helper.stop();
        register.unregister(this);
        log.info("机器人{}关机成功， 助手{}关机成功。", this, this.helper);
    }

    public void running() throws InterruptedException {
        int random  = RandomUtils.nextInt(3,10);
        for (int i = 0; i < this.count; ++i) {
            this.helper.running();
            log.info("机器人[{}, {}]运行中, 次数: {}, 当前线程: {}", this, this.helper, i, Thread.currentThread());
            TimeUnit.SECONDS.sleep(random);
        }
    }

    @Override
    public String toString() {
        return "ROBOT$".concat(StringUtils.upperCase(ObjectUtils.getIdentityHexString(this)));
    }

}
