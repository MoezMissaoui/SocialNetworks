/**
 * 
 */
package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author Your name here.
 * 
 * For the warm up assignment, you must implement your Graph in a class
 * named CapGraph.  Here is the stub file.
 *
 */
public class CapGraph implements Graph {
	
	HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();

	/* (non-Javadoc)
	 * @see graph.Graph#addVertex(int)
	 */
	@Override
	public void addVertex(int num) {
		if(!graph.containsKey(num)) {
			graph.put(num, new HashSet<>());
		}
	}

	/* (non-Javadoc)
	 * @see graph.Graph#addEdge(int, int)
	 */
	@Override
	public void addEdge(int from, int to) {
			if(!graph.get(from).contains(to)) {
				graph.get(from).add(to);
			}
	}

	/* (non-Javadoc)
	 * @see graph.Graph#getEgonet(int)
	 */
	@Override
	public Graph getEgonet(int center) {
		Graph egonet = new CapGraph();
		
		//add vertices
		egonet.addVertex(center);
		for(int friend : graph.get(center)) {
			egonet.addVertex(friend);
			egonet.addEdge(center, friend);
			egonet.addEdge(friend, center);
			HashSet<Integer> friendsOfFriend = graph.get(friend);
			friendsOfFriend.retainAll(graph.get(center));
			for(int mutual : friendsOfFriend) {
				egonet.addEdge(friend,  mutual);
			}
		}
		return egonet;
	}

	/* (non-Javadoc)
	 * @see graph.Graph#getSCCs()
	 */
	@Override
	public List<Graph> getSCCs() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see graph.Graph#exportGraph()
	 */
	@Override
	public HashMap<Integer, HashSet<Integer>> exportGraph() {
		HashMap<Integer, HashSet<Integer>> exportedGraph = new HashMap<>();
		exportedGraph.putAll(graph);
		return exportedGraph;
	}

}
