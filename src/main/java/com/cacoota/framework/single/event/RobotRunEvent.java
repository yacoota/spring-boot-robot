package com.cacoota.framework.single.event;

public class RobotRunEvent implements RobotEvent {

    @Override
    public EventType source() {
        return EventType.Running;
    }

}
