package org.tsuki.seckill.service;

import org.tsuki.seckill.dto.Exposer;
import org.tsuki.seckill.dto.SeckillExecution;
import org.tsuki.seckill.entity.Seckill;
import org.tsuki.seckill.exception.RepeatKillException;
import org.tsuki.seckill.exception.SeckillCloseException;
import org.tsuki.seckill.exception.SeckillException;

import java.util.List;

/**
 * Created by tsuki on 2017/4/24.
 */

/*
    业务接口：要站在使用者的角度去设计接口（不要去关注细节，接口怎么实现）
        三个方面：1、方法定义粒度：方法定义要明确。
                 2、参数
                 3、返回类型（return 类型/异常）

 */
public interface SeckillService {

    /**
     * 查询所有秒杀记录
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开启时输出秒杀接口地址，
     * 否则输出系统时间和秒杀时间
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);


    /**
     * 执行秒杀操作
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException,RepeatKillException,SeckillCloseException;

}
