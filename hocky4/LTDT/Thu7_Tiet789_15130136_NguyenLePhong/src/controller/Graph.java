package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

import model.Edge;

public abstract class Graph {
	public int[][] matrixA;

	public Graph(int[][] matrixA) {
		super();
		this.matrixA = matrixA;
	}

	public Graph() {

	}

	public int topNum() {
		return (this.matrixA != null) ? this.matrixA.length : 0;
	}

	// Bat dau tuan 1
	//them dinh
	public boolean addTop() {
		int newTopNum = topNum() + 1;
		try {
			int[][] a = new int[newTopNum][newTopNum];
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a.length; j++) {
					a[i][j] = this.matrixA[i][j];
				}
			}
			this.matrixA = a;
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	//xoa dinh
	public boolean removeTop() {
		int newTopNum = topNum();
		try {
			int[][] a = new int[newTopNum - 1][newTopNum - 1];
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					a[i][j] = this.matrixA[i][j];
				}
			}
			this.matrixA = a;

		} catch (Exception e) {
			return false;
		}
		return true;
	}
	//them canh
	public abstract boolean addEdge(int x, int y);
	//xoa canh
	public abstract boolean removeEdge(int x, int y);
	
	//in ma tran nhan vao
	public void printMatrix() {
		for (int i = 0; i < matrixA.length; i++) {
			for (int j = 0; j < matrixA.length; j++) {
				System.out.print(matrixA[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	//duyet do thi dung thuat toan dfs
	public abstract int browseGraphWithDFS(int i);
	//duyet do thi dung thuat toan bfs
	public abstract void browseGraphWithBFS(int i);

	//tinh bac cua dinh
	public abstract int topDegree(int x);
	//tinh bac cua do thi
	public abstract int allTopDegree();
	//Tinh so canh cua do thi
	public abstract int edgeNum();
	// Ket thuc tuan 1

	// Bat dau tuan 2
	//Tim duong di tu dinh x toi dinh y
	public abstract int findPathFromXToY(int x, int y);
	
	//Kiem tra tinh lien thong cua do thi
	public abstract void checkContinuityOfGraph();

	//Kiem tra do thi nhan vao co phai la do thi con khong?
	public boolean checkIsSubGraph(Graph g) {
		int[][] matrixX = g.matrixA;
		if (matrixX.length > matrixA.length)
			return false;
		if (matrixX == matrixA)
			return true;
		ArrayList<Edge> supperGraph = new ArrayList<>();
		ArrayList<Edge> subGraph = new ArrayList<>();

		if (matrixX.length < matrixA.length) {
			supperGraph = getListEdgeOfGraph(this);
			subGraph = getListEdgeOfGraph(g);
		}
		if (checkIsSubList(supperGraph, subGraph))
			return true;
		return false;
	}
	//Lay ra danh sach canh cua do thi
	public ArrayList<Edge> getListEdgeOfGraph(Graph g) {
		ArrayList<Edge> list = new ArrayList<>();
		for (int i = 0; i < g.matrixA.length; i++) {
			for (int j = 0; j < g.matrixA[0].length; j++) {
				if (g.matrixA[i][j] != 0) {
					list.add(new Edge(i, j));
				}
			}
		}
		return list;
	}
	
	//Kiem tra danh sach nay co la con cua danh sach kia khong
	public boolean checkIsSubList(ArrayList<Edge> list, ArrayList<Edge> listSub) {
		int count = 0;
		for (int i = 0; i < listSub.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if ((listSub.get(i).getX() == list.get(j).getX()) && (listSub.get(i).getY() == list.get(j).getY())) {
					count++;
				}
			}
		}
		if (count == listSub.size())
			return true;
		return false;
	}
	// Ket thuc tuan 2

	// Bat dau tuan 3
	//Tim thanh phan lien thong cua do thi
	public abstract void findConponentsContinuity();
	//Kiem tra do thi co luong phan khong
	public abstract boolean checkDichotomousGraph();
	// Ket thuc tuan 3

	// Bat dau tuan 4
	//Tim duong di euler
	public abstract boolean eulerPath();
//Tim chu trinh euler
	public abstract boolean eulerCycle();
//Kiem tra do thi co duong di euler khong
	public abstract boolean isHasEulerPath();
//Kiem tra do thi co chu trinh euler khong
	public abstract boolean isHasEulerCycle();
	// Ket thuc tuan 4

	// Bat dau tuan 5
	//Kiem tra do thi co chu trinh hamilton khong
	public abstract boolean checkHamiltonCycle();
//Kiem tra do thi co duong di hamilton khong
	public abstract boolean checkHamiltonPath();
//Tim duong di hamlilton
	public abstract void hamiltonianPath();
//Tim chu trinh hamilton
	public abstract void hamiltonianCycle(int index);
	// Ket thuc tuan 5

	// Bat dau tuan 6
	//Duyet cay dung dfs
	public abstract int[][] DFSTree(int index);

	//Duyet cay dung bfs
	public abstract int[][] BFSTree(int index);
	//Tim cay bao trum dung thuat toan kruskal
	public int[][] krusKal() {
		int tree[][] = new int[topNum()][topNum()];
		int totalWeight = 0;

		List<Edge> listEdge = new ArrayList<>();
		for (int i = 0; i < topNum(); i++) {
			for (int j = 0; j < topNum(); j++) {
				int value = matrixA[i][j];
				if (value > 0) {
					listEdge.add(new Edge(i, j, value));
				}
			}
		}

		Collections.sort(listEdge, new Comparator<Edge>() {
			public int compare(Edge e1, Edge e2) {
				return e1.getW() - e2.getW();
			}
		});

		for (int i = 0; i < listEdge.size(); i++) {
			if (i % 2 != 0) {
				Edge ed = listEdge.get(i);
				if (!checkHasCycle(ed.getX(), ed.getY(), tree)) {
					tree[ed.getX()][ed.getY()] = ed.getW();
					tree[ed.getY()][ed.getX()] = ed.getW();
					totalWeight += ed.getW();
				}
			}
		}
		System.out.println("Duyet cay bao trum tu dinh 0:");
		DFSTree(tree, 0);
		System.out.println("Tong trong so la: " + totalWeight);
		return tree;
	}
	//in ra duong di dfs cua mot cay theo mot dinh cho truoc
	private void DFSTree(int[][] tree, int index) {
		Stack<Integer> stack = new Stack<>();
		int visit[] = new int[topNum()];
		ArrayList<Integer> listVS = new ArrayList<>();

		visit[index] = 1;
		stack.push(index);
		listVS.add(index);
		while (!stack.isEmpty()) {
			int i = stack.peek();
			int count = 0;
			for (int j = 0; j < visit.length; j++) {
				if (tree[i][j] > 0 && visit[j] != 1) {
					stack.push(j);
					visit[j] = 1;
					listVS.add(j);
					break;
				} else {
					count++;
				}
			}
			if (count == visit.length)
				stack.pop();
			if (listVS.size() == topNum()) {
				print(listVS);
				return;
			}
		}

	}

	private void print(ArrayList<Integer> listVisit) {
		String string = "";
		String temp = " ==> ";
		for (int k = 0; k < listVisit.size(); k++) {
			string += listVisit.get(k);
			if (k < listVisit.size() - 1) {
				string += temp;
			}
		}
		System.out.println(string);
	}
//kiem tra xem canh cua do thi co tao canh hay khong
	private boolean checkHasCycle(int x, int y, int[][] tree) {
		int numberPoint = topNum();
		ArrayList<Integer> queue = new ArrayList<Integer>();
		boolean[] visit;
		visit = new boolean[numberPoint];
		visit[x] = true;
		queue.add(0, x);
		while (queue.size() > 0) {
			x = queue.get(queue.size() - 1);
			queue.remove(queue.size() - 1);
			if (x == y) {
				return true;
			}
			for (int j = 0; j < numberPoint; j++) {
				if (tree[x][j] > 0 && !visit[j]) {
					visit[j] = true;
					queue.add(0, j);
				}
			}
		}
		return false;

	}
	// Ket thuc tuan 6

	// Bat dau tuan 7
	//Tim cay bao trum dung thuat toan prim
	public int[][] prim(int index) {
		int start = index;
		int n = topNum();
		int tree[][] = new int[n][n];
		int totalWeight = 0;
		List<Edge> listEdge = new ArrayList<>();
		int visit[][] = new int[n][n];
		int countEdgeAdd = 0;

		visit[index][index] = 1;

		while (countEdgeAdd <= n - 1) {
			int i = 0;
			for (i = 0; i < visit.length; i++) {
				if (matrixA[index][i] > 0 && (visit[index][i] != 1 || visit[i][index] != 1)) {
					listEdge.add(new Edge(index, i, matrixA[index][i]));
					visit[i][index] = 1;
					visit[index][i] = 1;
					System.out.println(index + ":" + i + " : w=" + matrixA[index][i]);
				}
				if (i == visit.length - 1) {
					listEdge = sort(listEdge);
					Edge ed = listEdge.remove(0);
					while (checkHasCycle(ed.getX(), ed.getY(), tree)) {
						ed = listEdge.remove(0);
					}
					index = ed.getY();
					System.out.println(ed);
					tree[ed.getX()][ed.getY()] = ed.getW();
					tree[ed.getY()][ed.getX()] = ed.getW();
					totalWeight += ed.getW();
					countEdgeAdd++;
					break;
				}
			}
			if (countEdgeAdd == n - 1)
				break;

		}
		System.out.println("Duyet cay bao trum tu dinh 0:");
		DFSTree(tree, start);
		System.out.println("Tong trong so la: " + totalWeight);
		return tree;
	}

	public List<Edge> sort(List<Edge> list) {
		Collections.sort(list, new Comparator<Edge>() {
			public int compare(Edge e1, Edge e2) {
				return e1.getW() - e2.getW();
			}
		});
		return list;
	}
	// Ket thuc tuan 7

	// Bat dau tuan 8
	//Tim duong di ngan nhat dung thuat toan dijsktra
	public ArrayList<Integer> dijsktra(int x, int y) {
		List<Integer> listR = new ArrayList<>();
		Map<Integer, Integer> mapL = new HashMap<>();
		Map<Integer, Integer> mapP = new HashMap<>();

		for (int i = 0; i < topNum(); i++) {
			listR.add(i);
			mapL.put(i, Integer.MAX_VALUE);
			mapP.put(i, 0);
		}
		mapL.replace(x, 0);

		int v = searchMin(listR, mapL);
		while (!listR.isEmpty()) {
			v = searchMin(listR, mapL);
			System.out.println("Select vertex v= " + v);
			for (int i = 0; i < listR.size(); i++) {
				if (v == listR.get(i))
					listR.remove(i);
			}

			for (int i = 0; i < this.matrixA.length; i++) {
				// If (L[i]> L[v]+w[v][i]) then L[i]:=L[v]+w[v][i]; P[i]=v;
				if (this.matrixA[v][i] != 0) {
					if (mapL.get(i) > (mapL.get(v) + this.matrixA[v][i])) {
						mapL.replace(i, mapL.get(v) + this.matrixA[v][i]);
						System.out.println("map L tai dinh i:" + i + " la: " + mapL.get(i));
						mapP.put(i, v);
					}
				}
			}
			if (v == y)
				break;

		}

		System.out.println("map L: \n" + mapL.values());
		System.out.println("map P: \n" + mapP.values());

		System.out.println("Resuit");
		return printDijsktra(x, y, mapL, mapP);
	}

	private ArrayList<Integer> printDijsktra(int vertex, int y, Map<Integer, Integer> mapL,
			Map<Integer, Integer> mapP) {
		String delimited = "==>";
		ArrayList<Integer> list = new ArrayList<>();
		for (int v = mapL.size() - 1; v >= 0; v--) {
			if (y != 0 && v != y)
				continue;
			List<Integer> listPath = new ArrayList<>();
			int continute = mapP.get(v);
			String path = "";

			list.add(v);
			listPath.add(v);

			while (continute != vertex) {
				list.add(continute);
				listPath.add(continute);
				continute = mapP.get(continute);
			}
			list.add(vertex);
			listPath.add(vertex);
			// in duong dan
			for (int k = listPath.size() - 1; k >= 0; k--) {
				path += listPath.get(k);
				if (k > 0) {
					path += delimited;
				}
			}
			// sau khi in duong dan thi tao list moi de chua
			listPath.removeAll(listPath);
			System.out.println(path + " has w =" + mapL.get(v));
			list.add(mapL.get(v));
		}
		return list;

	}
	//tim duong di ngan nhat dung thuat toan dijsktra thuan tuy
	public void dijsktra(int x) {
		List<Integer> listR = new ArrayList<>();
		Map<Integer, Integer> mapL = new HashMap<>();
		Map<Integer, Integer> mapP = new HashMap<>();

		for (int i = 0; i < topNum(); i++) {
			// tap dinh
			listR.add(i);
			// khoi tao trong so
			mapL.put(i, Integer.MAX_VALUE);
			// khoi tao duong di ngan nhat
			mapP.put(i, 0);
		}
		// bat dau tai dinh nao thi dinh do mac dinh la 0
		mapL.replace(x, 0);

		int v;
		while (!listR.isEmpty()) {
			// dinh v trong R co trong so mapL[v] nho nhat
			v = searchMin(listR, mapL);
			System.out.println("Select vertex v= " + v);
			// xoa dinh vua tim duoc trong list R
			for (int i = 0; i < listR.size(); i++) {
				if (v == listR.get(i))
					listR.remove(i);
			}

			for (int i = 0; i < this.matrixA.length; i++) {
				// If (L[i]> L[v]+w[v][i]) then L[i]:=L[v]+w[v][i]; P[i]=v;
				if (this.matrixA[v][i] != 0) {
					if (mapL.get(i) > (mapL.get(v) + this.matrixA[v][i])) {
						mapL.replace(i, mapL.get(v) + this.matrixA[v][i]);
						System.out.println("map L tai dinh i:" + i + " la: " + mapL.get(i));
						mapP.put(i, v);
					}
				}
			}

		}

		System.out.println("map L: \n" + mapL.values());
		System.out.println("map P: \n" + mapP.values());

		System.out.println("Resuit");
		printDijsktra(x, 0, mapL, mapP);
	}

	public Integer searchMin(List<Integer> listR, Map<Integer, Integer> mapL) {
		Map<Integer, Integer> mapTmp = new HashMap<>();
		for (Integer i : listR) {
			mapTmp.put(i, mapL.get(i));
		}
		List<Integer> listTmp = mapTmp.values().stream().collect(Collectors.toList());
		Collections.sort(listTmp);
		System.out.println("sort list tmp:" + listTmp);

		for (int i = 0; i < mapL.size(); i++) {
			if (mapL.get(i) == listTmp.get(0)) {
				return i;
			}
		}
		return 0;
	}
	//Tim duong di ngan nhat tu dinh x den dinh y co di qua dinh r dung dijsktra
	public void dijsktra(int x, int r, int y) {
		int w = 0;
		ArrayList<Integer> listA = dijsktra(x, r);
		ArrayList<Integer> listB = dijsktra(r, y);
		w = listA.remove(listA.size() - 1);
		w += listB.remove(listB.size() - 1);
		listA.remove(0);
		listB.addAll(listA);
		String delimited = "==>";
		String path = "";
		for (int k = listB.size() - 1; k >= 0; k--) {
			path += listB.get(k);
			if (k > 0) {
				path += delimited;
			}
		}
		System.out.println(path + " has w=" + w);

	}
	// Ket thuc tuan 8

	// Bat dau tuan 9
	private int maxValue = 1000;
	public int P[];
	public int L[];
	//Tim duong di ngan nhat dung thuat toan bell man ford
	public void bellmanFord(int source) {
		// Khoi tao
		int n = topNum();
		// Cho nao gia tri =0 doi lai la vo cung
		for (int i = 0; i < matrixA.length; i++) {
			for (int j = 0; j < matrixA.length; j++) {
				if (matrixA[i][j] == 0)
					matrixA[i][j] = maxValue;
			}
		}
		P = new int[n];
		L = new int[n];
		for (int i = 0; i < L.length; i++) {
			L[i] = maxValue;
		}
		L[source] = 0;

		boolean stop = false;
		int k = 0;
		while (!stop) {
			stop = true;
			k = k + 1;
			for (int i = 0; i < L.length; i++) {
				for (int j = 0; j < L.length; j++) {
					if (matrixA[i][j] > 0 && matrixA[i][j] < maxValue) {
						if (L[j] > L[i] + matrixA[i][j]) {
							// System.out.println(i + " " + j + " " +
							// matrixA[i][j]);
							L[j] = L[i] + matrixA[i][j];
							P[j] = i;
							stop = false;
						}
					}
				}
			}
			if (k > n) {
				if (stop = false)
					System.out.println("Graph have negative cycle");
				stop = true;
			}
		}
//		 viewPathBellmanFord(source, P, L);
	}

	public void bellmanFord(int source, int destination) {
		bellmanFord(source);
		viewPathBellmanFord(source, P, L, destination);
	}

	private void viewPathBellmanFord(int source, int[] path, int[] weight, int destination) {
		String delimited = " --> ";
		String p = "";
		System.out.println("Distance from " + source + " to " + destination + " is:" + weight[destination]);
		int vertex = destination;
		while (vertex != source) {
			vertex = path[vertex];
			p = vertex + delimited + p;
		}
		p += destination;
		System.out.println(p);
	}

	public void viewPathBellmanFord(int source, int[] path, int[] weight) {
		String delimited = " --> ";
		for (int i = 0; i < matrixA.length; i++) {
			String p = "";
			System.out.println("Distance from " + source + " to " + i + " is:" + weight[i]);
			int vertex = i;
			while (vertex != source) {
				vertex = path[vertex];
				p = vertex + delimited + p;
			}
			p += i;
			System.out.println(p);
		}
	}
	// Ket thuc tuan 9

	// Phuong thuc nhan vao ma tran tu file txt
	public boolean loadData(String path) {
		Path file = Paths.get(path);
		Charset charset = Charset.forName("US-ASCII");
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
			String line = null;
			int count = 0;
			while ((line = reader.readLine()) != null) {
				String k[] = line.split(" ");
				if (k.length == 1) {
					this.matrixA = new int[Integer.parseInt(k[0])][Integer.parseInt(k[0])];
				} else {
					for (int i = 0; i < this.matrixA.length; i++) {
						this.matrixA[count][i] = Integer.parseInt(k[i]);
					}
					count++;
				}
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
			return false;
		}
		return true;
	}
	//in ra ma tran 2 chieu cua mot cay
	public void printTree(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j] + "\t\t");
			}
			System.out.println();
		}
	}
}
