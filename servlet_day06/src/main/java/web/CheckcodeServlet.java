package web;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckcodeServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
		BufferedImage image=new BufferedImage(80,30,BufferedImage.TYPE_INT_RGB);
		Graphics g=image.getGraphics();
		g.setColor(new Color(255,255,255));
		g.fillRect(0, 0, 80, 30);
		g.setColor(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
		String number=new Random().nextInt(9999)+"";
		HttpSession session=req.getSession();
		session.setAttribute("number", number);
		for(int i=0;i<3;i++)
		{
			g.drawLine(0,i*5, 30, i*5+80);
		}
		g.drawString(number, 5, 10);
		resp.setContentType("image/jpeg");
		OutputStream os=resp.getOutputStream();
		ImageIO.write(image, "jpeg", os);
		os.close();
	
		
	}
}
