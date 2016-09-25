package com.test.hongbao.redis;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.yubin.hongbao.common.RedisUtil;

public class testJedis {
	/*private static JedisPool jedisPool = null;
	private static Jedis jedis = null;
	
	static {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		jedisPool = (JedisPool) ctx.getBean("jedisPool");
		jedis = jedisPool.getResource();
	}*/
	
	private static Jedis jedis = RedisUtil.getJedis();
	
	public static void testSet() {
		jedis.select(0);
		jedis.set("name2", "hello jedis2");
		String str = jedis.get("name");
		//String str = jedis.get("3");
		System.out.println(str);
		//RedisUtil.returnResource(jedis);
	}
	
	public static void testget() {
		jedis.select(0);
		String str = jedis.get("name2");
		//String str = jedis.get("3");
		System.out.println(str);
		//RedisUtil.returnResource(jedis);
	}
	
	public static void main(String[] args) {
		//testSet();
		testget();
	}
}
