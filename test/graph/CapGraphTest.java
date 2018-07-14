package graph;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import util.GraphLoader;

class CapGraphTest {
	
	private Graph graph;
	private HashSet<Integer> testSetForKey8 = new HashSet<>(Arrays.asList(7,9,12));
	private HashSet<Integer> testSetForEgonet6Key4 = new HashSet<>(Arrays.asList(5,6));



	@BeforeEach
	void setUp() throws Exception {
		graph = new CapGraph();
		GraphLoader.loadGraph(graph, "./data/small_test_graph.txt");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		HashMap<Integer, HashSet<Integer>> exported = graph.exportGraph();
		System.out.println(exported.toString());
		assertTrue(exported.get(8).containsAll(testSetForKey8));
	}
	

	@Test
	void testEgonet() {
		Graph testEgonet = graph.getEgonet(6);
		System.out.println(testEgonet.exportGraph().toString());
		assertTrue(testEgonet.exportGraph().get(4).containsAll(testSetForEgonet6Key4));
	}

}
