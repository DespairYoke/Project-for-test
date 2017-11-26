package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("sessionCreated");
		HttpSession session=se.getSession();
		ServletContext sc=session.getServletContext();
		Integer count=(Integer) sc.getAttribute("count");
		if(count==null)
		{
			count=1;
		}
		else
		{
			count++;
		}
		sc.setAttribute("count", count);
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("essionDestroyed");
		HttpSession session=se.getSession();
		ServletContext sc=session.getServletContext();
		Integer count=(Integer) sc.getAttribute("count");
		
			count--;
	
		sc.setAttribute("count", count);
	}

}
