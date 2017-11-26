package com;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Bim extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse resp){
		String height=req.getParameter("height");
		String weight=req.getParameter("weight");
		resp.setContentType("text/html;charset=utf-8");
	}
}
