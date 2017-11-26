package ssh.day02;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelAction {
	private String type;
	private InputStream excel;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public InputStream getExcel() {
		return excel;
	}
	public void setExcel(InputStream excel) {
		this.excel = excel;
	}
	
	public String execute() throws IOException{
		//type 来自 tomcat/conf/web.xml
		type = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
		excel = createExcel();
		return "success";
	}
	private InputStream createExcel() throws IOException {
		//创建工作簿
		XSSFWorkbook workbook=new XSSFWorkbook();
		//在工作簿中创建工作表
		XSSFSheet sheet = workbook.createSheet();
		//在工作表里面创建行
		XSSFRow row0 = sheet.createRow(0);
		XSSFRow row1 = sheet.createRow(1);
		XSSFRow row2 = sheet.createRow(2);
		//在行中创建单元格(cell)
		XSSFCell cell = row0.createCell(0);
		cell.setCellValue("编号"); 
		row0.createCell(1).setCellValue("姓名"); 
		row0.createCell(2).setCellValue("数量");  
		//添加数据
		row1.createCell(0).setCellValue(1);
		row1.createCell(1).setCellValue("范传奇");
		row1.createCell(2).setCellValue(1);
		
		row2.createCell(0).setCellValue(2);
		row2.createCell(1).setCellValue("李某");
		row2.createCell(2).setCellValue(2);
		
		ByteArrayOutputStream out=
				new ByteArrayOutputStream();
		workbook.write(out);
		out.close();
		byte[] data = out.toByteArray();
		
		return new ByteArrayInputStream(data); 
	}
	
}









