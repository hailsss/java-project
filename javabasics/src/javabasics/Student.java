package javabasics;

public class Student {
	private int dsM, oopsM, javaM, totalMarks;
	private String Name, eMail;
	static {
		
	}
	Student(String name, int ds, int oops, int java, String email)
	{
		Name = name;
		dsM = ds;
		oopsM = oops;
		javaM = java;	
		eMail = email;
		totalMarks = dsM + oopsM + javaM; 	
	}
	public int getTotalMarks()
	{
		return(totalMarks);
	}
	public String getName()
	{
		return Name;
	}
	public int getDsMarks()
	{
		return(dsM);
	}
	public int getOopsMarks()
	{
		return(oopsM);
	}
	public int getJavaMarks()
	{
		return(javaM);
	}
	public String getEmail()
	{
		return(eMail);
	}
	
}

