/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.controler;

import com.user.model.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sky
 */
public class LoginServlet extends HttpServlet {

    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
doPost(request,response);   
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        String uname=request.getParameter("uname");
        session.setAttribute("name", uname);
        String pass=request.getParameter("upass");
        String path=request.getContextPath() + "/";
        System.out.println(uname);
        System.out.println(pass);
        System.out.println(path);
        UserDAO udao= new UserDAO();
        boolean v=udao.login(uname, pass);
        if(uname.equals("Admin")&&pass.equals("Admin"))
        {
            RequestDispatcher rd=request.getRequestDispatcher("UserProfile.jsp");
            rd.forward(request, response);
            
        }
        else if(v)
        {
              RequestDispatcher rd=request.getRequestDispatcher("UserProfile.jsp");
            rd.forward(request, response);
        }
        else
        {
            request.setAttribute("msg","Resiter 1st...........");
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
            
            rd.forward(request, response);
            
        }
        
        

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
