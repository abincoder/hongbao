package com.yubin.hongbao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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

/*
 *抢红包 
 */
@Service("GrabRedPacketServlet")
public class GrabRedPacketServlet extends HttpServlet {
	
	@Resource(name ="genRedPacketServiceImpl")
	protected  GenRedPacketService genRedPacketService;
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try{  
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			
			String redPacketName =  request.getParameter("redPacketName");
			String grabUserId = request.getParameter("grabUserId");
			//查询抢红包记录
			double grabMoney = genRedPacketService.queryRedPacketMoney(redPacketName, grabUserId);
			if(grabMoney==0) {
				//用户没有抢红包记录,调用抢红包接口
				grabMoney = genRedPacketService.grabRedPacket(redPacketName, grabUserId);
				if(grabMoney==0) {
					//红包已抢完
					String msg = "红包已抢完啦!";
					out.println("<script>alert('"+msg+"');window.location.href='/redpacket/DisForward?pageid=redpacket.jsp';</script>");
					out.flush();
					out.close(); 
				}else {
					//抢红包成功,返回...
					String msg = "用户"+grabUserId+"抢到红包"+grabMoney+"元";
					out.println("<script>alert('"+msg+"');window.location.href='/redpacket/DisForward?pageid=redpacket.jsp'</script>");
					out.flush();
					out.close(); 
				}
			}else {
				//重复抢红包 ,返回提示
				String msg = "用户"+grabUserId+"已抢到红包"+grabMoney+"元,红包只能抢一个哦!";
				out.println("<script>alert('"+msg+"');</script>");
				out.flush();
				out.close(); 
			}
		    
		    //request.getRequestDispatcher("/WEB-INF/jsp/redpacket.jsp").forward(request, response);
		}catch(Exception ex){  
		    ex.printStackTrace();  
		}  


	}
	
}
