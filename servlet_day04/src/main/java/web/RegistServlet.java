package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;

public class RegistServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname=req.getParameter("username");
		String pwd=req.getParameter("pwd");
		String name=req.getParameter("name");
		String sex=req.getParameter("sex");
		System.out.println(uname);
		try {
			Connection conn=DBUtil.getConnection();
			String str="select username from users";
			Statement state=conn.createStatement();
			ResultSet rs=state.executeQuery(str);
			boolean flag = false;
			while(rs.next()){
				if(uname.equals(rs.getString(1)))
				{
					flag=true;
				}
			}
			if(flag){
				resp.setContentType("txt/html,charset=utf-8");
				resp.getWriter().println("<h1>已存在!</h1>");
			}
			else
			{
				state.executeUpdate("insert into users values(1,'"+uname+"','"+pwd+"')");
				req.getRequestDispatcher("login.html").forward(req, resp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
