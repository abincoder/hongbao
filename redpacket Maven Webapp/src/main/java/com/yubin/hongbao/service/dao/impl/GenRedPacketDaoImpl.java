package com.yubin.hongbao.service.dao.impl;

import org.springframework.stereotype.Service;

import com.yubin.hongbao.bean.RedPacket;
import com.yubin.hongbao.common.DateTool;
import com.yubin.hongbao.common.MysqlUtil;
import com.yubin.hongbao.service.dao.GenRedPacketDao;

@Service
public class GenRedPacketDaoImpl implements GenRedPacketDao {

	public void persistRedPacket(RedPacket redPacket) {
		String userID = redPacket.getUserId();
		String redPackId = redPacket.getRedPacketId();
		double money = redPacket.getMoney();
		int num = redPacket.getSize();
		long expireTime = redPacket.getTime();
		String createTime = redPacket.getCreateTime();
		
		String sql = "insert into red_packet (USER_ID,RED_PACKET_ID,"
				+ "MONEY,NUM,CREATE_DATE,EXPIRE_TIME) values (?,?,?,?,?,?) ";
		Object[] params = new Object[]{userID,redPackId,money,num,createTime,expireTime};
		
		MysqlUtil.update(sql, params);
		
	}

	public void persistGrabRedPacket(RedPacket redPacket) {
		String grabUsetId = redPacket.getGrabUserId();
		String redPackId = redPacket.getRedPacketId();
		double money = redPacket.getGrabMoney();
		String grabTime = redPacket.getGrabTime();
		
		String sql = "insert into grab_red_packet_record (GRAB_USER_ID,RED_PACKET_ID,"
				+ "GRCB_MONEY,GRAB_DATE) values (?,?,?,?) ";
		Object[] params = new Object[]{grabUsetId,redPackId,money,grabTime};
		
		MysqlUtil.update(sql, params);
		
	}

}
