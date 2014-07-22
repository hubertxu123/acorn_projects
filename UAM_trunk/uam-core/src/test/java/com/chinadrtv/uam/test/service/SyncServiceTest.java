package com.chinadrtv.uam.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chinadrtv.uam.sync.service.SyncService;
import com.chinadrtv.uam.test.BaseTest;
import org.springframework.test.annotation.Rollback;

/**
 * Created with IntelliJ IDEA.
 * User: zhoutaotao
 * Date: 14-4-25
 * Time: 下午1:24
 * To change this template use File | Settings | File Templates.
 */
public class SyncServiceTest extends BaseTest {
    @Autowired
    private SyncService syncService;

    @Test
    //@Rollback(false)
     public void test_sycn(){
        //同步
       //syncService.syncLdapInfo();

        //同步权限
       syncService.syncLdapRoles();

     }


    @Test
    //@Rollback(false)
    public void test_sycnUser(){
        //同步
        syncService.syncUser("23437","Agentsh25");
    }




}
