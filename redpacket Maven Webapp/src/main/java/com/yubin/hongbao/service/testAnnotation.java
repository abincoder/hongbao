package com.yubin.hongbao.service;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.yubin.hongbao.service.impl.GenRedPacketServiceImpl;

@Service("testAnnotation")
public class testAnnotation {
	//@Resource(name ="genRedPacketServiceImpl")
	//protected   GenRedPacketServiceImpl genRedPacketServiceImpl;
	
	protected static  GenRedPacketService genRedPacketService;
	
	
	public void test() {
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//GenRedPacketService genRedPacketService = (GenRedPacketService) ctx.getBean("GenRedPacketServiceImpl");
		
		if(genRedPacketService == null) {
			System.out.println("nullnull");
		}else {
			System.out.println("not null");
		}
	}


	public GenRedPacketService getGenRedPacketService() {
		return genRedPacketService;
	}


	public void setGenRedPacketService(GenRedPacketService genRedPacketService) {
		this.genRedPacketService = genRedPacketService;
		if(genRedPacketService!=null) {
			//System.out.println("666666666666666666666666666666666666666666666666666666666666");
		}
	}


	/*public GenRedPacketServiceImpl getGenRedPacketServiceImpl() {
		return genRedPacketServiceImpl;
	}


	public void setGenRedPacketServiceImpl(
			GenRedPacketServiceImpl genRedPacketServiceImpl) {
		this.genRedPacketServiceImpl = genRedPacketServiceImpl;
		if(genRedPacketServiceImpl!=null) {
			System.out.println("666666666666666666666666666666666666666666666666666666666666");
		}
	}*/


}
