package algorithms_project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class AllCourses {

	private ArrayList<Course> allcourses;

	public AllCourses()
	{
		allcourses = new ArrayList<Course>();
	}

	public void readcourse(String a)
	{
		String[] details;
		String[] details1;
		String[] details2;
		
		try {
			Scanner sc = new Scanner(new InputStreamReader(this.getClass().getResourceAsStream(a)));

			while(sc.hasNextLine()){
				String line = sc.nextLine();

				//Splitting string according to ',' here.
				//Making an array of strings from the split.
				if (line.contains("(") && line.contains(")"))
				{
					line = line.replaceAll("\\(", "#");
					details = line.split("#");

					//Add the first part of the string as the new course name.
					allcourses.add(new Course(details[0]));

					//Take off the close bracket.
					details[1] = details[1].substring(0, (details[1].length()-1));

					if (details[1].contains(",")||details[1].contains("and") )
					{
						//If there are only two pre-reqs separated by and
						if(details[1].contains(" and ") && !(details[1].contains(", ")))
						{
							details1 = details[1].split(" and ");

							//Add the part before and after the and to the pre-reqs list
							allcourses.get(allcourses.size()-1).addpreq(details1[0]);
							allcourses.get(allcourses.size()-1).addpreq(details1[1]);
						}

						//IF there are multiple prereqs, but no 'and' separator, and just ', '
						else if (!details[1].contains(" and ") && (details[1].contains(", ")))
						{
							//Break the remaining string at the commas
							details1 = details[1].split(", ");

							//Add each of the splits as a prereq.
							for (int b = 0; b<details1.length; b++)
							{
								//If the string contains only numbers, then we need to add
								//the course abbreviation before it, to it.
								if (details1[b].matches("^[0-9]+$"))
								{
									//Split the previous course, to get the course abbreviation from it.
									details2 = details1[b-1].split(" ");
									//Add the abbreviation to the course number.
									details1[b] = details2[0] +" "+ details1[b];
								}
								//Add the course as prereq.
								allcourses.get(allcourses.size()-1).addpreq(details1[b]);
							}
						}
					}
					//If there is just one prereq, add it to course.
					else
					{
						allcourses.get(allcourses.size()-1).addpreq(details[1]);
					}
				}

				//If the string does not contain brackets, then just add that string as the course name
				else
					allcourses.add(new Course(line));

			}
		}catch (Exception e){         
			e.printStackTrace();}
	}
	
	
	public ArrayList<Course> getallcourses()
	{
		return allcourses;
	}
	
	public String toString()
	{
		String returnman = new String();
		
		returnman = "All Courses: ";
		
		for (int i=0; i<allcourses.size(); i++)
		{
			returnman += "\n"+allcourses.get(i).toString();
		}
		
		return returnman;
	}

}
