/**
 * Scott Kennedy
 * This Class is to create the node graph
 * for the text adventure
 */
package gmit;

import java.util.*;

public class Node 
{
	private String nodeName;	
	private Node parent;
	private Map<Node, Integer> children = new HashMap<Node, Integer>();
	private boolean visited = false;
	private boolean goalNode;
	private int approxDistance = 0;
	private int distanceTravelled = 0;
	private float terrain = 0.0f;
	private float danger = 0.0f;
	
	public Node(String nodeName)
	{
		this.nodeName = nodeName;
	}	
	
	public Node(String nodeName, int approxDistance) 
	{
		this.nodeName = nodeName;
		this.approxDistance = approxDistance;
	}

	public String getNodeName()
	{
		return nodeName;
	}

	public void setNodeName(String nodeName)
	{
		this.nodeName = nodeName;
	}	

	public Node getParent() 
	{
		return parent;
	}

	public void setParent(Node parent) 
	{
		this.parent = parent;
	}
	
	public Node[] children()
	{
		return (Node[]) children.keySet().toArray(new Node[children.size()]);
	}
	
	public boolean isLeaf()
	{
		if(children.size() > 0)
		{
			return false;
		}else{
			return true;
		}
	}
	
	public void addChildNode(Node child, int distance)
	{
		children.put(child, new Integer(distance));
	}
	
	public void removeChild(Node child)
	{
		children.remove(child);
	}
	
	public int getDistanceToNode(Node n)
	{
		return children.get(n);
	}
	
	public int getChildNodeCount()
	{
		return children.size();
	}
	
	public boolean isVisited()
	{
		return visited;
	}

	public void setVisited(boolean visited) 
	{
		this.visited = visited;
	}

	public boolean isGoalNode()
	{
		return goalNode;
	}

	public void setGoalNode(boolean goalNode) 
	{
		this.goalNode = goalNode;
	}
	
	public int getGoalDistance()
	{
		return approxDistance;
	}

	public float getTerrain()
	{
		return terrain;
	}

	public void setTerrain(float terrain) 
	{
		this.terrain = terrain;
	}

	public float getDanger()
	{
		return danger;
	}

	public void setDanger(float danger)
	{
		this.danger = danger;
	}	
	
	public int getApproxDistance() 
	{
		return approxDistance;
	}

	public void setApproxDistance(int approxDistance)
	{
		this.approxDistance = approxDistance;
	}

	public int getDistanceTravelled()
	{
		return distanceTravelled;
	}

	public void setDistanceTravelled(int dept) 
	{
		this.distanceTravelled = dept;
	}
	
	public float getScore()
	{
		return HeuristicCalculator.getHeuristicValue(distanceTravelled,approxDistance, terrain, danger);
	}

	@Override
	public String toString() 
	{
		return this.nodeName;
	}	
	
}
