package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SomeServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		HttpSession session=request.getSession();
		session.setAttribute("name", "king");
		System.out.println(session.getId());
		Integer count=(Integer) session.getAttribute("count");
		if(count==null)
		{
			count=1;
		}else
		{
			count++;
		}
		session.setAttribute("count", count);
		PrintWriter out=response.getWriter();
		out.println(count+"访问");
	}

}
