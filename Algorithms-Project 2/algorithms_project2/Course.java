package algorithms_project2;

import java.util.ArrayList;

//This class is the data structure for a course.
public class Course {

	private String name;
	private ArrayList<String> prereqs;

	//Constructor
	public Course()
	{
		name = new String();
		prereqs = new ArrayList<String>();
	}

	//Parameterized constructor
	public Course(String a)
	{
		name = new String(a);
		prereqs = new ArrayList<String>();
	}

	//Parameterized constructor
	public Course(String a, ArrayList<String> b)
	{
		name = new String(a);
		prereqs = new ArrayList<String>();
		prereqs = b;
	}

	//Function for adding courses to the prereqs
	public void addpreq (String a)
	{
		prereqs.add(a);
	}

	//Function for returning all prereqs
	public ArrayList<String> getpreqs ()
	{
		return prereqs;
	}

	public String getName()
	{
		return name;
	}

	public String toString()
	{
		String returnman = new String();

		returnman = name;

		if (prereqs.size()!=0)
		{
			returnman += " PreReqs: [";
			for (int i=0; i<prereqs.size(); i++)
			{
				returnman +=  " "+prereqs.get(i);
			}
			returnman += "]";
		}
		return returnman;
	}
}
