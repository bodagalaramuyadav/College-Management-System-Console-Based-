package com.StudentManagement.pack;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetStudentByID {

	public void getStudentById(int rollNo) {

		String sql = "select * from student where rollNo=?";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, rollNo);
			ResultSet rs = ps.executeQuery();

			int studentCount =0;

			while(rs.next()) {
				System.out.println("RollNo: "+ rs.getInt(1));
				System.out.println("Name: " + rs.getString(2));
				System.out.println("Age: " +rs.getInt(3));
				System.out.println("Branch: " +rs.getString(4));
				System.out.println("Percentage: "+ rs.getInt(5));
				System.out.println("PhoneNo: " + rs.getString(6));
				studentCount++;
			}

			if(studentCount==0) {
				System.out.println("--------------------------------------------------------------------------------");
				System.err.println("Student with RollNo " + rollNo + " not found");
			}

			ps.close();
			con.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
