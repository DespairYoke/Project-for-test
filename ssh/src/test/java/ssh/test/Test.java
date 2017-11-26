package ssh.test;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {

	public static void main(String[] args)
		throws IOException{
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
		
		FileOutputStream out=
				new FileOutputStream("demo.xlsx");
		workbook.write(out); 
		out.close();
	}

}



