package main;

public class Program {

	public static void main(String[] args) {
		Nodo raiz = new Nodo(50);
		raiz.add(49);
		raiz.add(51);
		raiz.add(48);
		raiz.printTree();
		System.out.println(raiz.search(48));

	}

	private static void preOrder(Nodo raiz) {

	}

	private static void inOrder(Nodo raiz) {

	}

	private static void postOrder(Nodo raiz) {

	}

}
