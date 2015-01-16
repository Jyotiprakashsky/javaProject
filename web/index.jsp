<%-- 
    Document   : index
    Created on : 20 Dec, 2014, 10:50:42 AM
    Author     : sky
--%>
<%
String msg=(String)request.getAttribute("msg");
if(msg==null)
msg="";

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>JSP Page</title>
    <style type="text/css">
<!--
a {
	font-size: 16pc;
	color: #000066;
	font-weight: bold;
	font-family: Verdana, Arial, Helvetica, sans-serif;
}
a:visited {
	color: #000066;
	text-decoration: none;
}
a:hover {
	color: #000066;
	text-decoration: none;
}
a:active {
	color: #000099;
	text-decoration: none;
}
body,td,th {
	font-style: italic;
}
a:link {
	color: #000099;
	text-decoration: none;
}
.style1 {font-family: Arial, Helvetica, sans-serif}
.style3 {font-family: Arial, Helvetica, sans-serif; color: #0000FF; }
.style4 {
	color: #FFFFFF;
	font-weight: bold;
}
#Layer1 {
	position:absolute;
	width:200px;
	height:115px;
	z-index:1;
	left: 580px;
	top: 384px;
}
.style5 {color: #FFFFFF}
.style6 {font-family: Arial, Helvetica, sans-serif; color: #FFFFFF; }
-->
    </style>
	<script type="text/javascript">
	function hide()
	{

	document.getElementById("upload").style.visibility="hidden";
	
	//document.getElementById("upload").style.visibility="visible";
	
	}
	function show1()
	{

	document.getElementById("log").style.visibility="hidden";
	
	document.getElementById("upload").style.visibility="visible";
	
	}
	</script>
    </head>
    <body background="img/gelbuttoncenter.gif" onLoad="hide()">
        <table width="1010" border="0" align="center">
          <tr>
            <td colspan="2"><a href="">my&nbsp;&nbsp;&nbsp;</a><%=msg%></td>
          </tr>
		   <tr>
            <td colspan="2"><a href="">&nbsp;&nbsp;&nbsp;DRIVE&nbsp;</a></td>
          </tr>
        
        </table>
		
		<div id="log" style="border:#0066CC double;box-shadow:  21px 21px 21px 21px black;  position:fixed; width:400px; height:300px; left:760px; top:160px; background-color:#FFFFFF; opacity:0.7; ">
  <h1 align="center" class="style1"><span class="style3">Login</span>
    
    <hr></h1>
  <div align="center" style="position:relative; background-color:#3333CC; border:solid; clear:left; width:390px; height:120px;">
  <form action="LoginServlet">
  <table width="375" border="0" align="center">
    <tr>
      <td colspan="2"><h3 align="right" class="style5">UserName:</h3></td>
      <td width="144"><input name="uname" type="text" id="uname"></td>
    </tr>
    <tr>
      <td colspan="2"><h3 align="right" class="style6">Password:</h3></td>
      <td><input name="upass" type="password" id="upass"></td>
    </tr>
    <tr>
      <td width="96">&nbsp;</td>
      <td width="121"><input type="button" name="Submit2" value="SignUp" onClick="show1()"></td>
      <td><input type="submit" name="Submit" value="Login"></td>
    </tr>
  </table>
  </form>
  
  </div>
  
</div>
        <h1>&nbsp;</h1>
		<div  align="center" id="upload" style="opacity:0.8;box-shadow:  1px 21px 21px 21px black; border-radius:110px;background-color:#000000; top:10px; right:300px; width:600px; height:600px; border:ridge; position: fixed;">
		<div id="myDIV" align="center" style="  background-color:#0033FF;position:relative;border-radius:110px;top:-30px;right:-270px; width:40px; height:40px; " onMouseOver="document.getElementById('myDIV').style.opacity = '0.4';" onMouseOut="document.getElementById('myDIV').style.opacity = '1';">
		<h1 align="right" onClick="hide()" style="cursor:pointer;"> &times;&nbsp;</h1>
		</div>
		<form action="RegistrationServlet" method="post"  >
		  <div id="Layer1">
	      <h2><%=msg%></h2></div>
		
		  <table width="40" border="1"><hr>
            <tr>
              <td class="style4">UserName:</td>
              <td><input name="uname" type="text" id="uname" value=""></td>
            </tr>
            <tr>
              <td><div align="right"><span class="style4"> UserPass:</span></div></td>
              <td><input name="upass" type="text" id="upass" value=""></td>
            </tr>
            <tr>
              <td><div align="right"><span class="style4">DOB:</span></div></td>
              <td><input name="dob" type="text" id="dob" value=""></td>
            </tr>
            <tr>
              <td><div align="right"><span class="style4">UserKey:</span></div></td>
              <td><input name="ukey" type="text" id="ukey" value=""></td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td><input type="submit" name="Submit3" value="Resiter"></td>
            </tr>
          </table>
		</form>
    </div>
	
    </body>
</html>
