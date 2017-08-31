<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome page!</title>
<%
			String username = (String)request.getSession().getAttribute("username");
		%>
<style>
body{
	margin:0;
}
.head{
	height:50px;
	width:100%;
	background-color:#00EC00;
}
.logo{
	color:red;
	font-style:Italic;
	font-weight:bold;
	font-size:25px;
	line-height:50px;
	margin:0 20px 0 20px;
}
.search{
				height:100%;
			}

#userInfo{
	float:right;
	line-height:50px;
	margin-right:20px;
}
#shadowdiv{
	position:absolute;
	width:100%;
	height:100%;
	top:0;
	left:0;
	z-index:2;
	background-color:#E1C4C4;
	opacity:0.5;
	display:none;
}
#login{
	position:absolute;
	z-index:3;
	width:400px;
	height:300px;
	top:50%;
	left:50%;
	margin:-110px 0 0 -200px;
	background-color:white;
	box-shadow:10px 10px 5px #C4E1E1;
	display:none;
	padding:20px;
}
.closespan{
	display:block;
	float:right;
	border:1px solid black;
	margin-right:7px;
	border-redius:15px;
}
#login label{
				height:50px;
				line-height:50px;
				font-size:20px;
				width:20%;
				display:inline-block;
			}
			#login input{
				font-size:18px;
				width:75%;
				display:inline-block;
				outline:none;
				border:none;
				border-bottom:1px solid red;
			}
			#login span{
				display:block;
			}
			
</style>
</head>
<body>

	<%-- <h1>zzz This is my Welcome Page...zzz</h1>
	<p>
		Total have <%=request.getAttribute("cnt") %> data...
	</p>  --%>
	
	<div class="head">
	<span class="logo">Welcome</span>
	<span class="search">
	<input type="text" name="content" style="width:30%;height:30px;"/>
	<input type="submit" value="Search"/>
	</span>
	<span id="userInfo">
	<%if(username == null || "".equals(username)){ %>
		<a href="javascript:register()">Sign up</a>&nbsp;||&nbsp;<a href="javascript:login()">Sign in</a>
		<%}else{ %>
				<a href=""><%=username %></a>
			<%} %>
	</span>
	</div>
	
	
	<div id="shadowdiv" >
	</div>
	<form action="<%=request.getContextPath() %>/login" method="post">
	<div id="login">
		<span class="closespan" onclick="clearshadow()">&nbsp;X&nbsp;</span>
		<span  style="margin-top:50px;">
		<label for="username">Name</label>
		<input type="text" name="username"/>
		</span>
		<span>
		<label for="password">Password</label>
		<input type="password" name="pw"/>
		</span>
		<span style="margin-top:20px;">
			<a href="javascript:submitlogin()" class="submita">Sign in</a>
		</span>
		
	</div>
	</form>
</body>
<script>
 function login(){
	 
	 document.getElementById("shadowdiv").style.display="block";
	 document.getElementById("login").style.display="block";
 }
	function clearshadow(){
		document.getElementById("shadowdiv").style.display = "none";
		document.getElementById("login").style.display = "none";
		
	}
	function submitlogin(){
		
		document.forms[0].submit();
	}

</script>
</html>