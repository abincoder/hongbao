/**
 * 
 */

$(document).ready(showTime);
function showTime() {
	var date = new Date();
	//$("#time").attr("style","color:red").html(date);
	$("#time").css("background-color","red").html(date);
	setTimeout("showTime()", 1000)
}

$(document).ready(function() {
	$("#timebutton").click(function() {
		$("#time").hide();
	});
});

$(document).ready(function() {
	var text = $("<p></p>").text("233333333");
	$("body").append(text);
});
