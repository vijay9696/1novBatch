package excelUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utility.Constants;

public class WriteExcelSheet 
{
	public static void setCellData(String result,int rowNo,int colNo) throws IOException
	{
		File file=new File(Constants.filePath);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet= wb.getSheetAt(0);
		sheet.getRow(rowNo).createCell(colNo).setCellValue(result);
		FileOutputStream fos=new FileOutputStream(Constants.filePath);
		wb.write(fos);
		fos.flush();
		fos.close();
		System.out.println("Result:Passed");
		
	}
//	public static void main(String[] args) throws IOException {
//		WriteExcelSheet wes=new WriteExcelSheet();
//		wes.setCellData("Pass", 2, 2);
//
//	}

}
