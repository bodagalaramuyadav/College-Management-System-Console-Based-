package com.StudentManagement.pack;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddNewStudent {
	Scanner sc = new Scanner(System.in);

	public void addNewStudent(int n1) {
		String sql ="INSERT INTO student (rollno, name, age, branch, percentage, phoneno)VALUES (?,?,?,?,?,?)";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			int numberStudentsAdded =0;

			for(int i=0;i<n1;i++) {
				System.out.print("Enter RollNo: ");
				ps.setInt(1, sc.nextInt());
				sc.nextLine();
				System.out.print("Enter Name: ");
				ps.setString(2, sc.nextLine());
				System.out.print("Enter Age: ");
				ps.setInt(3, sc.nextInt());
				sc.nextLine();
				System.out.print("Enter Branch: ");
				ps.setString(4, sc.nextLine());
				System.out.print("Enter Percentage: ");
				ps.setDouble(5, sc.nextDouble());
				System.out.print("Enter PhoneNo: ");
				ps.setString(6, sc.next());
				sc.nextLine();
				numberStudentsAdded += ps.executeUpdate();
			}

			if(numberStudentsAdded>0) {
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println(numberStudentsAdded +" STUDENT ADDED SUCCESSFULLY");
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
