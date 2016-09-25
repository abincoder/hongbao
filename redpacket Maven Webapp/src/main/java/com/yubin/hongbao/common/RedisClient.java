package com.yubin.hongbao.common;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisClient {
private static Logger logger = Logger.getLogger("RedisClient.class");
	
	//这里要主要静态变量不能用spring直接注入,要采用set方法
	//@Resource(name = "jedisPool'")
	private static JedisPool jedisPool;
	
	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}
	
	public JedisPool getJedisPool() {
		return jedisPool;
	}
	
	public static Jedis getJedis() {
		return jedisPool.getResource(); 
	}
	
	public static void returnResource(Jedis jedis) {
		if(jedis != null) {
			jedisPool.returnResource(jedis);
			logger.debug("Jedis close !");
		}
	}
	
	
}
