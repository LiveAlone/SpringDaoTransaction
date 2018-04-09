package org.yqj.dao.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.yqj.dao.demo.manager.CommonManager;
import org.yqj.dao.demo.manager.Db1Manager;
import org.yqj.dao.demo.manager.Db2Manager;

/**
 * Created by yaoqijun.
 * Date:2016-04-27
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
@Component
@Slf4j
public class RunCommandLine implements CommandLineRunner{

    @Autowired
    private CommonManager commonManager;

    @Autowired
    private Db1Manager db1Manager;

    @Autowired
    private Db2Manager db2Manager;

    public void run(String... args) {

//        db2Manager.updateDiffDbCondition();

//        commonManager.updateDiffDbCondition();

//        db1Manager.updateDiffDbConditionWithCallback();
//
        commonManager.printPersonContent();

//        log.info(" command info run");
    }

}
