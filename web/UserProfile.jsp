<%-- 
    Document   : UserProfile
    Created on : 20 Dec, 2014, 4:48:25 PM
    Author     : sky
--%>
<%@page import="java.io.File"%>
<%@page import="java.util.jar.Attributes.Name"%>
<%@page import="java.io.PrintWriter"%>
<%
        String sourceDirectory = (String)session.getAttribute("uploadPath");
        if(sourceDirectory==null)
                      sourceDirectory="c:\\"; 
        File f = new File(sourceDirectory);     
        File[] fileObjects = f.listFiles();
    %>
<%
String uploadPath="ftp://"+(String)session.getAttribute("uploadPath") + "/";
//uploadPath=uploadPath.replace("\\","/"  );
System.out.println(uploadPath);

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
.style2 {color: #0000FF;
cursor:pointer;
}
.style3 {color: #FF0000}
a {
	font-size: 9mm;
	color: #000000;
}
a:link {
	color: #000066;
	text-decoration: none;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: underline;
	color: #990000;
}
a:active {
	text-decoration: none;
}
#Layer1 {
	position:absolute;
	width:109px;
	height:34px;
	z-index:1;
	left: 1128px;
	top: 67px;
}
-->
        </style>
		<script type="text/javascript">
		function hideUploadWindow(id)
{
	document.getElementById(id).style.backgroundColor = 'green';
	document.getElementById(id).style.boxShadow="10px 20px 30px blue";
	//document.getElementById("myDiv2").style.backgroundColor = 'green';
	//document.getElementById("myDiv3").style.backgroundColor = 'green';
	//document.getElementById("myDiv4").style.backgroundColor = 'green';
}
function showUploadWindow(id)
{
	document.getElementById(id).style.backgroundColor="#00CCFF";
	document.getElementById(id).style.boxShadow="";
	//document.getElementById("myDiv2").style.backgroundColor="#00CCFF";
	//document.getElementById("myDiv3").style.backgroundColor="#00CCFF";
	//document.getElementById("myDiv4").style.backgroundColor="#00CCFF";
}
function upload()
{
document.getElementById("upload").style.visibility="hidden";
//upload1
document.getElementById("upload1").style.visibility="hidden";

}

function vupload()
{
document.getElementById("upload").style.visibility="visible";

}
function vhome()
{
document.getElementById("upload1").style.visibility="visible";

}
function Syncroniz()
{
document.f1.method="post";
document.f1.action="SyncronizeServlet";
document.f1.submit();
}
		</script>
</head>
    <body background="img/wv_home_bkgnd_photo.jpg">
    <a href="SyncronizeServlet">link</a>
    <div id="Layer1">
      <font color="#FFFFFF"><h2 align="center" ><a href="#" >Logout</a></h2></font>
    </div>
        <table width="919" border="0" align="center">
          <tr>
      <td width="203"><div style=" background-color:#00CC99;border-radius:26px;" id="1" onMouseOver="hideUploadWindow('1')" onMouseOut="showUploadWindow('1')" onClick="vhome()"><h2 align="center" class="style2" >Home</h2></div></td>
   <td width="272"><div id="2" style="background-color:#00CC99;border-radius:26px;"onMouseOver="hideUploadWindow('2')" onMouseOut="showUploadWindow('2')" onClick="vupload()"><h2 align="center" class="style2">Upload New </h2></div></td>
   <td width="222"><form name="f1"><div id="3"style="background-color:#00CC99;border-radius:26px;"onMouseOver="hideUploadWindow('3')" onMouseOut="showUploadWindow('3')" onClick="Syncroniz()">
     <h2 align="center" class="style2">Syncronize with pc </h2>
   </div></form></td>
 <td width="194"><div id="4" style="background-color:#00CC99; border-radius:24px;"onMouseOver="hideUploadWindow('4')" onMouseOut="showUploadWindow('4')"><h2 align="center" class="style2">Delete And Exit </h2></div></td>
          </tr>
          <tr>
            <td colspan="4"><div align="center" class="style3">
              <h1><%=msg%></h1>
            </div></td>
          </tr>
        </table>
        <h1>&nbsp;</h1>
		<div  align="center" id="upload" style=" overflow:scroll;border-radius:110px;background-color:#FFFFFF; right:300px; width:600px; height:400px; border:ridge; position: fixed;">
		<div id="myDIV" align="center" style=" background-color:#0033FF;position:relative;border-radius:110px;top:-20px;right:-270px; width:40px; height:40px; " onMouseOver="document.getElementById('myDIV').style.opacity = '0.4';" onMouseOut="document.getElementById('myDIV').style.opacity = '1';">
		<h1 align="right" onClick="upload()" style="cursor:pointer;"> &times;&nbsp;</h1>
		</div>
		<form action="UploadServlet" method="post" enctype="multipart/form-data" >
		
	      <div align="center">
	        <table width="40" border="10">
	          <tr>
	            <td><input name="file" type="file"></td>
      </tr>
	          <tr>
	            <td><input type="submit" name="Submit" value="Upload"></td>
      </tr>
            </table>
	      </div>
		</form>
    </div>
	
	
	
	<div  align="center" id="upload1" style=" overflow:scroll;border-radius:110px;background-color:#FFFFFF; right:300px; width:700px; height:400px; border:ridge; position: fixed;">
		<div id="myDIV1" align="center" style=" background-color:#0033FF;position:relative;border-radius:110px;top:-20px; right:-310px; width:40px; height:40px; " onMouseOver="document.getElementById('myDIV1').style.opacity = '0.4';" onMouseOut="document.getElementById('myDIV1').style.opacity = '1';">
		<h1 onClick="upload()" style="cursor:pointer;">&nbsp;&times;&nbsp;</h1>
		</div>
		<form action="DeleteFileServlet" method="post">
		<UL style="cursor:pointer; display:table; azimuth:far-left; size:100px; ">
        <%
            for (int i = 0; i < fileObjects.length; i++)
            {
                if (!fileObjects[i].isDirectory())
                {%>
                    <LI><input name="chk1" type="checkbox" value="<%=fileObjects[i].getAbsolutePath()%>"<%=fileObjects[i].getName()%>"><a   href="file:///<%=fileObjects[i].getAbsolutePath()%>"><%=fileObjects[i].getName()%></a>
                        &nbsp;&nbsp;&nbsp;&nbsp; 
						   &nbsp;&nbsp;&nbsp;&nbsp; 
						      &nbsp;&nbsp;&nbsp;&nbsp; 
                        (<%=Long.toString(fileObjects[i].length())%>    bytes) 
                <%}
            }%> &nbsp;&nbsp;&nbsp;&nbsp; 
						      &nbsp;&nbsp;&nbsp;&nbsp;
    </UL>
	<input name="" type="submit" value="Delete from Drive">
	</form>
    </div>
	
	
	
    </body>
</html>
