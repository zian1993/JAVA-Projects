package algorithms_project2;

import java.util.ArrayList;

//This class will run the DFS algorithm on the created Graph
public class DFSrunner {

	public ArrayList<GraphNode> Graph;
	public ArrayList<GraphNode> TopologicalGraph;
	public static int clock;
	
	//Initializer
	public DFSrunner(ArrayList<GraphNode> a)
	{
		Graph = a;
		TopologicalGraph = new ArrayList<GraphNode>();
		
		//Running DFS on the graph
		runDFS();
	}
	
	public void runDFS()
	{
		//Setting clock to zero
		clock = 0;
		//Setting all nodes visited to false.
		for (int i=0; i<Graph.size(); i++)
		{
			Graph.get(i).visited = false;
		}
		
		//Exploring each node of the graph
		for (int z=0; z<Graph.size(); z++)
		{
			if (!Graph.get(z).visited)
				explore (Graph.get(z));
		}
		
	}
	
	public void explore(GraphNode a)
	{
		a.visited = true;
		
		//Setting a's previsit number
		a.previsit = clock++;
		
		for (int i=0; i<a.connection.size(); i++)
		{
			if (!a.connection.get(i).visited)
				explore(a.connection.get(i));
		}
		
		//Setting a's postvisit number
		a.postvisit = clock++;
	}
	
	public void topologicalOrdering()
	{
		//Making an array of all the postvisit numbers first.
		ArrayList<Integer> postvisit = new ArrayList<Integer>();
		
		for (int i=0; i<Graph.size(); i++)
			postvisit.add(Graph.get(i).postvisit);
		
		//Now, sorting the array of postvisit numbers,
		//and storing the newly sorted array.
		postvisit = MergeSortMain(postvisit);
		
		//Finally, making and returning a new graph object,
		//which has been sorted according to the decreasing order of the postvisit numbers.
		for (int x = (postvisit.size()-1); x>=0; x-- )
		{
			for (int z = 0; z<Graph.size(); z++)
			{
				if (Graph.get(z).postvisit == postvisit.get(x))
				{
					TopologicalGraph.add(Graph.get(z));
					break;
				}
			}
		}
		
	}
	
	
	//Sorting code for MergeSort, taken from Project 1.
	public static ArrayList<Integer> MergeSortMain(ArrayList<Integer> a)
	{
		//Defining the base return case
		if (a.size()<=1)
			return a;

		//Defining the rest of the function
		//Declaring some local ArrayLists and half size int
		int halfsize = (a.size()/2);
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();

		for (int k=0; k<halfsize;k++)
		{
			left.add(a.get(k));
		}

		for (int h=halfsize; h<a.size(); h++)
		{
			right.add(a.get(h));
		}

		return MergeSortMerge(MergeSortMain(left), MergeSortMain(right));
	}

	public static ArrayList<Integer> MergeSortMerge(ArrayList<Integer> a, ArrayList<Integer> b)
	{
		//Creating an array to hold both the arrays
		ArrayList<Integer> newarray = new ArrayList<Integer>();

		//Creating the indexes for the left and right arrays
		int l = 0;
		int r = 0;

		//While both arrays are still being read through,
		//use this loop.
		while ((l<a.size())&&(r<b.size()))
		{
			if ((a.get(l))<=(b.get(r)))
			{
				newarray.add(a.get(l));
				l++;
			}

			else
			{
				newarray.add(b.get(r));
				r++;
				//inversions = inversions+(a.size()-l);
			}
		}

		//After one of the arrays are over
		//If left array is still remaining
		while (l<a.size())
		{
			//Copy rest of left array to the new array
			newarray.add(a.get(l));
			l++;
		}

		while (r<b.size())
		{
			//Copy rest of left array to the new array
			newarray.add(b.get(r));
			r++;
		}

		return newarray;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
