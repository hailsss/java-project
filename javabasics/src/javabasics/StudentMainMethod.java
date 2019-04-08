package javabasics;

import java.io.File;
import java.util.Scanner; 

public class StudentMainMethod  {

	public static void main(String[] args) {	
		StudentMenu sm = new StudentMenu();
		sm.displayStudentMenu();
		System.out.println("Would you like to perform an operation? (yes/exit)");
		String option = new Scanner(System.in).nextLine();
		System.out.println("Enter 1 / 2 / 3 / 4 / 5 / 6 / 7 / 8 / 9 / 10");
		String functionNumber =  new Scanner(System.in).nextLine();
		StudentManager student = new StudentManager();
		while(option.equals("yes"))
		{
			switch (functionNumber)
			{
			case "1":
				student.addStudentData();
				break;	
			case "2":
				student.listStudents();
				break;
			case "3":
				student.listStudentsByDomains();
				break;
			case "4":
				student.findTopScorersByDomain();
				break;
			case "5":
				student.findLowestScorersByDomain();
				break;
			case "6":
				student.listStudentsOfDomain();
				break;
			case "7":
				student.createFile();
				break;
			case "8":
				student.readFromFile();
				break;
			case "9":
				student.addMoreStudentsToFile();
				break;
			case "10":
				student.exitProgram();		
			}
			System.out.println("Would you like to perform an operation? (yes/exit)");
		    option = new Scanner(System.in).nextLine();
		    sm.displayStudentMenu();
		    System.out.println("Enter 1 / 2 / 3 / 4 / 5 / 6 / 7 / 8 / 9 / 10");
		    functionNumber =  new Scanner(System.in).nextLine();
		}
	}
}
