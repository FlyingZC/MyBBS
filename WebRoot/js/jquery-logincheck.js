$(function(){
	// 为看不清楚绑定事件  
	$("#randImage").click(function(){  
		$("#randImage").attr("src", 'getImageCode.do?x='+Math.random());  
	});  
	
	// 为验证码绑定click与mouseover  
	$("#randImage").mouseover(function(){  
		$(this).css("cursor", "pointer");  
	});  
	
	// 登录验证  
	$("#loginBtn").click(function(){  
		// 做表单输入校验  
		var userId = $("#username");  
		var password = $("#password");  
		var code = $("#imageCode");  
		var msg = "";  
		if ($.trim(userId.val()) == ""){  
			msg = "用户名不能为空！";  
			userId.focus();  
			if (msg!= ""){  
				alert(msg);  
			}
			return false;
		}/*else if (!/^\w{5,20}$/.test($.trim(userId.val()))){  
			msg = "用户名格式不正确！";  
			userId.focus();  
		}*/else if ($.trim(password.val()) == ""){  
			msg = "密码不能为空！";  
			password.focus();  
			if (msg!= ""){  
				alert(msg);  
			}
			return false;
		}/*else if (!/^\w{6,20}$/.test($.trim(password.val()))){  
			msg = "密码格式不正确！";  
			password.focus();  
		}*/else if ($.trim(code.val()) == ""){  
			msg = "验证码不能为空！";  
			code.focus();  
			if (msg!= ""){  
				alert(msg);  
			}
			return false;
		}else if (!/^[0-9a-zA-Z]{4}$/.test($.trim(code.val()))){  
			msg = "验证码格式不正确！";  
			code.focus();  
			if (msg!= ""){  
				alert(msg);  
			}
			return false;
		}  
	});  
	
	// 为document绑定onkeydown事件监听是否按了回车键  
	$(document).keydown(function(event){  
		if (event.keyCode === 13){ // 按了回车键  
			$("#loginBtn").trigger("click");  
		}  
	});  
});  

