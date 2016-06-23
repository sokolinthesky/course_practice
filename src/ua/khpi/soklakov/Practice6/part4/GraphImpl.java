package ua.khpi.soklakov.Practice6.part4;

import java.util.*;

/**
 *
 * @author Oleg Soklakov
 */
public class GraphImpl implements Graph {
	private ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

	@Override
	public AbstractGraph createGraph(int numberNodes) {
		for (int i = 0; i < numberNodes; i++) {
			edges.add(new ArrayList<Integer>(numberNodes));
			for (int j = 0; j < numberNodes; j++) {
				edges.get(i).add(0);
			}
		}
		return new AbstractGraph(numberNodes) {
			@Override
			public void addEdge(int first, int second) {
				edges.get(first).add(second, 1);
				edges.get(second).add(first, 1);
			}

			@Override
			public void removeEdge(int first, int second) {
				if (isExistEdge(first, second))
					edges.get(first).set(second, 0);
				if (isExistEdge(second, first))
					edges.get(second).set(first, 0);
			}

			@Override
			public boolean isExistEdge(int first, int second) {
				return edges.get(first).get(second) == 1 && edges.get(second).get(first) == 1;
			}
		};
	}

	@Override
	public String toString() {
		String result = "";
		result = result.concat("GraphImpl [edges=" + edges + "]");
		return result;
	}

}
