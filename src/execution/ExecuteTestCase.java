package execution;

import java.io.IOException;

import excelUtility.WriteExcelSheet;
import loginData.LoginTest;

public class ExecuteTestCase {

	public static void main(String[] args) throws IOException, InterruptedException {
		LoginTest lt=new LoginTest();
		lt.loginSetup();
		WriteExcelSheet.setCellData("Pass", 1, 2);
		WriteExcelSheet.setCellData("Pass", 2, 2);
		WriteExcelSheet.setCellData("Pass", 3, 2);
	}
}
