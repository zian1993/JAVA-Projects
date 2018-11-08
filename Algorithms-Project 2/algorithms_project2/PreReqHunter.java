package algorithms_project2;

import java.util.ArrayList;

public class PreReqHunter {

		public ArrayList<GraphNode> allCourses;
		public ArrayList<String> list;
		public ArrayList<String> StringList;
		public ArrayList<ArrayList<GraphNode>> allmade;
		
		public PreReqHunter(ArrayList<GraphNode> a)
		{
			allCourses = a;
			list = new ArrayList<String>();
			StringList = new ArrayList<String>();
			
			allmade = new ArrayList<>();
			
			//Making a String list of all the course names
			for (int d=0; d<allCourses.size();d++)
			{
				StringList.add(allCourses.get(d).getCourse());
			}
		}
		
		public void LevelMaker(ArrayList<GraphNode> a, ArrayList<ArrayList<GraphNode>> c)
		{
			
			//Adding the passed in list of nodes to the main list
			c.add(a);
			
			//Making an array of graph nodes of the connections of the passed in nodes
			ArrayList<GraphNode> tobesent = new ArrayList<GraphNode>();
			
			//Making an array list of the previous nodes to be compared to
			ArrayList<GraphNode> previous = new ArrayList<GraphNode>();
			for (int f=0; f<c.size(); f++)
			{
				for (GraphNode j : c.get(f))
					previous.add(j);
			}
			
			//Now checking each of the connections to see if they have only the 
			//prereqs that we have gone through so far
			for (int x=0; x<a.size(); x++)
			{
				for (GraphNode z : a.get(x).connection)
				{
					//If only the list of previously run through courses contain the prereqs for
					//each connection, the connections are added to an array to create the next level.
					if (previous.containsAll(z.preReqs) && (!tobesent.contains(z)))
						tobesent.add(z);	
				}
			}
			
			//Trivial case
			//If no connections are left to add to the main list
			if (tobesent.isEmpty())
				return;
			
			//Recursively calling the function with the connections from the graphnodes
			//passed into this function.
			else
				LevelMaker(tobesent, c);
		}
		
		public ArrayList<GraphNode> startPoint(ArrayList<GraphNode> a)
		{
			ArrayList<GraphNode> returnman = new ArrayList<GraphNode>();
			
			for (GraphNode b: a)
			{
				if (b.preReqs.isEmpty())
					returnman.add(b);
			}
			
			return returnman;
		}
}
