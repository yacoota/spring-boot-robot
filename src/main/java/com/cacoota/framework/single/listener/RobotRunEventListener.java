package com.cacoota.framework.single.listener;

import com.cacoota.framework.single.event.RobotRunEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RobotRunEventListener implements RobotListener<RobotRunEvent> {

    @Override
    public void fire(RobotRunEvent event) {
        log.info("--------------------------------------------- RobotRunEventListener ------------------------------------------------------}");
    }
}
