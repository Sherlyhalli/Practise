package org.srs.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet(description = "practise", urlPatterns = { "/Login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
       		response.setContentType("text/html");
    		PrintWriter out=response.getWriter();
    		String v1=request.getParameter("n1");
    		String v2=request.getParameter("n2");
    		try{
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
    		String qry="select * from emp_table where userid=? and password=?";
    		PreparedStatement pstmt=con.prepareStatement(qry);
    		pstmt.setString(1,"v1" );
    		pstmt.setString(2, "v2");
    		ResultSet rs=pstmt.executeQuery();
    		if (rs.next())
    		{
    			HttpSession hs=request.getSession();
    			hs.setAttribute("name", v1);
    			RequestDispatcher rd=request.getRequestDispatcher("main.jsp");
    			rd.include(request,response);	
    		}
    		else
    		{
    			out.println("Main page");
    			RequestDispatcher rd=request.getRequestDispatcher("login.html");
    			rd.include(request, response);
    		}
    		rs.close();
    		pstmt.close();
    		con.close();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

}
