package com.StudentManagement.pack;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteStudentByID {

	public void deleteStudentByID(int rollNo) {
		String sql = "delete from student where rollNo=?";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, rollNo);

			int updatedStudent = ps.executeUpdate();
			if(updatedStudent>0) {
				System.err.println(rollNo+" student details has been deleted");
			} else {
				System.err.println("Student not found with RollNo " + rollNo);
			}

			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
