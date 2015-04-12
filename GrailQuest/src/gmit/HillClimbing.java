package gmit;

import java.util.*;

public class HillClimbing 
{
	LinkedList<Node> queue = new LinkedList<Node>();
	List<Node> closed = new ArrayList<Node>();
	HeuristicHillNodeComparator sorter = new HeuristicHillNodeComparator();
	
	public void search(Node node)
	{
		queue.addFirst(node);
		while(!queue.isEmpty())				
		{
			queue.removeFirst();
			closed.add(node);
			System.out.println(node.getNodeName());
			if(node.isGoalNode())
			{
				System.out.println();
				System.out.println();
				System.out.println();
			}else{
				Node[] children = node.children();
				Collections.sort(Arrays.asList(children), sorter);
				for(int i = 0; i < children.length; i++)
				{
					if(!children[i].isVisited() & !queue.contains(children[i]))
					{
						children[i].setParent(node);
						queue.addFirst(children[i]);
					}
				}
				System.out.println(queue);
				node = queue.getFirst();
				node.setVisited(true);
			}
		}
	}
	
	private int calcTotalDistanceTravelled()
	{
		int totalDistance = 0;
		for(int j = 0; j < closed.size(); j++)
		{
			Node n = closed.get(j);
			Node parent = n.getParent();
			if(parent != null)
			{
				totalDistance = totalDistance + parent.getDistanceToNode(n);
			}
		}
		return totalDistance;
	}
	
	public static void main(String[] args)
	{
		
	}
}
