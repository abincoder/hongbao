package com.test.hongbao.alg;


public class RedPackage {
	int    remainSize;
	double  remainMoney;
    
    public RedPackage(int  remainSize,double  remainMoney) {
    	this.remainSize = remainSize;
    	this.remainMoney = remainMoney;
    }
    
    
    public int getRemainSize() {
		return remainSize;
	}

	public void setRemainSize(int remainSize) {
		this.remainSize = remainSize;
	}

	public double  getRemainMoney() {
		return remainMoney;
	}

	public void setRemainMoney(double  remainMoney) {
		this.remainMoney = remainMoney;
	}

}
