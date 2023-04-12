package excelUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utility.Constants;

public class ReadExcelSheet 
{
	public ArrayList readExcelData(int colNo) throws IOException
	{
		String filePath=Constants.filePath;
		System.out.println("File path:"+filePath);
		File file=new File(filePath);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet= wb.getSheetAt(0);
		Iterator<Row> row=sheet.rowIterator();
		row.next();
		ArrayList<String> ar=new ArrayList<String>();
		while(row.hasNext())
		{
//			Row r=row.next();
//			Cell c= r.getCell(colNo);
//			String data=c.getStringCellValue();
//			ar.add(data);
			ar.add(row.next().getCell(colNo).getStringCellValue());
		}
		System.out.println("Data:"+ar);
		return ar;
	}
	
//	public static void main(String args[]) throws IOException
//	{
//		ReadExcelSheet read=new ReadExcelSheet();
//		ArrayList list= read.readExcelData(1);
//		System.out.println(list);
//	}
}
