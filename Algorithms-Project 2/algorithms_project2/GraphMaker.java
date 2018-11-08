package algorithms_project2;

import java.util.ArrayList;

//This class will construct the graph
public class GraphMaker {

	private ArrayList<Course> allCourses;
	public ArrayList<GraphNode> Graph;
	
	//Constructor
	public GraphMaker(ArrayList<Course> a)
	{
		allCourses = a;
		Graph = new ArrayList<GraphNode>();
		
		//Making the graph
		graphMaker();
	}
	
	//Make the graph using the list of courses
	public void graphMaker()
	{
		//Making the main graph nodes
		for (int i=0; i<allCourses.size(); i++)
		{
			Graph.add(new GraphNode(allCourses.get(i).getName().substring(0, 9)));
		}
		
		//Now connecting the graph using the prereqs
		for (int a=0; a<allCourses.size(); a++)
		{
			for (int b=0; b<allCourses.size(); b++)
			{
				if (allCourses.get(b).getpreqs().contains(allCourses.get(a).getName().substring(0, 9)))
				{
					Graph.get(a).connection.add(Graph.get(b));
					Graph.get(b).preReqs.add(Graph.get(a));
				}
			}
		}
		//Connections are made at this point, and hence graph is complete.
	}
	
	public String toString()
	{
		String returnman = new String();
		
		for (int i=0; i<Graph.size(); i++)
		{
			returnman += Graph.get(i).toString() + "\n";
		}
		
		return returnman;
	}
	
	public String toNameString()
	{
		String returnman = new String();
		
		for (int i=0; i<Graph.size(); i++)
		{
			returnman += Graph.get(i).toNameString() + "\n";
		}
		
		return returnman;
	}
}
