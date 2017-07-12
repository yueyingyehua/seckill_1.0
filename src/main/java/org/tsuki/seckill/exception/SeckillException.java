package org.tsuki.seckill.exception;

/**
 * Created by tsuki on 2017/4/25.
 */

/**
 * 秒杀相关业务异常
 */
public class SeckillException extends RuntimeException{

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
