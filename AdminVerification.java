package com.StudentManagement.pack;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminVerification {

	//this method return the true/false for that the admin entered check the with existing details in the database returns true correct else false incorrect
	//to AdimnLogin class
	public boolean adminVerification(String userName, String password) {
		
		boolean verify = false;

		String sql = "Select * from collegeadmin where username=?";
		
		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			String user = null;
			String pass = null;
			int count=0;
			while (rs.next()) {
				user = rs.getString(1);
				pass = rs.getString(2);
				count++;
			}
			if(count==0) {
				System.out.println("Details Not Found");
			} else {
				if (user != null && pass != null &&
						user.equals(userName) &&
						pass.equals(password)) {
					verify = true;
				}
			}
			con.close();
			ps.close();
			rs.close();

		} catch(Exception e) {
			e.printStackTrace();
		}
		return verify;
	}
}
