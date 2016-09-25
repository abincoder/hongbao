<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>" > 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$.ajax({
		async:true,
		cashe:false,
		type:"POST",
		dataType:"json",
		url:"servlet/ShowRedPacketServlet",
		//error:function(json){alert(json);},
		error:function(XMLHttpRequest, textStatus, errorThrown) {
				 alert(XMLHttpRequest.status);
				 alert(XMLHttpRequest.readyState);
				 alert(textStatus);
			   },
		timeout:10000,
		success:function(json) {
			 if(json[0].isSuc){
				for(var i =1;json[i];i++) {
					var text = $("<p></p>").text("用户"+json[i].userId+"发的红包"
							+json[i].redpacketName+",剩余"+json[i].money+"元, 剩余"
							+json[i].packetNum+"个,剩余时间"+json[i].time+"秒");
					var name =json[i].redpacketName;
					//alert(name);
					var btn = "<button type=\"button\"  onclick=grabRedPacket(\""+name+"\")>抢红包</button>";
					$("#div2").append(text);
					$("#div2").append(btn);
			    }
			}else {
				alert(json[0].des);
			} 
		}
	});	
} );

function validateForm(form) {
	for(var i=0;i<form.length;i++) {
		if(form[i].type == "text") {
			//alert(form.elements[i].name);
			if(!form.elements[i].value){
				alert(form.elements[i].name+"\'s values is null");
				return false;
			}
		}
	} 
	return true;
} 

function grabRedPacket(redpacketName) {
	var ranNum = Math.random();
	var grabUserId = Math.ceil(ranNum*10000000000);
	//alert("servlet/GrabRedPacketServlet?grabUserId = "+grabUserId+"&redPacketName="+redpacketName);
	window.location.href="servlet/GrabRedPacketServlet?grabUserId="+grabUserId+"&redPacketName="+redpacketName;
}

</script>
</head>

<body>
<div id="div1">
	<form id="form1" action="servlet/GenRedPacketServlet" method="post" onSubmit ="return validateForm(this)" >
	 &nbsp用户名:<input type="text"  name ="userid" /></br>
		红包金额:<input type="text"  name ="money" /></br>
		红包个数:<input type="text"  name ="num" /></br>
		有效时间:<input type="text"  name ="expiretime" /></br>
		<input type="submit" value = "发红包" />
		<input type ="button" value="刷新红包列表" 
		onclick="javascrtpt:window.location.href='/redpacket/DisForward?pageid=redpacket.jsp'"/></br>
		<!-- <a href="/redpacket/DisForward?pageid=redpacket.jsp"><input type ="button" value="刷新页面" /></a></br> -->
	</form>
</div>  
<div id="div2"></div>  
</body>
</html>
