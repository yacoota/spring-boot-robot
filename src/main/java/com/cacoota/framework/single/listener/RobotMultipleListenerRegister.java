package com.cacoota.framework.single.listener;


import com.cacoota.framework.single.event.RobotEvent;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@Scope("prototype")
@Slf4j
public class RobotMultipleListenerRegister {

    @Getter
    private List<RobotListener> listeners = new CopyOnWriteArrayList<>();

    // 默认事件注册
    private static final List<RobotListener> DEFAULT = Arrays.asList(new RobotListener[]{
            new RobotStartBeforeEventListener(), new RobotStartEventListener(), new RobotStartAfterEventListener(),
            new RobotRunEventListener(),
            new RobotStopBeforeEventListener(), new RobotStopEventListener(), new RobotStopAfterEventListener()
    });

    // 注册默认的机器人监听器
    public final List<RobotListener> register() {
        for (RobotListener listener : DEFAULT) {
            listeners.add(listener);
        }
        return listeners;
    }

    // 增加新的监听器
    public final void registerListener(RobotListener listener) {
        listeners.add(listener);
    }

    // 移除存在的监听器
    public final RobotListener unregisterListener(RobotListener listener) {
        listeners.remove(listener);
        return listener;
    }

    // 运行各类监听器 （四层嵌套有些难堪，优化到spring方式处理）
    public final void fire(Class... events) {
        for (Class event : events) {
            log.trace("执行监听'{}'事件", event.getCanonicalName());
            for (RobotListener listener : listeners) {
                Type[] giTypes = listener.getClass().getGenericInterfaces();
                for (Type t1 : giTypes) {
                    Type[] ataTypes = ((ParameterizedType) t1).getActualTypeArguments();
                    for (Type t2 : ataTypes) {
                        if (StringUtils.equals(t2.getTypeName(), event.getCanonicalName())) {
                            try {
                                listener.fire((RobotEvent) event.newInstance());
                            } catch (InstantiationException | IllegalAccessException e) {

                            }
                        }
                    }
                }
            }
        }
    }


}
