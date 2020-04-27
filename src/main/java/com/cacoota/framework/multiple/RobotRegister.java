package com.cacoota.framework.multiple;

import com.cacoota.framework.single.Robot;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Set;

@Component
@Slf4j
public class RobotRegister {

    private Set<Robot> wechats = Sets.newConcurrentHashSet();

    public int register(Robot robot) {
        wechats.add(robot);
        return wechats.size();
    }

    public Robot unregister(Robot robot) {
        wechats.remove(robot);
        return robot;
    }

    public Set<Robot> all() {
        return wechats;
    }


    @Override
    public String toString() {
        return StringUtils.join(wechats.toArray(),":::");
    }


}
