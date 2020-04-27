package com.cacoota.framework.single.event;

public class RobotStopEvent implements RobotEvent {

    @Override
    public EventType source() {
        return EventType.Stoping;
    }

}
