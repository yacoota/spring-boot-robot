package com.cacoota.framework.single.event;

public class RobotStopAfterEvent implements RobotEvent {

    @Override
    public EventType source() {
        return EventType.StopAfter;
    }

}
