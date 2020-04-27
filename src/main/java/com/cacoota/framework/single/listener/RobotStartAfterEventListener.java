package com.cacoota.framework.single.listener;

import com.cacoota.framework.single.event.RobotStartAfterEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RobotStartAfterEventListener implements RobotListener<RobotStartAfterEvent> {

    @Override
    public void fire(RobotStartAfterEvent event) {
        log.info("--------------------------------------------- RobotStartAfterEventListener ------------------------------------------------------}");
    }
}
