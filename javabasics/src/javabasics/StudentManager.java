package javabasics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class StudentManager {
	List <Student>students = new ArrayList();
	List <Student>studentsOnFile = new ArrayList();
	Set <String>domains = new HashSet();
	File StudentsFile = null;
	public  Student addStudentData()
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
	    return student;
	}
	
	public void listStudents()
	{
		System.out.println("Name\tEmail\tData Structures\tOops\tJava\tTotal Marks");
		for(Student student : students)
		{
			System.out.println(String.format("%s\t%s\t%d\t%d\t%d\t%d", student.getName(), student.getEmail(), student.getDsMarks(), student.getOopsMarks(), student.getJavaMarks(), student.getTotalMarks()));
		}
	}
	
	public void listStudentsByDomains()
	{
		Iterator<Student> listIterator = students.iterator();
		while(listIterator.hasNext())
		{ 	
		    Student currentStudent = listIterator.next();
			String eMail = currentStudent.getEmail();
			String[] domain = eMail.split("@");
			domains.add(domain[1]);
		}
		Iterator<String> listDomainstIterator = domains.iterator();	
		while(listDomainstIterator.hasNext())
		{
			System.out.println("********************************************************************************************");
			String domain =  listDomainstIterator.next();
			System.out.println(domain + " : ");
			System.out.println("Name\tEmail\tData Structures\tOops\tJava\tTotal Marks");
			listIterator = students.iterator();
			while(listIterator.hasNext())
			{
				Student currentStudent = listIterator.next();
				String eMail = currentStudent.getEmail();
				String[] currentDomain = eMail.split("@");
				if (currentDomain[1].equals(domain))
				{
					System.out.println(String.format("%s\t%s\t%d\t%d\t%d\t%d", currentStudent.getName(), currentStudent.getEmail(), currentStudent.getDsMarks(), currentStudent.getOopsMarks(), currentStudent.getJavaMarks(), currentStudent.getTotalMarks()));
				}
			}
		}	
	}
	
	public void findTopScorersByDomain()
	{	
		int max = 0;
		String name = null;
		Iterator<String> listDomainstIterator = domains.iterator();	
		while(listDomainstIterator.hasNext())
		{			
			String domain =  listDomainstIterator.next();
			System.out.println(domain + " : ");
			Iterator<Student> listIterator = students.iterator();
			while(listIterator.hasNext())
			{
				Student currentStudent = listIterator.next();
				String eMail = currentStudent.getEmail();
	     		if(eMail.split("@")[1].equals(domain))
	     		{
	     			max = currentStudent.getTotalMarks();
	     			name = currentStudent.getName();
	     			break;
	     		}
			}
			listIterator = students.iterator();
			while(listIterator.hasNext())
			{
				Student currentStudent = listIterator.next();
				String eMail = currentStudent.getEmail();
	     		if (eMail.split("@")[1].equals(domain) && currentStudent.getTotalMarks()>max)
	     		{
	     			max = currentStudent.getTotalMarks();
	     			name = currentStudent.getName();
	     		}
			}
			System.out.println(name + " - " + max);
		}
	}
	public void findLowestScorersByDomain()
	{	
		int min = 0;
		String name = null;
		Iterator<String> listDomainstIterator = domains.iterator();	
		while(listDomainstIterator.hasNext())
		{			
			String domain =  listDomainstIterator.next();
			System.out.println(domain + " : ");
			Iterator<Student> listIterator = students.iterator();
			while(listIterator.hasNext())
			{
				Student currentStudent = listIterator.next();
				String eMail = currentStudent.getEmail();
	     		if(eMail.split("@")[1].equals(domain))
	     		{
	     			min = currentStudent.getTotalMarks();
	     			name = currentStudent.getName();
	     			break;
	     		}
			}
			listIterator = students.iterator();
			while(listIterator.hasNext())
			{
				Student currentStudent = listIterator.next();
				String eMail = currentStudent.getEmail();
	     		if (eMail.split("@")[1].equals(domain) && currentStudent.getTotalMarks()<min)
	     		{
	     			min = currentStudent.getTotalMarks();
	     			name = currentStudent.getName();
	     		}
			}
			System.out.println(name + " - " + min);
		}
	}
	public void listStudentsOfDomain()
	{
		System.out.println("Enter the name of domain : ");
		String domainEntered = new Scanner(System.in).nextLine();
		Iterator<String> listDomainstIterator = domains.iterator();	
		while(listDomainstIterator.hasNext())
		{
			String domain =  listDomainstIterator.next();
			if (domain.equals(domainEntered))
			{
				Iterator<Student> listIterator = students.iterator();
				while(listIterator.hasNext())
				{
					Student currentStudent = listIterator.next();
					String eMail = currentStudent.getEmail();
		     		if (eMail.split("@")[1].equals(domainEntered))
		     		{
		     			System.out.println(currentStudent.getName() + " -" + currentStudent.getTotalMarks() + " - " + currentStudent.getEmail());
		     		}
				}		
			}
		}
	}
	public void createFile()
	{
		StudentsFile = new File("C:\\My.Self.Learning\\TestData\\Students.txt"); 
		try
		{
			StudentsFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(StudentsFile);
			if (StudentsFile.canWrite())
			{
				System.out.println("File " + StudentsFile.getPath() + " created successfully!");
				for(Student student : students)
				{
					String name = student.getName();
					String dsMarks =  String.valueOf(student.getDsMarks());
					String oopsMarks = String.valueOf(student.getOopsMarks());
					String javaMarks = String.valueOf(student.getJavaMarks());
					String totalMarks = String.valueOf(student.getTotalMarks());
					String eMail = student.getEmail();
					String sep = ",";
					String newLine = " \n";
					fos.write(name.getBytes());
					fos.write(sep.getBytes());
					fos.write(dsMarks.getBytes());
					fos.write(sep.getBytes());
					fos.write(oopsMarks.getBytes());
					fos.write(sep.getBytes());
					fos.write(javaMarks.getBytes());
					fos.write(sep.getBytes());
					fos.write(totalMarks.getBytes());
					fos.write(sep.getBytes());
					fos.write(eMail.getBytes());
					fos.write(newLine.getBytes());
				}			
				fos.flush();
				fos.close();				
			}
			else 
			{
				System.out.println(StudentsFile.getPath() + " is read only. Please make it writable.");
			}
			
		}
		catch(IOException ioe)
		{
			System.out.println("Cannot create a file :" + StudentsFile.getName() + ". Error : " + ioe.getMessage());
		}	
	}
	public void readFromFile()
	{
		String filename = "C:\\My.Self.Learning\\TestData\\Students.txt";
		File file = new File(filename);
		try
		{
			FileReader fr = new  FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null)
			{
				String[]lineArr = line.split(",");				
				String name = lineArr[0];
				int ds = Integer.valueOf(lineArr[1]);
				int oops = Integer.valueOf(lineArr[2]);
				int java = Integer.valueOf(lineArr[3]);
				String eMail = lineArr[5];
				Student student = new Student(name, ds, oops, java,eMail);
			    studentsOnFile.add(student);
			}
			System.out.println("Name\tEmail\tData Structures\tOops\tJava\tTotal Marks");
			for(Student student : studentsOnFile)
			{
				System.out.println(String.format("%s\t%s\t%d\t%d\t%d\t%d", student.getName(), student.getEmail(), student.getDsMarks(), student.getOopsMarks(), student.getJavaMarks(), student.getTotalMarks()));
			}
		}
		catch (IOException ioe)
		{
			System.out.println("cannot open file " + file.getPath());
		}
	}
	
	public void addMoreStudentsToFile()
	{		
		try
		{
			Student student = addStudentData();
			String filename= "C:\\My.Self.Learning\\TestData\\Students.txt";
			FileWriter fw = new FileWriter(filename,true);
			String name = student.getName();
			String dsMarks =  String.valueOf(student.getDsMarks());
			String oopsMarks = String.valueOf(student.getOopsMarks());
			String javaMarks = String.valueOf(student.getJavaMarks());
			String totalMarks = String.valueOf(student.getTotalMarks());
			String eMail = student.getEmail();
			String sep = ",";
			fw.write(name);
			fw.write(sep);
			fw.write(dsMarks);
			fw.write(sep);
			fw.write(javaMarks);
			fw.write(sep);
			fw.write(oopsMarks);
			fw.write(sep);
			fw.write(javaMarks);
			fw.write(sep);
			fw.write(totalMarks);
			fw.write(sep);
			fw.write(eMail);
			fw.write("\n");
			System.out.println("File Appended");
			fw.flush();
			fw.close();
		}
		catch (IOException ioe)
		{
			System.out.println("cannot open file " + StudentsFile.getPath());
		}	
	}
	public void exitProgram()
	{
		System.out.println("Terminated");
		System.exit(0);		
	}
}
