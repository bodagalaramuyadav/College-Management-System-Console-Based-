package com.StudentManagement.pack;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetAllStudents {

	public void getAllStudents() {
		try (Connection con = DBConnection.getConnection();
				Statement st = con.createStatement()){
			String sql = "Select * from student";
			ResultSet rs =st.executeQuery(sql);
			int studentCount =1;

			while(rs.next()) {
				System.out.println("STUDENT: "+studentCount);
				System.out.println("RollNo: "+ rs.getInt(1));
				System.out.println("Name: " + rs.getString(2));
				System.out.println("Age: " +rs.getInt(3));
				System.out.println("Branch: " +rs.getString(4));
				System.out.println("Percentage: "+ rs.getInt(5));
				System.out.println("PhoneNo: " + rs.getString(6));
				studentCount++;
				System.out.println("--------------------------------------------------------------------------------");
			}

			if(studentCount==1) {
				System.err.println("The Student table is Empty");
			} else {
				System.out.println((studentCount-1)+" STUDENTS PRESENT IN THE SCHOOL");
			}

			con.close();
			st.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
