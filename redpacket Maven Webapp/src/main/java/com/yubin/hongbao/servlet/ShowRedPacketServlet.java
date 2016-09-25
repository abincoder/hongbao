package com.yubin.hongbao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yubin.hongbao.common.RedisUtil;
import com.yubin.hongbao.common.constant.RPDb;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ShowRedPacketServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try{  
			//从redis取出所有红包key
		    Set<String> redPackets = RedisUtil.keysLike("red_*");
			
			List<Map<String,Object>> jsonList = new ArrayList<>();
			//加入处理结果success?fail?
		    Map<String,Object> jsonMap = new HashMap<String,Object>();
		    jsonMap.put("isSuc", true);
		    jsonMap.put("des", "");
		    jsonList.add(jsonMap);
		    
		    //依次取出各个红包明细信息
		    if(redPackets != null) {
				for(String redpacketName:redPackets) {
					String userId = RedisUtil.hget(redpacketName, RPDb.R_RED_PACKET_USER);
					String money = RedisUtil.hget(redpacketName, RPDb.R_RED_PACKET_MONEY);
					String packetNum = RedisUtil.hget(redpacketName, RPDb.R_RED_PACKET_NUMS);
					long time = RedisUtil.Ttl(redpacketName);
					
					jsonMap = new HashMap<String,Object>();
					jsonMap.put("userId", userId);
				    jsonMap.put("redpacketName", redpacketName);
				    jsonMap.put("money", money);
				    jsonMap.put("packetNum", packetNum);
				    jsonMap.put("time", time);
				    jsonList.add(jsonMap);
				}
		    }
		    
			
		    response.setContentType("text/html;charset=utf-8");  
		    PrintWriter out = response.getWriter();  
		    
		    JSONArray json = JSONArray.fromObject(jsonList);
		    out.write(json.toString());
		    System.out.println(json.toString());
		}catch(Exception ex){  
		    ex.printStackTrace();  
		}  


	}

	
	public void init() throws ServletException {
		System.out.println(" ShowRedPacketServlet is init");
	}

}
