/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.controler;

import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import java.io.PrintWriter;
import java.util.Enumeration;

import com.oreilly.servlet.MultipartRequest;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.*;

/**
 *
 * @author sky
 */
public class UploadServlet extends HttpServlet {
     public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
    {
        HttpSession session=request.getSession(false);           
        String name=(String)session.getAttribute("name");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        
        final int permitedSize = 20485760;  //~ 10 MB in bytes

        try{
            String uploadDirectoryName = name;//getServletContext().getInitParameter("uploadDirectory");
            //System.out.println(uploadDirectoryName);  // files
            String uploadPath = getServletContext().getRealPath(uploadDirectoryName + "//");
                                                                                      
            System.out.println(uploadPath);
              session.setAttribute("uploadPath",uploadPath);
            File f = new File(uploadPath);
            if(f.exists()) {
                // do nothing
               
            }else {
               
                f.mkdir();
            } 

           // MultipartRequest multipartRequest = new MultipartRequest(request, uploadPath);  // To uplaod a file of any size
              MultipartRequest multipartRequest = new MultipartRequest(request, uploadPath,permitedSize);
  System.out.print("........................");
            String fileName = multipartRequest.getOriginalFileName("file");  //  file => input field name
     
            System.out.println(fileName);
     
     
            request.setAttribute("msg",fileName + "  file saved.....");
            RequestDispatcher rd = request.getRequestDispatcher("UserProfile.jsp");
            rd.forward(request, response);
     

        }catch (Exception e) {e.printStackTrace();}
    }
}