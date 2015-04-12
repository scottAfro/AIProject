package gmit;

import java.util.*;

public class Astar 
{
	private PriorityQueue<Node> open = null;
	private List<Node> closed = new ArrayList<Node>();
	private HeuristicNodeComparator sorter = new HeuristicNodeComparator();
	private static int nodeCount;
	
	public void search(Node start)
	{
		open = new PriorityQueue<Node>(20, sorter);
		start.setDistanceTravelled(0);
		open.add(start);
		while(!open.isEmpty())
		{
			Node node = open.poll();
			
			if(node.isGoalNode())
			{
				List<Node> path = new ArrayList<Node>();
				while(node.getParent() != null)
				{
					path.add(node);
					node = node.getParent();
				}
				path.add(node);
				Collections.reverse(path);
				System.out.println();
				System.out.println();
				System.out.println();
			}
			pushSuccessors(node);
			closed.add(node);
		}
	}
	
	public void pushSuccessors(Node node)
	{
		Node[] children = node.children();
		for(int i=0; i < children.length; i++)
		{
			nodeCount++;
			Node child = children[i];
			float score = HeuristicCalculator.getHeuristicValue(node.getDistanceTravelled() + node.getDistanceToNode(child),
																child.getGoalDistance(),
																child.getTerrain(),
																child.getDanger());
			if((open.contains(child) || closed.contains(child)) && child.getScore() < score)
			{
				continue;
			}else{
				open.remove(child);
				closed.remove(child);
				child.setParent(node);
				child.setDistanceTravelled(node.getDistanceTravelled() + node.getDistanceToNode(node));
				open.add(child);
			}
		}
	}
	
	public static void main(String[] args) 
	{
		
	}
}
