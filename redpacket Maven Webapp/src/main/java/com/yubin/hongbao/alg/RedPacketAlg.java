package com.yubin.hongbao.alg;

import java.util.Random;

import com.yubin.hongbao.bean.RedPacket;



public class RedPacketAlg {
	public static double getRandomMoney(RedPacket _RedPacket) {
	    // remainSize 剩余的红包数量
	    // remainMoney 剩余的钱
	    if (_RedPacket.remainSize == 1) {
	        _RedPacket.remainSize--;
	        return (double) Math.round(_RedPacket.remainMoney * 100) / 100;
	    }
	    Random r     = new Random();
	    double min   = 0.01; //
	    double max   = _RedPacket.remainMoney / _RedPacket.remainSize * 2;
	    double money = r.nextDouble() * max;
	    money = money <= min ? 0.01: money;
	    money = Math.floor(money * 100) / 100;
	    _RedPacket.remainSize--;
	    _RedPacket.remainMoney -= money;
	    return money;
	}
}