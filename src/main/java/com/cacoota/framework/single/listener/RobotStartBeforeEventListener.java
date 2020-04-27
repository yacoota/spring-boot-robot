package com.cacoota.framework.single.listener;

import com.cacoota.framework.single.event.RobotStartBeforeEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RobotStartBeforeEventListener implements RobotListener<RobotStartBeforeEvent> {

    @Override
    public void fire(RobotStartBeforeEvent event) {
        log.info("--------------------------------------------- RobotStartBeforeEventListener ------------------------------------------------------}");
    }
}
