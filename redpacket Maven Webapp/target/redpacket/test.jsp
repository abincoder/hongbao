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
<script src = "js/test.js"></script>

<script>
document.write(location.href);
var allc = "全局变量";

function refreshTime() {
 	var x = document.getElementById("time");
	var date  = new Date();
	x.innerHTML = date;
	
	setTimeout("refreshTime()",1000);
		
} 


function testWrite() {
	document.write("<p>My First \
			JavaScript</p>");
	document.write("<h1>This is a heading</h1>");
	document.write("<p>This is a paragraph</p>");
	
	var name = 'hahaha';
	var name;
	document.write("<p>name = "+name+"</p>")
}

function testVar() {
	var name = 'hahaha';
	var name;
	document.write("<p>name = "+name+"</p>");
	
	var arrs = new Array("wen","yu","bin");
	document.write("<p>arr[0] = "+arrs[0]+"</p>");
	document.write("<p>arr[1] = "+arrs[1]+"</p>");
	document.write("<p>arr[2] = "+arrs[2]+"</p>");
	document.write("<p>arr[3] = "+arrs[3]+"</p>");
	
	
	var person = {name:"wendy",sex:"boy",age:"24"};
	document.write("<p>person.name = "+person.name+"</p>");
	document.write("<p>person.sex = "+person.sex+"</p>");
	document.write("<p>person.age = "+person.age+"</p>");
	document.write("<p>person[age] = "+person["age"]+"</p>");
}


function testObject() {
	ob = new Object();
	ob.name = "object";
	ob.num = 10;
	
	
	document.write("<p>ob.name = "+ob.name+"</p>");
	document.write("<p>ob.name.toUpperCase() = "+ob.name.toUpperCase()+"</p>");
	
	
}

function testFunction() {
	var arrs = new Array("wen","yu","bin");
	
	for(var i = 0; i < arrs.length; i++) {
		document.write("<p>"+arrs[i]+"</p>");
	}
	
	
	for(var i =0;arrs[i];i++) {
		document.write("<p>"+arrs[i]+"</p>");
	}
	
	var i =0;
	while(arrs[i]) {
		document.write("<p>"+arrs[i++]+"</p>");
	}
}

function testTryCatch(){
	try {
		throw "i am javascript try-catch";
	} catch (err) {
		document.write("<p>"+err+"</p>");
		return;
	}
	document.write("<p>"+a+"</p>");
}

function validate_required(filed,msg) {
	with(filed) {
		if(value == null | value == "") {
			alert(msg);
			return false;
		}else {
			return true;
		}
	}
	
}

function validate_form(thisform) {
	with(thisform) {
		if(validate_required(email,"email field must not be empty!!")==false) {
			email.focus();
			return false;
		}
	}
}

function testGetHtmlMembers() {
	var x = document.getElementById("div1");
	var s = x.getElementsByTagName("p");
	alert(s[0].innerHTML);
}

function upperCase(test){
	test.value = test.value.toUpperCase();
}

function testAppendNode() {
	
	
	var element = document.createElement("p");
	var node = document.createTextNode("这是一个新的文本");
	element.appendChild(node);
	
	var x = document.getElementById("div3");
	x.appendChild(element);
	
}

function testRegExp() {
	var str = "this is javascript regexp!!";
	document.write(str+"<br/>");
	var reg = new RegExp("e");
	document.write("new RegExp(\"e\")  test():"+reg.test(str)+"<br/>");
	
	reg = new RegExp("d");
	document.write("new RegExp(\"d\")  test():"+reg.test(str)+"<br/>");
	
	reg = new RegExp("e");
	document.write("new RegExp(\"e\")  exec():"+reg.exec(str)+"<br/>");
	
	reg = new RegExp("e","g");
	document.write("new RegExp(\"e\",\"g\")  exec():");
	do {
		result = reg.exec(str);
		document.write(result);
	}while(result!=null)
	document.write("<br/>");
	
	reg = new RegExp("a");
	document.write("new RegExp(\"a\")  test():"+reg.test(str)+"<br/>");	
	reg.compile("d");
	document.write("new RegExp(\"a\") reg.complie(\"d\") test():"+reg.test(str)+"<br/>");	
	
}

function testTimeMethod() {
	setTimeout("alert(\"hahah\")", 2000);
}

</script>
</head>
<body onload = "refreshTime()">
<h2>抢红包</h2>

<h1 id="time">北京时间:null</h1>

<button type="button"  value="2333" onclick="test()"> 测试js相对路径引用</button>
<span id="6666" >555555555</span></br>

<button type="button"  value="2333" onclick="testWrite()"> 测试document.write,覆盖整个页面</button></br>


<button type="button"  value="" onclick="testVar()"> 测试javascript变量</button></br>


<button type="button"  value="" onclick="testObject()"> 测试javascript对象变量\方法</button></br>


<button type="button"  value="" onclick="testFunction()"> 测试javascript方法</button></br>


<button type="button"  value="" onclick="testTryCatch()"> 测试javascript的try catch</button></br>

<p>测试表单校验</p>
<form action="success.html" onsubmit="return validate_form(this)" method="post">
Email: <input type="text" name="email" onchange = "upperCase(this)" size="30">
<input type="submit" value="Submit"> 
</form>

<div id ="div1">
<p>div 里面的文本</p>
</div>
<button type="button"  value="" onclick="testGetHtmlMembers()"> 测试getElementById</button></br>


<div id ="div2">
<p>这是一个文本</p>
<div id ="div3"></div>
<button type="button"  value="" onclick="testAppendNode()"> 测试appendNode</button></br>
</div>

<button type="button"  value="" onclick="testRegExp()"> 测试javascript正则表达式</button></br>

<button type="button"  value="" onclick="testTimeMethod()"> 测试时间函数</button></br>
</body>
</html>
