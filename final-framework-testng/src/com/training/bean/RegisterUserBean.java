package com.training.bean;

public class RegisterUserBean {
	
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private String confirmpassword;
	private String phonenumber;
	private String language;

	public RegisterUserBean() {
	}

	public RegisterUserBean(String firstName, String lastName, String email,String username, String password, String confirmpassword, String phonenumber,String language) {
		super();
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.username=username;
		this.password=password;
		this.confirmpassword=confirmpassword;
		this.phonenumber=phonenumber;
		this.language=language;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String firstname) {
		this.firstName=firstname;
	}

	public String getlastName() {
		return this.lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getemail() {
		return this.email;
	}

	public void setemail(String email) {
		this.email = email;
	}
	
	public String getusername() {
		return this.username;
	}

	public void setusername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getconfirmpassword() {
		return this.confirmpassword;
	}

	public void setconfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	
	public String getphonenumber() {
		return this.phonenumber;
	}

	public void setphonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	public String getlanguage() {
		return this.language;
	}

	public void setlanguage(String language) {
		this.language = language;
	}
	
	

	@Override
	public String toString() {
		return "RegisterUserBeann [firstName=" + firstName + ", lastName=" + lastName  + ", email=" + email + ", username=" + username + ", password=" + password + ", confirmpassword=" + confirmpassword + ", phonenumber=" + phonenumber + ", language=" + language+ "]";
	}

}
