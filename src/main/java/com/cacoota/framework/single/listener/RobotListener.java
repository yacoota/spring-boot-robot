package com.cacoota.framework.single.listener;


import com.cacoota.framework.single.event.RobotEvent;

public interface RobotListener<T extends RobotEvent> {
    public void fire(T t);
}
