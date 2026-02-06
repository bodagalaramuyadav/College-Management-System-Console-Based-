package com.StudentManagement.pack;
import java.util.Scanner;

public class StudentManagement {
	Scanner sc = new Scanner(System.in);

	public void studentManagementApp() {

		boolean exitStudentManagement = true;

		while(exitStudentManagement) {
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("WELCOME TO STUDENT MANAGEMENT SYSTEMS");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("Choose the Operations");
			System.out.println("1-> Get All Students");
			System.out.println("2-> Get Student with ID");
			System.out.println("3-> Add new Student");
			System.out.println("4-> Update the existing Student Details");
			System.out.println("5-> Delete the Student");
			System.out.println("6-> Delete full table Data");
			System.out.println("7-> Exit Student Management");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.print("Enter Choice to perform Operation: ");
			int choose = sc.nextInt();
			System.out.println("--------------------------------------------------------------------------------");

			switch(choose) {

			case 1: {
				//For getting all student details
				System.out.println("YOU HAVE SELECTED TO PRINT ALL STUDENT DETAILS");
				System.out.println("--------------------------------------------------------------------------------");
				GetAllStudents getAllStudentsObj = new GetAllStudents();
				getAllStudentsObj.getAllStudents();
				break;
			} case 2: {
				//this is for getting specific student data through RollNo
				System.out.println("YOU HAVE SELECTED TO GET STUDENT DETAILS BY ID");
				System.out.println("--------------------------------------------------------------------------------");
				System.out.print("Enter RollNo to get Student details: ");
				int rollNo = sc.nextInt();
				GetStudentByID getStudentByIdObj = new GetStudentByID();
				getStudentByIdObj.getStudentById(rollNo);
				break;
			}
			case 3: {

				//this case is for adding students we can enter more than 1 student if possible
				System.out.println("YOU HAVE SELECTED FOR ADDING STUDENT DETAILS");
				System.out.println("--------------------------------------------------------------------------------");
				System.out.print("Enter the number of Students want to add: ");
				int addCountOfStudents = sc.nextInt();
				AddNewStudent addNewStudentObj = new AddNewStudent();
				addNewStudentObj.addNewStudent(addCountOfStudents);
				break;
			}
			case 4:{

				//this case is for updating student updates like name, percentage, phone and all
				System.out.println("YOU HAVE CHOOSEN FOR UPDATING THE STUDENT DETAILS");
				System.out.println("--------------------------------------------------------------------------------");
				UpdateStudentDetails updateStudentDetailsObj = new UpdateStudentDetails();
				boolean updateRepeating = updateStudentDetailsObj.updateStudentDetails();
				while(updateRepeating) {
					updateRepeating = updateStudentDetailsObj.updateStudentDetails();
				}
				break;
			} case 5: {

				//this case is for deleting the student details with the help of rollno
				System.out.println("YOU HAVE CHOOSEN FOR DELETE STUDENT WITH ROLLNO");
				System.out.println("--------------------------------------------------------------------------------");
				System.out.print("Enter Student RollNo to delete: ");
				int rollNo = sc.nextInt();
				System.out.println("--------------------------------------------------------------------------------");
				DeleteStudentByID deleteStudentByIdObj = new DeleteStudentByID();
				deleteStudentByIdObj.deleteStudentByID(rollNo);
				break;
			}
			case 6:{

				//this case is for to all data of the students
				System.out.println("YOU HAVE CHOOSEN TO ALL STUDENT DETAILS FROM THE TABLE");
				System.out.println("--------------------------------------------------------------------------------");
				DeleteAllStudents deleteAllStudentObj = new DeleteAllStudents();
				deleteAllStudentObj.deleteAllStudent();
				break;
			}
			case 7: {

				exitStudentManagement = false;
				System.err.println("Exitied from Student Management");
				break;
			}
			default:{

				System.err.println("You have Choosen a Wrong operation");
				break;
			}
			}
		}
	}
}