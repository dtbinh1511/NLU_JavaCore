package AlphaBeta;

public class TestAlphaBeta {
	public static void main(String[] args) {
		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D", 0);
		Node E = new Node("E");
		Node F = new Node("F");
		Node G = new Node("G", -5);
		Node H = new Node("H", 3);
		Node I = new Node("I", 8);
		Node J = new Node("J");
		Node K = new Node("K");
		Node L = new Node("L", 2);
		Node M = new Node("M");
		Node N = new Node("N", 4);
		Node O = new Node("O");
		Node P = new Node("P", 9);
		Node Q = new Node("Q", -6);
		Node R = new Node("R", 0);
		Node S = new Node("S", 3);
		Node T = new Node("T", 5);
		Node U = new Node("U", -7);
		Node V = new Node("V", -9);
		Node W = new Node("W", -3);
		Node X = new Node("X", -5);

		A.addChild(B);
		A.addChild(C);
		A.addChild(D);
		A.addChild(E);
		B.addChild(F);
		B.addChild(G);
		C.addChild(H);
		C.addChild(I);
		C.addChild(J);
		E.addChild(K);
		E.addChild(L);
		E.addChild(M);
		F.addChild(N);
		F.addChild(O);
		J.addChild(P);
		J.addChild(Q);
		J.addChild(R);
		K.addChild(S);
		K.addChild(T);
		M.addChild(U);
		M.addChild(V);
		O.addChild(W);
		O.addChild(X);

		ISearchAlgo algo = new AlphaBetaLeftToRightSearchAlgo();
//		ISearchAlgo algo = new AlphaBetaRightToLeftSearchAlgo();
		algo.execute(A);

	}

}
