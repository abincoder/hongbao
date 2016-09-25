<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.yubin.hongbao.common.RedisUtil,
				 redis.clients.jedis.Jedis,
				 com.yubin.hongbao.service.GenRedPacketService,
				 com.yubin.hongbao.common.*,
				 com.yubin.hongbao.bean.RedPacket,
				 com.yubin.hongbao.service.testAnnotation,
				 java.util.* " %>    
<%
	/* testAnnotation test = new testAnnotation();
test.test(); */
%>
<html>
<script src="js/jquery.js"></script>
<script type="text/javascript">

</script>
<body>
<h2>抢红包</h2>
<a href="/redpacket/DisForward?pageid=redpacket.jsp">抢红包链接</a>

</body>
</html>
