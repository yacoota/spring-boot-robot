package com.cacoota.framework.single.listener;

import com.cacoota.framework.single.event.RobotStopEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RobotStopEventListener implements RobotListener<RobotStopEvent> {

    @Override
    public void fire(RobotStopEvent event) {
        log.info("--------------------------------------------- RobotStopEventListener ------------------------------------------------------}");
    }
}
