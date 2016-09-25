package com.yubin.hongbao.service.dao;

import com.yubin.hongbao.bean.RedPacket;

public interface GenRedPacketDao {
	
	/*
	 *持久红包数据 
	 */
	public void persistRedPacket(RedPacket redPacket);
	
	/*
	 *持久用户抢红包数据 
	 */
	public void persistGrabRedPacket(RedPacket redPacket);
}
