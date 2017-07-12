package org.tsuki.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tsuki.seckill.dto.Exposer;
import org.tsuki.seckill.dto.SeckillExecution;
import org.tsuki.seckill.entity.Seckill;
import org.tsuki.seckill.exception.RepeatKillException;
import org.tsuki.seckill.exception.SeckillCloseException;

import java.util.List;

/**
 * Created by tsuki on 2017/4/25.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"
})
public class SeckillServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;
    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}", list);

    }

    @Test
    public void getById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}", seckill);

    }

    //集成测试代码完整逻辑，注意可重复执行
    @Test
    public void testSeckillLogic() throws Exception {
        long id = 1000;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()) {
            logger.info("exposer={}", exposer);
            long phone = 12312312382L;
            String md5 = exposer.getMd5();
            try {
                SeckillExecution execution = seckillService.executeSeckill(id, phone, md5);
                logger.info("result={}", execution);
            } catch (RepeatKillException e) {
                logger.error(e.getMessage());
            } catch (SeckillCloseException e) {
                logger.error(e.getMessage());
            }
        } else {
            //秒杀为开启
            logger.warn("exposer={}", exposer);
        }
    }

/*    @Test
    public void exportSeckillUrl() throws Exception {
        long id = 1000;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        logger.info("exposer={}", exposer);
        //Exposer{
        // exposed=true,
        // md5='851bacc421676d152373bdf98d0c9126',
        // seckillId=1000,
        // now=0,
        // start=0,
        // end=0}

    }

    @Test
    public void executeSeckill() throws Exception {
        long id = 1000;
        long phone = 12312312382L;
        String md5 = "851bacc421676d152373bdf98d0c9126";
        try {
            SeckillExecution execution = seckillService.executeSeckill(id, phone, md5);
            logger.info("result={}", execution);
        } catch (RepeatKillException e) {
            logger.error(e.getMessage());
        } catch (SeckillCloseException e) {
            logger.error(e.getMessage());
        }
    }*/

}