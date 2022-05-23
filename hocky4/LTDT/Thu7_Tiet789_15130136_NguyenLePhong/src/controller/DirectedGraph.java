package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DirectedGraph extends Graph{
	int visitDir[] = null;
	int[][] oldSave = null;
	String path;
	int[][] P = null;

	public DirectedGraph() {

	}

	public DirectedGraph(String path) {
		this.path = path;
		this.loadData(path);
		// Array contain path use floyd algorithm
		P = new int[matrixA.length][matrixA.length];
	}
	//Bat dau tuan 1
	@Override
	public boolean addEdge(int x, int y) {
		int vertexCount = topNum();
		if (x >= 0 && x < vertexCount && y >= 0 && y < vertexCount) {
			this.matrixA[x][y] = 1;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean removeEdge(int x, int y) {
		int vertexCount = topNum();
		if (x >= 0 && x < vertexCount && y >= 0 && y < vertexCount) {
			this.matrixA[x][y] = 0;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int browseGraphWithDFS(int i) {
		// Khong dung de quy
		int numberPoint = topNum();
		// stack de phong ngua truong hop quay lui
		Stack<Integer> stack = new Stack<Integer>();
		// list de luu danh sach duong di da qua
		ArrayList<Integer> listVisit = new ArrayList<>();
		// arr danh dau da qua
		int[] visit = new int[numberPoint];
		// dau tien add dinh da cho vao
		visit[i] = 1;
		listVisit.add(i);
		stack.push(i);
		// chung nao stack con la ok
		while (!stack.empty()) {
			// bien count de kiem tra khi nao can lay phan tu ra khoi stack
			int count = 0;
			i = stack.peek();
			// duyet va kiem tra
			for (int j = 0; j < visit.length; j++) {
				if (this.matrixA[i][j] > 0 && visit[j] == 0) {
					// neu ok thi them vao list di qua
					listVisit.add(j);
					visit[j] = 1;
					stack.push(j);
					// neu them roi thi dung lai vi theo nguyen tac cuon
					break;
				} else {
					count++;
				}
			}
			if (count == visit.length) {
				stack.pop();
			}
		}
		this.visitDir = visit;
		// in ra duong di
		graphToString(listVisit);
		return listVisit.size();
	}

	public void graphToString(ArrayList<Integer> listVisit) {
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

	@Override
	public void browseGraphWithBFS(int i) {
		int numberPoint = topNum();
		ArrayList<Integer> queue = new ArrayList<Integer>();
		ArrayList<Integer> listVisit = new ArrayList<>();
		boolean[] visit;
		visit = new boolean[numberPoint];
		visit[i] = true;
		// add vao dau
		queue.add(0, i);
		while (queue.size() > 0) {
			// lay ra o cuoi ==> nguyen tac FIFO
			i = queue.get(queue.size() - 1);
			queue.remove(queue.size() - 1);
			// them vao mang visit
			listVisit.add(i);
			for (int j = 0; j < numberPoint; j++) {
				if (this.matrixA[i][j] > 0 && !visit[j]) {
					visit[j] = true;
					// neu ok thi add vao dau va quay lai lay ra o cuoi
					queue.add(0, j);
				}
			}
		}
		// toString
		graphToString(listVisit);

	}

	@Override
	public int topDegree(int x) {
		return topDegreeIn(x) + topDegreeOut(x);
	}

	public int topDegreeIn(int x) {
		int sum = 0;
		if (x >= 0 && x < topNum()) {
			for (int i = 0; i < matrixA.length; i++) {
				sum += matrixA[i][x];
			}
		}
		return sum;
	}

	public int topDegreeOut(int x) {
		int sum = 0;
		if (x >= 0 && x < topNum()) {
			for (int i = 0; i < matrixA.length; i++) {
				sum += matrixA[x][i];
			}
		}
		return sum;
	}

	public int allTopDegreeIn() {
		int sum = 0;
		for (int i = 0; i < matrixA.length; i++) {
			sum += topDegreeIn(i);
		}
		return sum;
	}

	public int allTopDegreeOut() {
		int sum = 0;
		for (int i = 0; i < matrixA.length; i++) {
			sum += topDegreeOut(i);
		}
		return sum;
	}

	@Override
	public int allTopDegree() {
		// bao gom tong bac ra va tong bac vao
		int sum = 0;
		for (int i = 0; i < matrixA.length; i++) {
			sum += topDegree(i);
		}
		return sum;
	}

	@Override
	public int edgeNum() {
		// tong so canh bang tong so bac ra hoac tong so bac vao
		return allTopDegreeIn();
	}
	//Ket thuc tuan 1
	
	
	//Bat dau tuan 2
	@Override
	public int findPathFromXToY(int x, int y) {
		int numberPoint = topNum();
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> listVisit = new ArrayList<>();
		if (x >= 0 && x < numberPoint && y > x && y < numberPoint) {

			int[] visit = new int[numberPoint];
			visit[x] = 1;
			listVisit.add(x);
			stack.push(x);

			while (!stack.empty()) {
				int count = 0;
				x = stack.peek();
				if (x == y)
					break;
				for (int j = 0; j < visit.length; j++) {
					if (this.matrixA[x][j] > 0 && visit[j] == 0) {
						listVisit.add(j);
						visit[j] = 1;
						stack.push(j);
						break;
					} else {
						count++;
					}
				}
				if (count == visit.length) {
					stack.pop();
				}
			}
			graphToString(listVisit);

		}
		return listVisit.size();

	}

	public void checkContinuityOfGraph() {
		if (checkConectedStrongly())
			System.out.println("Strongly");
		else if (checkConectedWeakly())
			System.out.println("Weakly");
	}

	public void tranlateGraph(Graph g) {
		oldSave = this.matrixA;

		int[][] test = g.matrixA;
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[0].length; j++) {
				if (test[i][j] != 0) {
					this.matrixA[i][j] = test[i][j];
					this.matrixA[j][i] = test[i][j];
				}
			}
		}

	}

	public boolean checkConnected() {
		int i = 0;
		int numberPoint = topNum();
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> listVisit = new ArrayList<>();
		int[] visit = new int[numberPoint];
		visit[i] = 1;
		listVisit.add(i);
		stack.push(i);
		while (!stack.empty()) {
			int count = 0;
			i = stack.peek();
			for (int j = 0; j < visit.length; j++) {
				if (this.matrixA[i][j] > 0 && visit[j] == 0) {
					listVisit.add(j);
					visit[j] = 1;
					stack.push(j);
					break;
				} else {
					count++;
				}
			}
			if (count == visit.length) {
				stack.pop();
			}
		}
		for (int j = 0; j < visit.length; j++) {
			if (visit[j] != 1)
				return false;
		}
		return true;
	}

	public boolean checkConectedWeakly() {
		tranlateGraph(this);
		if (checkConnected()) {
			new DirectedGraph(path);
			return true;
		}
		return false;
	}

	public boolean checkConectedStrongly() {
		boolean ok = true;
		for (int j = 0; j < this.visitDir.length; j++) {
			if (topDegreeIn(j) == 0 || topDegreeOut(j) == 0) {
				ok = false;
			}
			if (topDegreeIn(j) != topDegreeOut(j)) {
				ok = false;
			}
		}
		if (checkConnected() && ok)
			return true;
		return false;
	}
	//Ket thuc tuan 2
	
	//Bat dau tuan 3
	@Override
	public void findConponentsContinuity() {
		int demLienThong = 1;
		int i = 0;
		int numberPoint = topNum();
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> listVisit = new ArrayList<>();
		// dau tien la gan setTemp bang tat ca cac dinh co trong do thi
		ArrayList<Integer> setTmp = new ArrayList<>();
		for (int j = 0; j < topNum(); j++) {
			setTmp.add(j);
		}
		int[] visit = new int[numberPoint];
		visit[i] = 1;
		listVisit.add(i);
		stack.push(i);
		setTmp.remove(i);
		while (!stack.empty()) {
			int count = 0;
			i = stack.peek();
			for (int j = 0; j < visit.length; j++) {
				if (this.matrixA[i][j] > 0 && visit[j] != 1) {
					listVisit.add(j);
					visit[j] = 1;
					stack.push(j);
					// neu phan tu do da duyet roi thi xoa di
					for (int j2 = 0; j2 < setTmp.size(); j2++) {
						if (setTmp.get(j2) == j) {
							setTmp.remove(j2);
						}
					}
					break;
				} else {
					count++;
				}
			}
			if (count == visit.length) {
				// neu khong con duong di
				System.out.println("Components : " + demLienThong);
				// xuat ra lo trinh
				graphToString(listVisit);
				// neu phan tu duyet xong roi thi break
				if (!setTmp.isEmpty()) {
					// chua thi lay phan tu dau tien nhat ra duyet tiep
					i = setTmp.get(0);
					if (i < topNum()) {
						demLienThong++;
						stack.removeAll(stack);
						// thuc hien push de stack khong rong
						stack.push(i);
						// remove lo trinh cu de ghi vao lo trinh moi
						listVisit.removeAll(listVisit);
					} else {
						break;
					}
				} else {
					break;
				}
			}
		}
	}

	@Override
	public boolean checkDichotomousGraph() {
		return false;
	}
	//Ket thuc tuan 3
	
	//Bat dau tuan 4
	@Override
	public boolean eulerPath() {
		if (isHasEulerCycle()) {
			eulerCycle();
		}
		// neu la duong di thi tim cai dinh bac le ma duyet
		if (isHasEulerPath()) {
			int start = 0;
			for (int i = 0; i < matrixA.length; i++) {
				if (topDegreeIn(i) == (topDegreeOut(i) + 1) || topDegreeOut(i) == (topDegreeIn(i) + 1)) {
					start = i;
					break;
				}
			}
			eulerCycle(start);
		}
		return false;
	}

	@Override
	public boolean eulerCycle() {
		if (isHasEulerCycle())
			eulerCycle(0);
		return false;
	}

	@Override
	public boolean isHasEulerPath() {
		int dem = 0;
		int canBang = 0;
		for (int i = 0; i < matrixA.length; i++) {
			// co duy nhat 2 dinh co dieu kien
			if (topDegreeIn(i) == (topDegreeOut(i) + 1) || topDegreeOut(i) == (topDegreeIn(i) + 1)) {
				dem++;
			}
			// cac dinh con lai phai can bang
			if (topDegreeIn(i) == topDegreeOut(i)) {
				canBang++;
			}
		}
		// lien thong yeu va thoa 2 dieu kien tren
		if ((checkConectedWeakly() || checkConectedStrongly()) && dem == 2 && canBang == (topNum() - 2))
			return true;
		return false;
	}

	@Override
	public boolean isHasEulerCycle() {
		// neu co bac ra ma khong bang voi bac vao thi false luon
		for (int i = 0; i < matrixA.length; i++) {
			if (topDegreeIn(i) != topDegreeOut(i))
				return false;
		}
		// neu dieu kien tren dung thi xet them tinh lien thong yeu va so dinh
		// >1
		if ((checkConectedWeakly() || checkConectedStrongly()) && topNum() > 1)
			return true;
		return false;
	}

	public boolean eulerCycle(int start) {
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		ArrayList<Integer> listVisit = new ArrayList<>();
		while (!stack.empty()) {
			int current_vertex = stack.peek();
			// kiem tra dinh ke co canh hong
			boolean has_neighbour = false;
			for (int i = 0; i < topNum(); i++) {
				if (this.matrixA[current_vertex][i] != 0) {
					// danh dau la co canh
					has_neighbour = true;
					// di qua roi la xoa di
					this.matrixA[current_vertex][i] = 0;
					stack.push(i);
					break;
				}
			}

			if (!has_neighbour) {
				int vertex = stack.pop();
				listVisit.add(vertex);
			}
		}
		// in ra duong di theo chieu nguoc lai
		String string = "";
		String temp = " ==> ";
		for (int k = listVisit.size() - 1; k >= 0; k--) {
			string += listVisit.get(k);
			if (k > 0) {
				string += temp;
			}
		}
		System.out.println(string);
		return true;
	}

	//Ket thuc tuan 4
	
	//Bat dau tuan 5
	@Override
	public boolean checkHamiltonCycle() {
		if (!checkConectedStrongly())
			return false;
		int top = topNum();
		for (int i = 0; i < matrixA.length; i++) {
			int degreeOut = topDegreeOut(i);
			int degreeIn = topDegreeIn(i);
			if (degreeIn < (top / 2) && degreeOut < (top / 2))
				return false;
		}
		return true;
	}

	@Override
	public boolean checkHamiltonPath() {
		return check_using_dfs();
	}

	public boolean dfs(int v, String label[], int instack_count) {
		int n = topNum();
		if (instack_count == n)
			return true;
		for (int i = 0; i < n; i++)
			if (this.matrixA[v][i] > 0 && label[i].equals("NOT_IN_STACK")) {
				label[i] = "IN_STACK";
				if (dfs(i, label, instack_count + 1)) {
					listVisitHamiltonian.add(i);
					return true;
				}
				label[i] = "NOT_IN_STACK";
			}
		return false;
	}

	List<Integer> listVisitHamiltonian = new ArrayList<>();

	public boolean check_using_dfs() {
		int count = 0;
		String label[] = new String[topNum()];
		int n = topNum();
		for (int i = 0; i < n; i++)
			label[i] = "NOT_IN_STACK";
		for (int i = 0; i < n; i++) {
			label[i] = "IN_STACK";
			if (dfs(i, label, 1)) {
				listVisitHamiltonian.add(i);
				for (int k = listVisitHamiltonian.size() - 1; k >= 0; k--)
					System.out.print(listVisitHamiltonian.get(k) + " \t ");
				System.out.println();
				listVisitHamiltonian.removeAll(listVisitHamiltonian);
				for (int j = 0; j < n; j++)
					label[j] = "NOT_IN_STACK";
				count++;
			}
			label[i] = "NOT_IN_STACK";
		}
		return (count > 0) ? true : false;
	}

	@Override
	public void hamiltonianPath() {
		check_using_dfs();
	}

	boolean visited[];
	int[] hc;

	@Override
	public void hamiltonianCycle(int index) {
		visited = new boolean[topNum()];
		hc = new int[topNum()];
		for (int j = 0; j < this.matrixA.length; j++) {
			visited[j] = false;
			hc[index] = 0;
			visited[index] = true;
		}
		Expand(1);
	}

	private void Expand(int i) {
		for (int j = 0; j < topNum(); j++)
			if (!visited[j] && this.matrixA[hc[i - 1]][j] > 0) {
				hc[i] = j;
				if (i < topNum() - 1) {
					visited[j] = true;
					Expand(i + 1);
					visited[j] = false;
				} else if (this.matrixA[hc[i]][0] > 0) {
					printHamiltonCycle(hc);
				}
			}
	}

	private void printHamiltonCycle(int[] arr) {
		String string = "";
		String temp = " ==> ";
		for (int k = 0; k < arr.length; k++) {
			string += arr[k];
			if (k < arr.length - 1) {
				string += temp;
			}
		}
		System.out.println(string + temp + arr[0]);
	}

	//Ket thuc tuan 5
	
	//Bat dau tuan 6
	@Override
	public int[][] DFSTree(int index) {
		int res[][] = new int[topNum()][topNum()];
		Stack<Integer> stack = new Stack<>();
		int visit[] = new int[topNum()];
		ArrayList<Integer> listVS = new ArrayList<>();
		
		visit[index] = 1;
		stack.push(index);
		listVS.add(index);
		while(!stack.isEmpty()){
			int i=stack.peek();
			int count=0;
			for (int j = 0; j < visit.length; j++) {
				if(this.matrixA[i][j]>0 && visit[j]!=1){
					res[i][j]=1;
					res[j][i]=1;
					stack.push(j);
					visit[j]=1;
					listVS.add(j);
					break;
				}else{
					count++;
				}
			}
			if(count==visit.length) stack.pop();
			if(listVS.size()==topNum()) {
				graphToString(listVS);
				return res;
			}
		}
		return res;

	}

	@Override
	public int[][] BFSTree(int index) {
		int res[][] = new int[topNum()][topNum()];
		int numberPoint = topNum();
		if (index < 0 || index > numberPoint)
			return null;
		ArrayList<Integer> queue = new ArrayList<Integer>();
		ArrayList<Integer> listVisit = new ArrayList<>();
		boolean[] visit;
		visit = new boolean[numberPoint];
		visit[index] = true;
		queue.add(0, index);
		while (queue.size() > 0) {
			index = queue.get(queue.size() - 1);
			queue.remove(queue.size() - 1);
			listVisit.add(index);
			for (int j = 0; j < numberPoint; j++) {
				if (this.matrixA[index][j] > 0 && !visit[j]) {
					visit[j] = true;
					res[index][j]=1;
					res[j][index]=1;
					queue.add(0, j);
				}
			}
			if(listVisit.size()==numberPoint){
				graphToString(listVisit);
				return res;
			}
		}
		return res;
	}
	//Ket thuc tuan 6
	public int[][] floyd() {
		// Khoi tao ma tran ban dau
		int n = matrixA.length;
		int[][] W = this.matrixA;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (W[i][j] == 0) {
					//Gia tri duong vo cung duoc gan la 1000;
					W[i][j] = 1000;
				}else{
					//Neu co canh thi khoi tao P[i][j] = j;
					P[i][j]=j;
				}
				
			}
		}
		// Dung thuat toan floyd
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (W[i][j] > (W[i][k] + W[k][j])) {
						W[i][j] = (W[i][k] + W[k][j]);
						P[i][j] = P[i][k];
					}
				}
			}
			System.out.println("Array W: when k=" + k);
			printTree(W);
		}
		return W;
	}

	public ArrayList<Integer> floyd(int a, int b) {
		// i, P*[i,j],P*[P*[i,j],j], P*[P*[P*[i,j],j],j],j],…,j
		floyd();
		System.out.println("Mang truy vet duong di:");
		for (int i = 0; i < P.length; i++) {
			for (int j = 0; j < P.length; j++) {
				System.out.print(P[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("Duong di tim duoc:");
		ArrayList<Integer> list = new ArrayList<>();
		int path = a;
		list.add(path);
		while (path != b) {
			path = P[path][b];
			list.add(path);
		}
		graphToString(list);
		return list;
	}

	
}
