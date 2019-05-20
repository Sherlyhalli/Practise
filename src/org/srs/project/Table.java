package org.srs.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;

/**
 * Servlet implementation class Table
 */
@WebServlet("/Table")
public class Table extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Table() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
    	response.setContentType("html/text");
    	PrintWriter out=response.getWriter();
    	out.println("<table><tr><th>name</th><th>title</th><th>doj</th></tr>");
    	try{
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost=3306?user=root&password=root");
    	java.sql.Statement stmt=con.createStatement();
    	String str="select * from emp_req";
    	ResultSet rs=stmt.executeQuery(str);
    	while(rs.next())
    	{
    		out.print("<tr><td>");
    		out.println(rs.getString(1));
    		out.print("</td>");
    		out.print("<td>");
    		out.print(rs.getString(2));
    		out.print("</td>");
    		out.print("<td>");
    		out.print(rs.getDate(3));
    		out.print("</td>");
    		out.print("</tr>");
    	}
    	rs.close();
    	stmt.close();
    	con.close();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    out.print("</table");
    }

}
