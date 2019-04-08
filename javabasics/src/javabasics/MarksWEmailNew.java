package javabasics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;

public class MarksWEmailNew {

	public static void main(String[] args) {
		List<Student> students = new ArrayList();
		Set<String> domains = new TreeSet();
		Map<String,List> domainClassification = new HashMap();
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
		System.out.println("Domains : ");
		while(setIterator.hasNext())
		{
			List<Student> currentDomainList = new ArrayList();	
			String domain =  setIterator.next();
			System.out.println(domain);
			listIterator = students.iterator();
			while(listIterator.hasNext())
			{
				Student currentStudent = listIterator.next();
				String eMail = currentStudent.getEmail();
				String[] currentDomain = eMail.split("@");
				if (currentDomain[1].equals(domain))
				{
					currentDomainList.add(currentStudent);
				}
			}	
			domainClassification.put(domain, currentDomainList);
		}
		System.out.println("Do you wish to display information regarding a particular domain? (yes/no)");
		String nextOption = new Scanner(System.in).nextLine();	
		while(nextOption.equals("yes"))
		{
			System.out.println("Enter the domain : ");
			String domain = new Scanner(System.in).nextLine();
			if (domainClassification.containsKey(domain))
			{
				List studentList = domainClassification.get(domain);
				listIterator = studentList.iterator();
				while(listIterator.hasNext())
				{
					Student currentStudent = listIterator.next();
					String name = currentStudent.getName();
					int marks = currentStudent.getTotalMarks();
					System.out.println(name + " - " + marks);
				}
			}
			else
			{
				System.out.println("Not a valid domain name.");
			}
			System.out.println("Do you wish to display information regarding a particular domain? (yes/no)");
			nextOption = new Scanner(System.in).nextLine();	
		}
	}
}
