package com.cacoota.framework.single.listener;

import com.cacoota.framework.single.event.RobotStopBeforeEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RobotStopBeforeEventListener implements RobotListener<RobotStopBeforeEvent> {

    @Override
    public void fire(RobotStopBeforeEvent event) {
        log.info("--------------------------------------------- RobotStopBeforeEventListener ------------------------------------------------------}");
    }
}
