package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class AddEmpServlet extends HttpServlet{
	public void service(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType(
				"text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//读取员工信息
		RequestDispatcher ds=request.getRequestDispatcher("");
		String ename =
				request.getParameter("ename");
		String salary = 
				request.getParameter("salary");
		String age = 
				request.getParameter("age");
		System.out.println(ename + " "
				+ salary + " " + age);
		//将员工信息插入到数据库
		EmployeeDAO dao = new EmployeeDAO();
		Employee e = new Employee();
		e.setEname(ename);
		e.setSalary(Double.parseDouble(salary));
		e.setAge(Integer.parseInt(age));
		try{
			dao.save(e);
			//输出添加成功
			out.println("<h1>添加成功</h1>");
		}catch(Exception e1){
			e1.printStackTrace();
			out.println("<h1>系统繁忙，稍后重试</h1>");
		}
		//容器会自动关闭out,这儿不调用out.close()也可以
		out.close();
	}
}





