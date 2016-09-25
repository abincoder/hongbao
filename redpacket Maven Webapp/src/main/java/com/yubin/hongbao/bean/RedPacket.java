package com.yubin.hongbao.bean;

public class RedPacket {
	//红包id
	public String redPacketId;
	//发红包用户id
	public String userId;
	//红包总金额
	public double  money;
	//红包总个数
	public int  size;
	//剩余红包数量
	public int    remainSize;
	//剩余红包金额
	public double  remainMoney;
	//抢红包用户id
	public String grabUserId;
	//抢红包用户获取金额
	public double grabMoney;
	//抢红包时间
	public String grabTime;
	//剩余有效时间
	public int time;
	//创建时间
    public String createTime;
		
	public RedPacket() {
			
    }
    
    public RedPacket(String redPacketId,String userId,double remainMoney,int  remainSize) {
    	
    	this.redPacketId = redPacketId;
    	this.userId = userId;
    	this.remainSize = remainSize;
    	this.remainMoney = remainMoney;
    }
		
	public String getGrabUserId() {
		return grabUserId;
	}


	public void setGrabUserId(String grabUserId) {
		this.grabUserId = grabUserId;
	}


	public double getGrabMoney() {
		return grabMoney;
	}


	public void setGrabMoney(double grabMoney) {
		this.grabMoney = grabMoney;
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
	
	public String getRedPacketId() {
		return redPacketId;
	}


	public void setRedPacketId(String redPacketId) {
		this.redPacketId = redPacketId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getGrabTime() {
		return grabTime;
	}

	public void setGrabTime(String grabTime) {
		this.grabTime = grabTime;
	}

}
