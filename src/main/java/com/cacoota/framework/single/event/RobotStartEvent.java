package com.cacoota.framework.single.event;

public class RobotStartEvent implements RobotEvent {

    @Override
    public EventType source() {
        return EventType.Starting;
    }

}
