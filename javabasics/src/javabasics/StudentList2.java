package javabasics;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentList2 {

	public static void main(String[] args) {
		List<Student> students = new ArrayList();
		System.out.println("Do you wish to add to the list? (yes/no)");
		String option = new Scanner(System.in).nextLine();	
		while (option.equals("yes"))
		{			
			System.out.println("Enter student's name : ");
			String name = new Scanner(System.in).nextLine();
			System.out.println("Enter student's Data Structures marks : ");
			int ds = new Scanner(System.in).nextInt();
			System.out.println("Enter student's OOPS marks : ");
			int oops = new Scanner(System.in).nextInt();
			System.out.println("Enter student's Java marks : ");
			int java = new Scanner(System.in).nextInt();
			Student student = new Student(name, ds, oops, java,"hailey.thanki99@gmail.com");
		    students.add(student);	
			System.out.println("Do you wish to add to the list? (yes/no)");
		    option = new Scanner(System.in).nextLine();
		}
		System.out.println("Total students added : " + students.size());
		for (int i=0; i<students.size(); i++)
		{
			Student student = students.get(i);
			System.out.println(student.getName() + " : " + student.getTotalMarks());
		}
		Student student = students.get(0);
		int max = student.getTotalMarks();
		String name = student.getName();
		for (int i=0; i<students.size(); i++)
		{
		    student = students.get(i);
			if (student.getTotalMarks()>max)
			{
				max = student.getTotalMarks();
				name = student.getName();
			}
		}
		System.out.println("Student " + name + " has max total marks " + max);
		
	    student = students.get(0);
		int min = student.getTotalMarks();
	    name = student.getName();
		for (int i=0; i<students.size(); i++)
		{
		    student = students.get(i);
			if (student.getTotalMarks()<min)
			{
				min = student.getTotalMarks();
				name = student.getName();
			}
		}
		System.out.println("Student " + name + " has min total marks " + min);
	}
}
