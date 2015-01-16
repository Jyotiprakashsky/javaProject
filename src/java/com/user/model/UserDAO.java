/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author sky
 */
public class UserDAO {
       public boolean login(String name,String pass)
    {
        try{
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system", "1234567");
            
            
                        
            PreparedStatement ps=con.prepareStatement("SELECT * from DriveLogin WHERE uname=? AND  pass=? ");
            
            ps.setString(1,name);
            ps.setString(2,pass);
            
            
            ResultSet rs=ps.executeQuery();
            //perForming Validation.......
            if(rs.next())
            {return true;
            }
            else
            {return false;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
        
       
    }
    
    //list.....customer............................................
     
    public boolean Register(String uname,String upass,String dob,String ukey)
    {
   
        System.out.println("................................");
         try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
                            
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system", "1234567");
                                                         
            
            PreparedStatement ps1 = con.prepareStatement("INSERT INTO DriveLogin(uname,pass,dob,ukey) VALUES(?,?,?,?)");
            ps1.setString(1,uname);
            ps1.setString(2,upass);
            ps1.setString(3,dob);
             ps1.setString(4,ukey);
            
            
            int count =ps1.executeUpdate();
            
            
  con.close();
                 //return false;
            if(count==1)
            {
                return true;
            }
            else
            {
                        return false;
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }
    
}
