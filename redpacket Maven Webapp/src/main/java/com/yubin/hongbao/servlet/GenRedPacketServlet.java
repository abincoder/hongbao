package com.yubin.hongbao.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.yubin.hongbao.bean.RedPacket;
import com.yubin.hongbao.common.AnnotationUtil;
import com.yubin.hongbao.common.DateTool;
import com.yubin.hongbao.service.GenRedPacketService;
import com.yubin.hongbao.service.impl.GenRedPacketServiceImpl;

@Service("GenRedPacketServlet")
public class GenRedPacketServlet extends HttpServlet {
	
	@Resource(name ="genRedPacketServiceImpl")
	protected  GenRedPacketService genRedPacketService;
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try{  
			RedPacket redPacket = new RedPacket();
			
		    String userid = request.getParameter("userid");
		    double money =Double.valueOf( request.getParameter("money") );
		    int num = Integer.valueOf(request.getParameter("num") );
		    int expiretime = Integer.valueOf(request.getParameter("expiretime"));
		    String redPacketName = getRedPacketName(userid);
		    redPacket.setUserId(userid);
		    redPacket.setMoney(money);
		    redPacket.setSize(num);
		    redPacket.setRedPacketId(redPacketName);
		    redPacket.setCreateTime(DateTool.getDateTime());
		    redPacket.setTime(expiretime);
			
		    genRedPacketService.genRedPacket(redPacket);
		    
		    request.getRequestDispatcher("/WEB-INF/jsp/redpacket.jsp").forward(request, response);
		}catch(Exception ex){  
		    ex.printStackTrace();  
		}  


	}

	
	private String getRedPacketName(String userid) {
		String head = "red_";
		String time = DateTool.getTinyTime();
		return head.concat(userid).concat(time);
	}


	public void init() throws ServletException {
		//this.genRedPacketService = (GenRedPacketService) AnnotationUtil.getBean("GenRedPacketServiceImpl");
	}
	

}
