/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.controler;

import java.io.File;
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
public class DeleteFileServlet extends HttpServlet {


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
        doPost(request, response);
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
        String chk[]=request.getParameterValues("chk1");
        int i=0;
      while(i<chk.length)
        {
            File f=new File(chk[i]);
           boolean v=f.delete();
          i++;
            
        }
        
                request.setAttribute("msg" ,"  File Deleted.....");
            RequestDispatcher rd = request.getRequestDispatcher("UserProfile.jsp");
            rd.forward(request, response);
           
    }

}
