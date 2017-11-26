package ssh.day02;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class LogoAction {
	private String type;
	private InputStream img;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public InputStream getImg() {
		return img;
	}
	public void setImg(InputStream img) {
		this.img = img;
	}
	
	public String execute() throws IOException{
		
		type = "image/png";
		img = createPngImage("Hello");
		
		return "success";
	}
	private InputStream createPngImage(String msg) 
		throws IOException{
		BufferedImage image = new BufferedImage(
			200, 100, BufferedImage.TYPE_3BYTE_BGR);
		image.setRGB(100, 50, 0xffff00);
		Graphics2D g = image.createGraphics();
		g.setColor(new Color(0xffff00)); 
		g.drawString(msg, 20, 40); 
		//将 image 编码为 png数据(byte数组)
		ByteArrayOutputStream out = 
				new ByteArrayOutputStream();
		ImageIO.write(image, "png", out);
		out.close();
		byte[] data = out.toByteArray();
		return new ByteArrayInputStream(data); 
	}
}















