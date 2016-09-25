package com.yubin.hongbao.service;

import com.yubin.hongbao.bean.RedPacket;

public interface GenRedPacketService {
	
	
	/**
	 * 生产一个红包
	 * @param redPacket 红包信息
	 * @return	true/false
	 */
	public boolean genRedPacket(RedPacket redPacket);
	
	
	/**
	 * 查询 红包剩余个数
	 */
	public int redPacketRemainSize(String redPacketName);
	
	/**
	 * 查询 红包剩余金额
	 */
	public double redPacketRemainMoney(String redPacketName);
	
	
	/**
	 * 查询已抢红包金额
	 * @param redPacketName 红包id
	 * @param userId 用户id
	 * @return
	 */
	public double queryRedPacketMoney(String redPacketName,String userId);
	
	/**
	 * 获取一个红包
	 * * @param redPacketName 红包id
	 * * @param userId 用户id
	 * @return
	 */
	public double grabRedPacket(String redPacketName,String userId);
}
