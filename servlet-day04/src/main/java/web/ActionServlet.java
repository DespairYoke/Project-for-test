package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class ActionServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//��ȡ������Դ·��
		String uri = request.getRequestURI();
		//������Դ·��
		String action  = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
	
		
		if("/list".equals(action)){
			EmployeeDAO dao = new EmployeeDAO();
			try {
				List<Employee> list;
			System.out.println(1);
				list = dao.findAll();
				
				System.out.println(list);
			System.out.println(2);
				//step1.�����ݵ�request
				request.setAttribute("employees", list);
				//step2.���ת����
				RequestDispatcher rd = request.getRequestDispatcher("emplist3.jsp");
				//step3.ת��
				rd.forward(request,response);
			
			} catch (Exception e) {
				e.printStackTrace();
				out.println("系统繁忙");
			}
			
			
		
		
		}else if("/add".equals(action)){
			//�������Ա��������

			//��ȡ��Ϣ
			
			
			String name =request.getParameter("ename");
			String sal =request.getParameter("salary");
			String age=request.getParameter("age");
		/*	//���������̨
			System.out.println("���� :"+name);
			System.out.println("нˮ :"+sal);
			System.out.println("���� :"+age);*/
			
		
			//��Ա����Ϣ���뵽���ݿ�
			EmployeeDAO dao = new EmployeeDAO();
			Employee e = new Employee();
			e.setEname(name);
			e.setSalary(Double.parseDouble(sal));
			e.setAge(Integer.parseInt(age));
			try{
			dao.save(e);
			//�ض���Ա���б�
			response.sendRedirect("list.do");
			}catch(Exception e1){
				e1.printStackTrace();
				out.println("<h1>ϵͳ��æ,���Ժ�����</h1>");
			}
			
			
			
			
			//�������Զ��ر���
			out.close();
			
		
		}else if("/del".equals(action)){
			int id = Integer.parseInt(request.getParameter("id"));
			EmployeeDAO dao = new EmployeeDAO();
			try {
				dao.Del(id);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
				out.println("<h1>ϵͳ��æ,���Ժ�����</h1>");
				
			}
			
		}else if("/load".equals(action)){
			int id = Integer.parseInt(request.getParameter("id"));
			
			EmployeeDAO dao = new EmployeeDAO();
			try {
				Employee e =dao.findById(id);
				request.setAttribute("e", e);
				request.getRequestDispatcher("updateEmp.jsp").forward(request,response);
				/*out.println("<form action='update.do'    method='post'>");
				out.println(" id:<input readonly='value' name='id'  value='" + e.getId() + "'/>   </br>");
				out.println("����:<input name = 'ename' value='" + e.getEname() + "'/>   </br>");
				out.println("нˮ:<input name = 'salary'value='" + e.getSalary() + "'/>   </br>");
				out.println("����:<input name = 'age'value='" + e.getAge() + "'/>   </br>");
				out.println("<input type ='submit' value='ȷ��'/>");*/
				/*//ͨ�������������������ID
				out.println("<input type ='hidden' value='"+id+"'/>");*/
				/*out.println("</form>");*/
			} catch (Exception e) {
				e.printStackTrace();
				out.print("ϵͳ��æ");
			}
		}else if("/update".equals(action)){
			String id=	request.getParameter("id");
			String ename = request.getParameter("name");
			String salary= request.getParameter("salary");
			String age = request.getParameter("age");;
			Employee e = new Employee();
			e.setId(Integer.parseInt(id));
			e.setEname(ename);
			e.setSalary(Double.parseDouble(salary));
			e.setAge(Integer.parseInt(age));
				EmployeeDAO dao = new EmployeeDAO();
				try {
					dao.update(e);
					response.sendRedirect("list.do");
				} catch (Exception e2) {
					e2.printStackTrace();
					out.println("ϵͳ��æ");
				}
			
		}
		
		
		
	}
	
}
