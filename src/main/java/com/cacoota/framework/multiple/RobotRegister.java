package com.cacoota.framework.multiple;

import com.cacoota.framework.single.Robot;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Slf4j
public class RobotRegister {

    private Set<Robot> robots = Sets.newConcurrentHashSet();

    public int register(Robot robot) {
        robots.add(robot);
        return robots.size();
    }

    public Robot unregister(Robot robot) {
        robots.remove(robot);
        return robot;
    }

    public Set<Robot> all() {
        return robots;
    }


    @Override
    public String toString() {
        return StringUtils.join(robots.toArray(), ":::");
    }


}
