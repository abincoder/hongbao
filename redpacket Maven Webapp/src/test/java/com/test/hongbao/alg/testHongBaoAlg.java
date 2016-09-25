package com.test.hongbao.alg;

import java.math.BigDecimal;
import java.util.Random;

public class testHongBaoAlg {
	
	public static double getRandomMoney(RedPackage _redPackage) {
	    // remainSize 剩余的红包数量
	    // remainMoney 剩余的钱
	    if (_redPackage.remainSize == 1) {
	        _redPackage.remainSize--;
	        return (double) Math.round(_redPackage.remainMoney * 100) / 100;
	    }
	    Random r     = new Random();
	    double min   = 0.01; //
	    double max   = _redPackage.remainMoney / _redPackage.remainSize * 2;
	    double money = r.nextDouble() * max;
	    money = money <= min ? 0.01: money;
	    money = Math.floor(money * 100) / 100;
	    _redPackage.remainSize--;
	    _redPackage.remainMoney -= money;
	    return money;
	}
	
	
	public static void main(String[] args) {
		RedPackage redPackage = new RedPackage(100000,10000000);
		//double sumMoney = 0;
		BigDecimal sumMoney = new BigDecimal("0");
		int n = 1;
		double max = 0;
		while(redPackage.getRemainSize()>0){
			double money = getRandomMoney(redPackage);
			System.out.println("第["+(n++)+"]个人抢到红包["+money+"]元");
			sumMoney = sumMoney.add(new BigDecimal(String.valueOf(money)));
			if(money >max) {
				max = money;
			}
		}
		System.out.println("SumMoney= "+sumMoney);
		System.out.println("Max= "+max);
	}
}
