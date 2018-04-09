package org.yqj.dao.demo.manager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.yqj.dao.demo.config.DB1Config;
import org.yqj.dao.demo.db1.PersonDB1Mapper;
import org.yqj.dao.demo.db2.PersonDB2Mapper;
import org.yqj.dao.demo.domain.Person;

/**
 * @author yaoqijun on 2018-03-12.
 */
@Component
@Slf4j
public class CommonManager {

    @Autowired
    private PersonDB1Mapper personDB1Mapper;

    @Autowired
    private PersonDB2Mapper personDB2Mapper;

    public void printPersonContent(){
        Person person = personDB1Mapper.selectById(1L);
        System.out.println("current person is " + person.toString());
    }

    @Transactional(DB1Config.DB1_TRANSACTION)
    public void updateDiffDbCondition(){
        personDB1Mapper.updatePersonScore(1L, 7D);
        personDB2Mapper.updatePersonScore(1L, 7D);


        TransactionSynchronizationAdapter beforeTxCommitAdapter = new TransactionSynchronizationAdapter() {
            @Override
            public void beforeCommit(boolean readOnly) {
                log.info("*********************** before commit config ***********************");
            }
        };
        TransactionSynchronizationManager.registerSynchronization(beforeTxCommitAdapter);

        TransactionSynchronizationAdapter afterTxCommitAdapter = new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {
                log.info("*********************** after commit config ***********************");
            }
        };
        TransactionSynchronizationManager.registerSynchronization(afterTxCommitAdapter);
//        throw new IllegalStateException("");
    }
}
