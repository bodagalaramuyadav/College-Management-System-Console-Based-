package com.StudentManagement.pack;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AdminSignUp {
	Scanner sc = new Scanner(System.in);
	public void adminSignUp() {

		String sql = "INSERT INTO collegeadmin (username, password) VALUES (?, ?)";
		
		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			
			System.out.println("WELCOME TO SIGNUP");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("For SignUp you need to fill enter details username without spaces and password");
			int adminsAddedCount =0;
			System.out.print("Enter UserName: ");
			ps.setString(1, sc.next());
			sc.nextLine();
			System.out.print("Enter Password: ");
			ps.setString(2, sc.next());
			sc.nextLine();

			adminsAddedCount += ps.executeUpdate();

			if(adminsAddedCount>0) {
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println(adminsAddedCount +" ADMIN ADDED SUCCESSFULLY");
			} else {
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("ADMIN NOT ADDED");
			}
			
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
