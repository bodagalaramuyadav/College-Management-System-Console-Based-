package com.StudentManagement.pack;
import java.util.Scanner;

public class AdminLogin {
	Scanner sc = new Scanner(System.in);
	
	public boolean adminLogIn(int verifyCount) {
		
		boolean verify=false;
		System.out.println("WELCOME TO LOGIN");
		System.out.print("Enter UserName: ");
		String userName = sc.next();
		System.out.print("Enter Password: ");
		String password = sc.next();
		
		AdminVerification av = new AdminVerification();
		verify = av.adminVerification(userName,password);
		return verify;
	}
}
