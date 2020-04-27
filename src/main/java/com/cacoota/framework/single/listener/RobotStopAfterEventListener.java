package com.cacoota.framework.single.listener;

import com.cacoota.framework.single.event.RobotStopAfterEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RobotStopAfterEventListener implements RobotListener<RobotStopAfterEvent> {

    @Override
    public void fire(RobotStopAfterEvent event) {
        log.info("--------------------------------------------- RobotStopAfterEventListener ------------------------------------------------------}");
    }
}
