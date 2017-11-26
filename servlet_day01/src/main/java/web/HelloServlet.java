package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	
	public HelloServlet() {
	System.out.println("hrlloSet()");
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(2221);
		System.out.println(2221);
		String name=request.getParameter("username");
		request.
		String age=request.getParameter("age");
		System.out.println(name+"  "+age);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.write("<html><head><title></title></head><body>∫£Õ‚π∫</body></html>");
	}
	/*@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(11111);
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		pw.write("<html><head><title></title></head><body>hello</body></html>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(333);
		doGet(req,resp);
		
	}*/
}
