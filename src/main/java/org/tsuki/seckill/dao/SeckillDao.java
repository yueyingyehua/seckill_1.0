package org.tsuki.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.tsuki.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;

/**
 * Created by tsuki on 2017/4/22.
 */
public interface SeckillDao {

    /**
     * 减库存
     * @param seckillId
     * @param killTime
     * @return 如果影响行数>1,表示更新的记录的行数
     */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     * 根据id查询秒杀对象
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     * @param offset 偏移量
     * @param limit 取多少条记录
     * @return
     */
    //由于java没有保存形参的记录：queryAll(int offet, int limit) -> queryAll(arg0,arg1)
    //@Param("offet")告诉编译器这个参数是offet
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}
