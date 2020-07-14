package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.LoginBean;
import com.training.bean.RegisterUserBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class ELearningDAO {
	
	Properties properties; 
	
	public ELearningDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<LoginBean> getLogins(){
		String sql = properties.getProperty("get.logins"); 
		
		GetConnection gc  = new GetConnection(); 
		List<LoginBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<LoginBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				LoginBean temp = new LoginBean(); 
				temp.setUserName(gc.rs1.getString(1));
				temp.setPassword(gc.rs1.getString(2));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public List<RegisterUserBean> getRegisterDetails(){
		String sql = properties.getProperty("get.registerusers"); 
		
		GetConnection gc  = new GetConnection(); 
		List<RegisterUserBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<RegisterUserBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				RegisterUserBean temp = new RegisterUserBean(); 
				temp.setfirstName(gc.rs1.getString(1));
				temp.setlastName(gc.rs1.getString(2));
				temp.setemail(gc.rs1.getString(3));
				temp.setusername(gc.rs1.getString(4));
				temp.setPassword(gc.rs1.getString(5));
				temp.setconfirmpassword(gc.rs1.getString(6));
				temp.setphonenumber(gc.rs1.getString(7));
				temp.setlanguage(gc.rs1.getString(8));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	
	public static void main(String[] args) {
		new ELearningDAO().getRegisterDetails().forEach(System.out :: println);
	}
	
	
}
