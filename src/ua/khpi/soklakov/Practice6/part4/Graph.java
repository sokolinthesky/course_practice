 package ua.khpi.soklakov.Practice6.part4;

public interface Graph {
	/**
	 * @param numberNodes
	 *            Number of nodes.
	 * @return Count the specified configuration.
	 */
	AbstractGraph createGraph(int numberNodes);

	/**
	 * Abstract graph. When you create a given number of vertices.
	 */
	abstract class AbstractGraph {

		/** The number of nodes */
		protected final int numberNodes;

		public AbstractGraph(int numberNodes) {
			this.numberNodes = numberNodes;
		}

		/**
		 * Adding edge to graph.
		 * 
		 * @param first
		 *            The first binding top.
		 * @param second
		 *            The second binding top.
		 */
		public abstract void addEdge(int first, int second);

		/**
		 * Remove edge from graph.
		 * 
		 * @param first
		 *            First top.
		 * @param second
		 *            Second top.
		 */
		public abstract void removeEdge(int first, int second);

		/**
		 * Checking the ribs.
		 * 
		 * @param first
		 *            First top.
		 * @param second
		 *            Second top.
		 */
		public abstract boolean isExistEdge(int first, int second);
	}

}
