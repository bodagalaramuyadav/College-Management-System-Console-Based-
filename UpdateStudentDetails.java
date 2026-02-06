package com.StudentManagement.pack;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateStudentDetails {
	Scanner sc = new Scanner(System.in);

	public boolean updateStudentDetails() {

		Connection con=null;
		PreparedStatement ps = null;
		
		try {

			con = DBConnection.getConnection();
			
			System.out.println("A-> Update Name");
			System.out.println("B-> Update Percentage");
			System.out.println("C-> Update PhoneNo");
			System.out.println("D-> Update All");
			System.out.println("E-> Exit from Update");
			System.out.print("Enter the Option for update: ");
			char ch = sc.next().charAt(0);
			System.out.println("--------------------------------------------------------------------------------");
			
			switch(ch) {
			case 'A':{
				// this case is for updating name only
				System.out.print("Enter the Student RollNo for update: ");
				int rollNo = sc.nextInt();
				String sql = "update student set name = ? where rollno=?";
				ps = con.prepareStatement(sql);
				System.out.print("Enter update Name: ");
				ps.setString(1,sc.next());
				sc.nextLine();
				ps.setInt(2, rollNo);
				int result = ps.executeUpdate();
				if(result>0) {
					System.out.println("--------------------------------------------------------------------------------");
					System.out.println("UPDATED SUCCESSFULLY");
					System.out.println("--------------------------------------------------------------------------------");
				} else {
					System.out.println("--------------------------------------------------------------------------------");
					System.out.println("STUDENT NOT FOUND");
					System.out.println("--------------------------------------------------------------------------------");
				}

				ps.close();
				con.close();
				return true;
			}
			case 'B':{
				// this case is for updating marks only
				System.out.print("Enter the Student RollNo for update: ");
				int rollNo = sc.nextInt();
				String sql = "update student set percentage = ? where rollNo = ?";
				System.out.print("Enter update Percentage: ");
				ps = con.prepareStatement(sql);
				ps.setDouble(1, sc.nextDouble());
				ps.setInt(2, rollNo);
				int result = ps.executeUpdate();
				if(result>0) {
					System.out.println("--------------------------------------------------------------------------------");
					System.out.println("UPDATED SUCCESSFULLY");
					System.out.println("--------------------------------------------------------------------------------");
				} else {
					System.out.println("--------------------------------------------------------------------------------");
					System.out.println("STUDENT NOT FOUND");
					System.out.println("--------------------------------------------------------------------------------");
				}

				ps.close();
				con.close();
				return true;
			}
			case 'C':{
				// this case is for updating password only
				System.out.print("Enter the Student RollNo for update: ");
				int rollNo = sc.nextInt();

				String sql = "update student set phoneno = ? where rollNo=?";
				ps = con.prepareStatement(sql);

				System.out.print("Enter update phone: ");
				ps.setString(1,sc.next());
				ps.setInt(2, rollNo);
				int result = ps.executeUpdate();
				if(result>0) {
					System.out.println("--------------------------------------------------------------------------------");
					System.out.println("UPDATED SUCCESSFULLY");
					System.out.println("--------------------------------------------------------------------------------");
				} else {
					System.out.println("--------------------------------------------------------------------------------");
					System.out.println("STUDENT NOT FOUND");
					System.out.println("--------------------------------------------------------------------------------");
				}

				ps.close();
				con.close();
				return true;
			}
			case 'D':{
				// this case is for updating all
				System.out.print("Enter the Student RollNo for update: ");
				int rollNo = sc.nextInt();

				String sql = "update student set name=?,percentage=?,phoneNo=? where rollNo=?";
				ps = con.prepareStatement(sql);

				System.out.print("Enter updated name: ");
				ps.setString(1, sc.next());
				System.out.print("Enter updated Percentage: ");
				ps.setDouble(2, sc.nextDouble());
				System.out.print("Enter updated phone: ");
				ps.setString(3, sc.next());
				ps.setInt(4, rollNo);
				int result = ps.executeUpdate();
				if(result>0) {
					System.out.println("--------------------------------------------------------------------------------");
					System.out.println("UPDATED SUCCESSFULLY");
					System.out.println("--------------------------------------------------------------------------------");
				} else {
					System.out.println("--------------------------------------------------------------------------------");
					System.out.println("STUDENT NOT FOUND");
					System.out.println("--------------------------------------------------------------------------------");
				}

				ps.close();
				con.close();
				return true;
			}
			
			case 'E':{
				// no updates
				System.out.println("EXITIED FROM UPDATES");
				return false;
			}
			
			default: {
				System.out.println("Selected wrong Update Option, TRY AGAIN");
				System.out.println("--------------------------------------------------------------------------------");
				return true;
			}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}