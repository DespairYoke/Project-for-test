package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEmpServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name=req.getParameter("name");
		Htts
		String salary=req.getParameter("salary");
		String age=req.getParameter("age");
		System.out.println(name+"  "+salary+" "+age);
		req.getRequestDispatcher("success.html").forward(req, resp);
	}
}
