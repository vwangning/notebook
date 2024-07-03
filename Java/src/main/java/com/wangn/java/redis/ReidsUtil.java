package com.wangn.java.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class ReidsUtil {
    @Autowired
    CtgRedisService ctgRedisService;


//	redisTemplate.opsForValue();//操作字符串
//	redisTemplate.opsForHash();//操作hash
//	redisTemplate.opsForList();//操作list
//	redisTemplate.opsForSet();//操作set
//	redisTemplate.opsForZSet();//操作有序set

    //key操作

//    /**
//     * 删除key 可传多个key
//     *
//     * @param keys
//     */
//    public Long delete(String... keys) {
//        return ctgRedisService.deleteObject(CollectionUtils.arrayToList(keys));
//    }

    public Boolean del(String key) {
        return ctgRedisService.deleteObject(key);
    }

    /**
     * 给指定的key设置过期时间  单位为毫秒
     *
     * @param key
     * @param timeout 过期时间 单位是毫秒
     */
    public void expire(String key, Integer timeout) {
        ctgRedisService.expire(key, Long.valueOf(timeout), TimeUnit.MILLISECONDS);
    }


    /**
     * 移除key的过期时间，将key永久保存
     *
     * @param key
     */
    public void persist(String key) {
        ctgRedisService.persist(key);
    }

    /**
     * 检验该key是否存在 存在返回true
     *
     * @param key
     */
    public boolean hasKey(String key) {
        return ctgRedisService.containKey(key);
    }

    /**
     * 返回 key 所储存的值的类型
     *
     * @param key
     * @return
     */
    public String getType(String key) {
        return ctgRedisService.type(key);
    }

    /**
     * 从redis中随机返回一个key
     *
     * @return
     */
    public Object redomKey() {
        return ctgRedisService.randomKey();
    }


    //字符串操作

    /**
     * set字符串
     *
     * @param key
     * @param value
     */
    public void set(String key, Object value) {
        ctgRedisService.setCacheObject(key, value);

    }

    public void setEx(String key, Integer timeout, String value) {
        ctgRedisService.setCacheObject(key, value, Long.valueOf(timeout), TimeUnit.SECONDS);
    }

    public Long ttl(String key) {
        return ctgRedisService.getExpire(key);
    }
    //累加器串操作

    /**
     * decr
     *
     * @param key
     */
    public Long decr(String key, Integer timeout) {
        Long time = ctgRedisService.decrement(key);
        ctgRedisService.expire(key, Long.valueOf(timeout), TimeUnit.SECONDS);
        return time;

    }

    public Long decr(String key) {
        Long time = ctgRedisService.decrement((key));
        return time;

    }

    //累加器串操作

    /**
     * incr字符串
     *
     * @param key
     */
    public Long incr(String key, Integer timeout) {
        Long time = ctgRedisService.increment(key);
        ctgRedisService.expire(key, Long.valueOf(timeout), TimeUnit.SECONDS);
        return time;

    }

    /**
     * set字符串 并加上失效时间  以豪秒为单位
     *
     * @param key
     * @param value
     * @param timeout 失效时间 单位为豪秒
     */
    public void set(String key, Object value, Integer timeout) {
        ctgRedisService.setCacheObject(key, value, Long.valueOf(timeout), TimeUnit.MILLISECONDS);
    }

    /**
     * 当key不存在时 设置key value
     *
     * @param key
     * @param value
     */
    public void setNx(String key, Object value) {
        ctgRedisService.setIfAbsent(key, value);
    }


    /**
     * 根据key获取value
     *
     * @param key
     * @return
     */
    public Object get(String key) {
        return ctgRedisService.getCacheObject(key);
    }

    /**
     * 获取所有(一个或多个)给定 key 的值
     *
     * @param keys
     * @return
     */
//    public List<Object> mGet(String... keys) {
//        return ctgRedisService.multiGet(CollectionUtils.arrayToList(keys));
//    }



    //Hash操作

    /**
     * 删除key中指定的hashkey的值  相当于一个key中存储着map值 这个方法就是删除这个key中的map里面的一个或多个key
     *
     * @param key
     * @param hashKeys
     */
    public void hdel(String key, String... hashKeys) {
        ctgRedisService.hdel(key, hashKeys);
    }


    /**
     * 添加一个hash值
     *
     * @param key
     * @param hashKey 相当于 map中的key
     * @param value   存储的值 相当于map中的value
     */
    public void put(String key, String hashKey, String value) {
        ctgRedisService.put(key, hashKey, value);
    }


    //list操作

    /**
     * 从左入栈
     *
     * @param key
     * @param value
     */
    public void lpush(String key, String value) {
        ctgRedisService.lpush(key, value);
    }

    /**
     * 从右出栈
     *
     * @param key
     * @return
     */
    public Object rPop(String key) {
        return ctgRedisService.rpop(key);
    }

}
