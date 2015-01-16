<%-- 
    Document   : filetest
    Created on : 21 Dec, 2014, 5:13:47 PM
    Author     : sky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.File"%>
<html>
<body>
    <%
        String sourceDirectory = "D:\\asa";
        File f = new File(sourceDirectory);     
        File[] fileObjects = f.listFiles();
    %>
    <UL>
        <%
            for (int i = 0; i < fileObjects.length; i++)
            {
                if (!fileObjects[i].isDirectory())
                {%>
                    <LI><a href="<%=fileObjects[i].getAbsolutePath()%>" target="_blank"><%=fileObjects[i].getName()%></a>
                        &nbsp;&nbsp;&nbsp;&nbsp; 
                        (<%=Long.toString(fileObjects[i].length())%>    bytes long) 
                <%}
            }%>
    </UL>
</body>
</html>
