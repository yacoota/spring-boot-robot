package com.cacoota.framework.single.listener;

import com.cacoota.framework.single.event.RobotStartEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RobotStartEventListener implements RobotListener<RobotStartEvent> {

    @Override
    public void fire(RobotStartEvent event) {
        log.info("--------------------------------------------- RobotStartEventListener ------------------------------------------------------}");
    }
}
