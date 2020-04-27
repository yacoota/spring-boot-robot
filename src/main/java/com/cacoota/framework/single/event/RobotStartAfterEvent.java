package com.cacoota.framework.single.event;

public class RobotStartAfterEvent implements RobotEvent {

    @Override
    public EventType source() {
        return EventType.StartAfter;
    }

}
