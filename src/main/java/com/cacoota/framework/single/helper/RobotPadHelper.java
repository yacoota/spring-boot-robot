package com.cacoota.framework.single.helper;

import com.cacoota.framework.single.Robot;
import com.cacoota.framework.single.RobotHelper;
import com.cacoota.framework.single.event.*;
import com.cacoota.framework.single.listener.RobotMultipleListenerRegister;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.PostConstruct;

@Component("pad")
@Scope("prototype")
@Slf4j
public class RobotPadHelper implements RobotHelper {

    @Getter
    @Setter
    private Robot robot;

    @Autowired
    private RobotMultipleListenerRegister register;

    @PostConstruct
    public void init() {
        register.register();
    }

    @Override
    public void start() {
        register.fire(RobotStartBeforeEvent.class);

        log.info("机器人PAD-{}开始运行", this);

        register.fire(RobotStartAfterEvent.class);
    }

    @Override
    public void running() {
        log.info("机器人PAD-{}正在运行中...", this);
        register.fire(RobotRunEvent.class);
    }

    @Override
    public void stop() {
        register.fire(RobotStopBeforeEvent.class);

        log.info("机器人PAD-{}终止运行", this);

        register.fire(RobotStopAfterEvent.class);

    }


    @Override
    public String toString() {
        return "ROBOT_HELPER_PAD$".concat(StringUtils.upperCase(ObjectUtils.getIdentityHexString(this)));
    }


}
