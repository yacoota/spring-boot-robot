package com.cacoota.framework.single.event;

public class RobotStopBeforeEvent implements RobotEvent {

    @Override
    public EventType source() {
        return EventType.StopBefore;
    }

}
