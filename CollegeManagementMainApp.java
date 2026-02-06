package com.StudentManagement.pack;
import java.util.Scanner;

public class CollegeManagementMainApp {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		
		while(check) {
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("WELCOME TO COLLEGE MANAGEMENT SYSTEM FULLY CONSOLE BASED APPLICATION");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("1-> LogIn");
			System.out.println("2-> SignUp");
			System.out.println("3-> LogOut");
			System.out.print("Choose the option: ");
			int operationChoice = sc.nextInt();
			System.out.println("--------------------------------------------------------------------------------");
			
			switch(operationChoice) {
			case 1: {
				//for login with userName, password
			    AdminLogin adminloginObj = new AdminLogin();
			    
			    //verifyCount purpose is to give chance to login up to 3 times
			    int verifyCount = 1;
			    
			    //verify is used to check the login the details that entered 
			    boolean verify = false;
			    while (verifyCount <= 3) {
			    	
			        verify = adminloginObj.adminLogIn(verifyCount);
			        
			        if (verify) {
			        	System.out.println("--------------------------------------------------------------------------------");
			            System.out.println("Login Successful");
			            //if login success it creates the  StudentManagement object
			            StudentManagement studentManagementObj = new StudentManagement();
			            studentManagementObj.studentManagementApp();
			            break;
			        } else {
			        	
			        	//if password some thing goes wrong it gives three chances to login
			            System.err.println("Wrong credentials. Attempts left: " + (3 - verifyCount));
			            System.out.println("--------------------------------------------------------------------------------");
			        }
			        verifyCount++;
			    }

			    if (!verify) {
			        System.err.println("Try again after some time");
			    }
			    break;
			}

			case 2:{
				//for adding new admin data
				AdminSignUp adminSignUpObj = new AdminSignUp();
				adminSignUpObj.adminSignUp();
				break;
			}
			case 3:{
				//for logout
				check = false;
				System.out.println("YOU HAVE BEEN LOGOUT FROM SCHOOL MANAGEMENT SYSTEM");
				System.out.println("--------------------------------------------------------------------------------");
				break;
			}
			default:{
				System.err.println("You have selected wrong option");
				break;
			}
			}
		}
		sc.close();
	}
}