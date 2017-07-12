package org.tsuki.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tsuki.seckill.entity.SuccessKilled;

import javax.annotation.Resource;

/**
 * Created by tsuki on 2017/4/24.
 */

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() throws Exception {
        long id = 1001L;
        long phone = 12345678912L;
        int insertCount = successKilledDao.insertSuccessKilled(id, phone);
        System.out.println("insertCount=" + insertCount);

    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        long id = 1001L;
        long phone = 12345678912L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id, phone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());

    }

}