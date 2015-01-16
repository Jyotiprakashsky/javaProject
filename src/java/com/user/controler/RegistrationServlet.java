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

/**
 *
 * @author sky
 */
public class RegistrationServlet extends HttpServlet {

   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String uname=request.getParameter("uname");
        String upass=request.getParameter("upass");
         String dob=request.getParameter("dob");
          String ukey=request.getParameter("ukey");
          
          UserDAO udao=new UserDAO();
          boolean v=udao.Register(uname, upass, dob, ukey);
          if(v)
          {
                 request.setAttribute("msg",  "  Plz Login..... '_~");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
          }
          else
          {   request.setAttribute("msg","ERR in regd.....try again '_~'");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);}
          
    }

    
    
}
