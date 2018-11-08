package algorithms_project2;

import java.util.ArrayList;

public class GraphNode {

	private String course;
	public ArrayList<GraphNode> preReqs;
	public ArrayList<GraphNode> connection;
	public int previsit;
	public int postvisit;
	public boolean visited;
	
	//Constructor
	public GraphNode(String a)
	{
		course = a;
		connection = new ArrayList<GraphNode>();
		preReqs = new ArrayList<GraphNode>();
		previsit = 0;
		postvisit = 0;
		visited = false;
	}
	
	public String getCourse()
	{
		return course;
	}
	
	public void setCourse(String a)
	{
		course = a;
	}
	
	public String toString()
	{
		String returnman = new String();
		//returnman = course + " [" + previsit + "," + postvisit + "]";
		returnman = course;
		
		return returnman;
	}
	
	public String toNameString()
	{
		return course;
	}
}

