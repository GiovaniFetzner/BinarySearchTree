package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		Nodo raiz = new Nodo("A", 50);
		raiz.add("B", 49);
		raiz.add("C", 52);
		raiz.add("D", 48);
		raiz.add("E", 51);
		raiz.printTree();
		System.out.println(raiz.search(48));
		System.out.println("\n" + "PreOrdem:");
		raiz.printPreOrder(raiz);	
		System.out.println("\n" + "InOrdem:");
		raiz.printInOrder(raiz);
		System.out.println("\n" + "PostOrdem:");
		raiz.printPostOrder(raiz);
		
	}
	
	private static void printPreOrderSVG(Nodo root) {
		
		String path = "C:\\Program Files\\Graphviz\\GraphvizArquivos";
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		} catch (IOException e) {
			System.out.println("Erro no arquivo!");
		}
	}

}
