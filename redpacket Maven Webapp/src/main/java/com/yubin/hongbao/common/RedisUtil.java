package com.yubin.hongbao.common;

import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


public class RedisUtil {
	
	//获取jidis连接实例
	public static Jedis getJedis() {
		return RedisClient.getJedis();
	}
	
	//释放Jedis连接
	public static void returnResource(Jedis jedis) {
		RedisClient.returnResource(jedis);
	}
	
	public static Long hset(String name,String key,String values) {
		Jedis jedis = null;
		
		try {
			jedis = getJedis();
			return jedis.hset(name, key, values);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		
		return null;
	}
	
	public static String hget(String name,String key) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.hget(name, key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}
	
	
	public static long expire(String key,int times) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.expire(key, times);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}
	
	public static Long hincrBy(String name,String key,int values) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.hincrBy(name, key, values);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}
	
	public static Double hincrByFloat(String name,String key,double values) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.hincrByFloat(name, key, values);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}
	
	public static String watch(String name) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.watch(name);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}
	
	public static Set<String> keysLike(String name) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.keys(name);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	public static Long Ttl(String redpacketName) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.ttl(redpacketName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}
}
