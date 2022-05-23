package wgraph;

import java.util.Iterator;

public class WGraph {
	public double[][] w;

	public WGraph(int n) {
		super();
		this.w = new double[n][n];

		for (int i = 0; i < w.length; i++) {
			for (int j = 0; j < w.length; j++) {
				w[i][j] = Double.POSITIVE_INFINITY;
			}
		}
	}

	public void addEdge(int x, int y, double weight) {
		w[x][y] = weight;
		w[y][x] = weight;
	}

	public void floyd() {
		int n = this.w.length;
		// tao bien
		int[][] p0, p1;
		p0 = new int[n][n];
		p1 = new int[n][n];
		double[][] w0, w1;
		w0 = new double[n][n];

		// copy w sang w0
		w0 = w.clone();

		// khoi tao p0
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (w[i][j] != Double.POSITIVE_INFINITY) {
					p0[i][j] = j;
				} else {
					p0[i][j] = -1;
				}
			}
		}

		// tinh cac ma tran W.k và P.k
		for (int k = 0; k < w0.length; k++) {

			// khoi tao ma tran k1
			w1 = new double[n][n];
			p1 = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (w0[i][j] > w0[i][k] + w0[k][j]) {
						w1[i][j] = w0[i][k] + w0[k][j];
						p1[i][j] = p0[i][k];
					} else {
						w1[i][j] = w0[i][j];
						p1[i][j] = p0[i][j];
					}
				}
			}
			w0 = w1;
			p0 = p1;

			// in ket qua w1
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(w0[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();

			// in ket qua p1

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(p0[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
