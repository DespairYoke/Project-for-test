package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BmiService.Service;

/**
 * Servlet implementation class ActionServlet
 */
public class ActionServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri=req.getRequestURI();
		String action=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		System.out.println(action);
		if("/bmi".equals(action))
		{
			String height=req.getParameter("height");
			String weight=req.getParameter("weight");
			System.out.println(height+"  "+weight);
			Service s=new Service();
			String status=s.bmi(Double.parseDouble(height),Double.parseDouble(weight));
			req.setAttribute("status",status);
			req.getRequestDispatcher("WEB-INF/value.jsp").forward(req, resp);
		}
	}
}
