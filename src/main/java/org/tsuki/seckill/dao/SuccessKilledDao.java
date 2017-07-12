package org.tsuki.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.tsuki.seckill.entity.SuccessKilled;

/**
 * Created by tsuki on 2017/4/22.
 */
public interface SuccessKilledDao {

    /**
     * 插入购买明细，可以过滤重复（因为设置了联合主键）
     * @param seckillId
     * @param userPhone
     * @return 插入的行数
     */
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

    /**
     * 根据id查询SuccessKilled并携带秒杀产品对象实体
     * @param seckillId
     * @return
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
}
