/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.controler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sky
 */
public class SyncronizeServlet extends HttpServlet {
    
    
String SAVE_DIR; //= "D:/Test/Upload/";
	static final int BUFFER_SIZE = 4096;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
{ 
doPost(request,response);
}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
        HttpSession session=request.getSession(false); 
                 String SAVE_DIR1="C:/sky/";//+ (String)session.getAttribute("name") + "/";
                  SAVE_DIR= SAVE_DIR1;
               // String SAVE_DIR="D:/javaWEbProject/"+(String)request.getContextPath() +"/" +(String)session.getAttribute("name") + "/";
        //String SAVE_DIR="D:/javaWEbProject/mydrive/build/web/" + (String)session.getAttribute("name") + "/";
                System.out.println(SAVE_DIR);
                response.setContentType("text/html");        
               // PrintWriter out=response.getWriter();
                         response.getWriter().println(SAVE_DIR);      
		// Gets file name for HTTP header

		String fileName = request.getHeader("fileName");
                if(fileName==null)
                { fileName="dummy";}
                
		File saveFile = new File(SAVE_DIR + fileName);
		System.out.println(SAVE_DIR+ fileName);
		// prints out all header values
                /*
		System.out.println("===== Begin headers =====");
		Enumeration<String> names = request.getHeaderNames();
		while (names.hasMoreElements()) {
			String headerName = names.nextElement();
			System.out.println(headerName + " = " + request.getHeader(headerName));			
                        response.getWriter().println("\n"+headerName + " = " + request.getHeader(headerName));
		}
		System.out.println("===== End headers =====\n");
*/		
		// opens input stream of the request for reading data
		InputStream inputStream = request.getInputStream();
		
		// opens an output stream for writing file
		FileOutputStream outputStream = new FileOutputStream(saveFile);
		
		byte[] buffer = new byte[BUFFER_SIZE];
		int bytesRead = -1;
		System.out.println("Receiving data...");
                response.getWriter().println("Receiving data...");
		
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, bytesRead);
		}
		
		System.out.println("Data received.");
                response.getWriter().println("Data received.");
		outputStream.close();
		inputStream.close();
		
		System.out.println("File written to: " + saveFile.getAbsolutePath());
		response.getWriter().println("\nFile written to: " + saveFile.getAbsolutePath());
		// sends response to client
		response.getWriter().println("\n....UPLOAD DONE");
                response.getWriter().print("<a href='UserProfile.jsp'><h2>Back to home</h2></a>");
        
	}
    
    
}