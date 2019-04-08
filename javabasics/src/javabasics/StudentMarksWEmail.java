package javabasics;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;

public class StudentMarksWEmail {

	public static void main(String[] args) {
		List<Student> students = new ArrayList();
		Set<String> domains = new TreeSet();
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
			System.out.println("Enter student's e-mail id : ");
			String eMail = new Scanner(System.in).nextLine();
			Student student = new Student(name, ds, oops, java,eMail);
		    students.add(student);	
			System.out.println("Do you wish to add to the list? (yes/no)");
		    option = new Scanner(System.in).nextLine();		    
		}
		Iterator<Student> listIterator = students.iterator();
		while(listIterator.hasNext())
		{
		    Student currentStudent = listIterator.next();
			String eMail = currentStudent.getEmail();
			String[] domain = eMail.split("@");
			domains.add(domain[1]);
		}
		Iterator<String> setIterator = domains.iterator();		
		while(setIterator.hasNext())
		{
			System.out.println("*******************************");
			String domain =  setIterator.next();
			System.out.println(domain + " : ");
			listIterator = students.iterator();
			while(listIterator.hasNext())
			{
				Student currentStudent = listIterator.next();
				String eMail = currentStudent.getEmail();
				String[] currentDomain = eMail.split("@");
				if (currentDomain[1].equals(domain))
				{
					System.out.println(currentStudent.getName() + " - " + currentStudent.getTotalMarks());
				}
			}
		}
	}
}
