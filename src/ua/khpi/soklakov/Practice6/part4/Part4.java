package ua.khpi.soklakov.Practice6.part4;

import ua.khpi.soklakov.Practice6.part4.GraphImpl;
import ua.khpi.soklakov.Practice6.part4.Graph.AbstractGraph;

public class Part4 {

	/**
	 * Main method.
	 * Test graph.
	 * @param args
	 */
	public static void main(String[] args) {
		GraphImpl graph = new GraphImpl();
		AbstractGraph aGraph = graph.createGraph(5);
		System.out.println(graph);
		aGraph.addEdge(0, 1);
		aGraph.addEdge(1, 2);
		aGraph.addEdge(2, 3);
		aGraph.addEdge(3, 4);
		aGraph.addEdge(4, 0);
		System.out.println(graph);
		aGraph.removeEdge(0, 1);
		System.out.println(graph);
		
	}
}
