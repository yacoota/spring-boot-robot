package com.cacoota.framework.single.event;

public class RobotStartBeforeEvent implements RobotEvent {

    @Override
    public EventType source() {
        return EventType.StartBefore;
    }

}
