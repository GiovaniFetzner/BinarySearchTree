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
		
		System.out.println("Teste de escrita no arquivo");
		printPreOrderSVG(raiz);
	}
	
	private static void printPreOrderSVG(Nodo root) {
		
		String path = "C:\\Program Files\\Graphviz\\GraphvizArquivos\\BinarySearchTree.txt";
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			writer.append("digraph ArvoreBinaria {");
			writer.newLine();
			writer.append("    nodesep = 0.5;");
			writer.newLine();
			writer.append("    node [shape=\"circle\", style=\"filled\", color=\"black\", fillcolor=\"#9370DB\"];");
			writer.newLine();
			writer.append("    edge [color=\"black\"];");
			writer.newLine();
			
			
			writer.append("A -> C");
			writer.newLine();
			writer.append("A -> B");
			
			writer.newLine();
			writer.append("}");
			writer.close();
			
			System.out.println("Escrita preOrder no .txt finalizada");
			
		} catch (IOException e) {
			System.out.println("Erro no arquivo!");
		}
	}

}
