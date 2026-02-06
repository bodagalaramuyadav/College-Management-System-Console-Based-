package com.StudentManagement.pack;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteAllStudents {
	public void deleteAllStudent() {
		String sql = "Truncate table student";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			
			int deleteStudents =0;
			deleteStudents+=ps.executeUpdate();
			if(deleteStudents==0) {
				System.err.println("NO STUDENTS PRESENT TO DELETE");
			} else {
				System.err.println(deleteStudents+" STUDENTS HAS BEEN DELETED");
			}
			ps.execute();
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
