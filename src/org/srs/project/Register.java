package org.srs.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("html/text");
		PrintWriter out=response.getWriter();
		String v1=request.getParameter("n1");
		String v2=request.getParameter("n2");
		String v3=request.getParameter("n3");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			String qry="insert into emp_reg(name,title,doj)values(???)";
			PreparedStatement pstmt=con.prepareStatement(qry);
			pstmt.setString(1, "v1");
			pstmt.setString(2, "v2");
			pstmt.setString(3, "v3");
			int i=pstmt.executeUpdate();
			if (i==1)
					{
					RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
					rd.include(request, response);
					}
			pstmt.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	

}
