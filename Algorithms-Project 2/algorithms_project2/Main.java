package algorithms_project2;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Initiating a course generator object
		AllCourses generator = new AllCourses();
		
		//Reading the course names from the file.
		generator.readcourse("/algorithms_project2/allcourses.txt");
		
		//Printing out all the courses read from file.
		//System.out.println(generator.toString());
		
		//Making the graph using the data read from the file.
		GraphMaker Graph = new GraphMaker(generator.getallcourses());
		
		//Feeding the created graph into the DFS runner
		DFSrunner DFSalgorithm = new DFSrunner(Graph.Graph);
		
		//At this point DFS has been run on the graph.
		//Next step: topological ordering according to decreasing
		//post-visit numbers.
		
		//Printing DFS run graph so far
		//System.out.println(Graph);
		
		//Calling the topological-ordering function on the DFS run graph
		DFSalgorithm.topologicalOrdering();
		
		/*Printing DFS run, and topologically ordered graph
		for (int i=0; i<DFSalgorithm.TopologicalGraph.size(); i++)
		{
			System.out.println(DFSalgorithm.TopologicalGraph.get(i).toNameString());
		}*/
		
		
		//***********************************************************************
		//BONUS PORTION
		//***********************************************************************
		
		//Listing all courses that can be taken together at any one time.
		
		//Feeding our graph into our pre-req hunters
		//which will make a list of list of courses with the same prereqs.
		PreReqHunter bonus = new PreReqHunter(Graph.Graph);
		
		//Making the startpoint to call the next recursive function
		//Passing the startpoint into function to find all levels.
		//Calling the function to parse data according to their prereqs
		bonus.LevelMaker(bonus.startPoint(Graph.Graph), bonus.allmade);
		
		//Printing the final list of list of courses arranged according to their prereq
		//requirements.
		for (int i=0; i<bonus.allmade.size(); i++)
		{
			System.out.println(bonus.allmade.get(i));
		}
		
		
	}	

}
