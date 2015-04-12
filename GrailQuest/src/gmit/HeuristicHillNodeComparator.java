package gmit;

import java.util.*;

public class HeuristicHillNodeComparator implements Comparator<Node>
{

	@Override
	public int compare(Node node1, Node node2)
	{
		if(node1.getApproxDistance() > node2.getApproxDistance())
		{
			return -1;
		}else if(node1.getApproxDistance() < node2.getApproxDistance()){
			return 1;
		}else{
			return 0;
		}
	}
	
}
