package org.srs.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<table><tr><th>name</th><th>title</th><th>doj</th></tr>");
		String s=request.getParameter("search");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			String str=("select * from emp_reg where name like '%"+ s + "%' or title like '%"+s+"%'doj like '%" +s+"%'");
			PreparedStatement pstmt=con.prepareStatement(str);
			ResultSet rs=pstmt.executeQuery();
			List<Employee> emplist=new ArrayList<>();
			while(rs.next())
			{
				String ename=rs.getString(1);
				String etitle=rs.getString(2);
				Date edoj=rs.getDate(3);
				Employee e=new Employee(ename,etitle,edoj);
				emplist.add(e);
			}
			request.setAttribute("emplist", emplist);
			RequestDispatcher rd=request.getRequestDispatcher("Search.jsp");
			rd.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	

}