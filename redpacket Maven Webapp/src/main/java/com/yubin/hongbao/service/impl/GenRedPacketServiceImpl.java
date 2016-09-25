package com.yubin.hongbao.service.impl;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.yubin.hongbao.alg.RedPacketAlg;
import com.yubin.hongbao.bean.RedPacket;
import com.yubin.hongbao.common.CommonUtil;
import com.yubin.hongbao.common.DateTool;
import com.yubin.hongbao.common.RedisUtil;
import com.yubin.hongbao.common.constant.RPDb;
import com.yubin.hongbao.service.GenRedPacketService;
import com.yubin.hongbao.service.dao.GenRedPacketDao;

@Service("genRedPacketServiceImpl")
public class GenRedPacketServiceImpl implements GenRedPacketService {
	Logger log = Logger.getLogger(GenRedPacketServiceImpl.class);
	
	@Resource(name="genRedPacketDaoImpl")
	GenRedPacketDao genRedPacketDao;


	
	public boolean genRedPacket(RedPacket redPacket) {
		boolean flag =  addRedPacketToRedis(redPacket);
		if(!flag) {
			return false;
		}
		
		//设置有效期
		int expireTimes = redPacket.getTime();
		if(expireTimes > 0) {
			String redPacketName = redPacket.getRedPacketId();  
			long rt = RedisUtil.expire(redPacketName, expireTimes);
			if(rt == 0) {
				return false;
			}
		}
		
		//持久红包数据
		genRedPacketDao.persistRedPacket(redPacket);
		
		return true;
	}


	public int redPacketRemainSize(String redPacketName) {
		String remainSize = RedisUtil.hget(redPacketName, RPDb.R_RED_PACKET_NUMS);
		return Integer.valueOf(remainSize);
	}
	
	public double redPacketRemainMoney(String redPacketName) {
		String remainMoney = RedisUtil.hget(redPacketName, RPDb.R_RED_PACKET_MONEY);
		return Double.valueOf(remainMoney);
	}


	public double queryRedPacketMoney(String redPacketName, String grabUserId) {
		String userMoney = RedisUtil.hget(redPacketName, grabUserId);
		if(CommonUtil.isEmpty(userMoney)) {
			return 0;
		}
		return Double.valueOf(userMoney);
	}


	public  double grabRedPacket(String redPacketName, String grabUserId) {
		RedPacket redPacket = new RedPacket();
		redPacket.setRedPacketId(redPacketName);
		redPacket.setGrabUserId(grabUserId);
		
		//1:调用红包算法生成红包金额
		double money = CalRedPacketMoney(redPacket);
		if(money == 0) {
			return 0;
		}
		//2:从redis取出一个红包,修改金额和剩余红包数量,并加入用户获取红包记录
		boolean flag = getAndUpdateRedPacketInfo(redPacket);
		if(!flag) {
			return 0;
		}
		
		//3:将用户获取红包记录持久至mysql数据库
		flag = persistGrabRedPacket(redPacket);
		if(!flag) {
			return 0;
		}
		
		//4:成功返回红包金额
		return 	money;
		
	}


	private boolean persistGrabRedPacket(RedPacket redPacket) {
		//持久用户抢红包记录
		redPacket.setGrabTime(DateTool.getDateTime());
		genRedPacketDao.persistGrabRedPacket(redPacket);
		
		return true;
	}


	private boolean getAndUpdateRedPacketInfo(RedPacket redPacket) {
		 String redPacketId = redPacket.getRedPacketId();
	     //String userId  = redPacket.getUserId() ;
		 //int    remainSize  = redPacket.getRemainSize();
		 //double  remainMoney  = redPacket.getRemainMoney();
		 String grabUserId  = redPacket.getGrabUserId();
		 double grabMoney  = redPacket.getGrabMoney();
		 
		 //将红包剩余数量减一
		 Long rtl =  RedisUtil.hincrBy(redPacketId, RPDb.R_RED_PACKET_NUMS, -1);
		 if(rtl == null) {
			 return false;
		 }
		 
		 //更新红包剩余金额
		 Double rtd = RedisUtil.hincrByFloat(redPacketId, RPDb.R_RED_PACKET_MONEY, grabMoney*(-1));
		 if(rtd == null) {
			 return false;
		 }
		 
		 //插入抢红包成功记录,key(grabUserId)-value(grabMoney)
		 rtl = RedisUtil.hset(redPacketId, grabUserId, String.valueOf(grabMoney));
		 if(rtl == null) {
			 return false;
		 }
		 
		return true;
	}


	private double CalRedPacketMoney(RedPacket redPacket) {
		String redPacketName = redPacket.getRedPacketId();
		int remainSize = redPacketRemainSize(redPacketName);
		if(remainSize == 0) {
			//红包已抢完
			return 0;
		}
		double remainMoney = redPacketRemainMoney(redPacketName);
		redPacket.setRemainMoney(remainMoney);
		redPacket.setRemainSize(remainSize);
		
		//计算金额
		double amount = RedPacketAlg.getRandomMoney(redPacket);
		redPacket.setGrabMoney(amount);
		return  amount;
	}
	
	public boolean addRedPacketToRedis(RedPacket redPacket) {
		String redPacketName = redPacket.getRedPacketId();
		String userid = redPacket.getUserId();
		String money = String.valueOf(redPacket.getMoney());
		String num = String.valueOf(redPacket.getSize());
		
		long rt = RedisUtil.hset(redPacketName, RPDb.R_RED_PACKET_USER, userid);
		rt = RedisUtil.hset(redPacketName, RPDb.R_RED_PACKET_MONEY, money);
		rt = RedisUtil.hset(redPacketName, RPDb.R_RED_PACKET_NUMS, num);
		if(rt == 0) {
			return false;
		}
		
		return true;
	}

	@PreDestroy
	public void destroy() {
		//System.out.println("99999999999999999999999999999999999999999999999999999999");
	}
}
