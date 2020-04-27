package com.cacoota.robot;

import com.alibaba.fastjson.JSON;
import com.cacoota.framework.multiple.RobotRegister;
import com.cacoota.framework.single.Robot;
import com.cacoota.framework.single.RobotHelper;
import com.cacoota.framework.spring.SpringApplicationContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/robot")
public class RobotController {

    @Autowired
    @Qualifier("pad")
    private RobotHelper phelper;

    @Autowired
    @Qualifier("mac")
    private RobotHelper mhelper;

    @Autowired
    private RobotRegister register;

    @RequestMapping(value = {"", "/"})
    public void robot() {
        Robot robot = (Robot) SpringApplicationContext.getBean("robot");
        // 随机生成两种类型助手信息
        if (RandomUtils.nextBoolean()) {
            robot.setHelper(phelper);
        } else {
            robot.setHelper(mhelper);
        }
        log.info("机器人生成器: {}, 助手信息: {}, 运行次数: {}", robot, robot.getHelper(), robot.getCount());

        // 机器人生命周期运行
        new Thread(()->{
            // 1、开始运行机器人
            robot.start();
            // 2、随机运行次数
            try {
                robot.running();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 3、结束运行
            robot.stop();
        }).start();

    }

    @RequestMapping("/monitor")
    @ResponseBody
    public String monitor() {
        Set<Robot> robots = register.all();
        log.info("机器人监听信息, 数量: {}, 信息: {}", robots.size(), robots);
        return register.toString() ;
    }

}
