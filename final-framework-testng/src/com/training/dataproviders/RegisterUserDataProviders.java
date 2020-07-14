package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.bean.RegisterUserBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class RegisterUserDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<RegisterUserBean> list = new ELearningDAO().getRegisterDetails(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(RegisterUserBean temp : list){
			Object[]  obj = new Object[8]; 
			obj[0] = temp.getfirstName();
			obj[1] = temp.getlastName();
			obj[2] = temp.getemail();
			obj[3] = temp.getusername();
			obj[4] = temp.getPassword();
			obj[5] = temp.getconfirmpassword();
			obj[6] = temp.getphonenumber();
			obj[7] = temp.getlanguage();
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\VivekanandDhotre\\Desktop\\Manipal Training\\Datasheet.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
