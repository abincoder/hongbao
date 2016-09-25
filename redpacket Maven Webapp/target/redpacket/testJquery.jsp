<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.yubin.hongbao.common.RedisUtil,
				 redis.clients.jedis.Jedis,
				 com.yubin.hongbao.service.GenRedPacketService,
				 com.yubin.hongbao.common.*,
				 com.yubin.hongbao.bean.RedPacket,
				 java.util.* " %>    
<%
	
%>
<html>
<head>
<script src="js/jquery.js"></script>
<script src="js/testjquery.js"></script>

</head>
<body">
<h2>抢红包</h2>
<h1 id = "time">显示时间</h1>
<button id ="timebutton" >开关时间</button>
</body>
</html>
