package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		Node raiz = new Node("A", 82);
		raiz.add("B", 47);
		Node teste = new Node("teste", 60);
		raiz.add(teste.getKey(), teste.getValue());
		raiz.add("C", 53);
		raiz.add("D", 48);
		raiz.add("E", 28);
		raiz.add("X", 30);
		raiz.add("Y", 61);
		raiz.add("Z", 58);
		raiz.add("W", 20);
		raiz.add("U", 100);
		raiz.add("V", 57);
		System.out.println("\n" + "PreOrdem:");
		raiz.printPreOrder(raiz);
		System.out.println("\n" + "InOrdem:");
		raiz.printInOrder(raiz);
		System.out.println("\n" + "PostOrdem:");
		raiz.printPostOrder(raiz);

		System.out.println("\nTeste de retorno do StringBuilder:");
		System.out.println(raiz.printGraphviz(raiz, new StringBuilder()));
		

		System.out.println("Pesquisas na arvore BST:");
		
		System.out.println("Busca valor 30 (existente): " + raiz.search(30));
		System.out.println("Busca valor 31 (inexistente): " + raiz.search(31));
		System.out.println();
		System.out.println("Busca chave 'teste' (existente): " + raiz.search("teste"));
		System.out.println("Busca chave 'brazil' (inexistente): " + raiz.search("brazil"));
		System.out.println();
		System.out.println("Menor valor da subarvore 60 (existente): " + raiz.searchMinValue(teste));
		System.out.println("Menor valor da subarvore 200 (inexistente): " + raiz.searchMinValue(new Node("brazil", 200)));
		System.out.println();
		System.out.println("Maior valor da subarvore 47 (existente): " + raiz.searchMaxValue(new Node("B", 47)));
		System.out.println("Maior valor da subarvore 200 (inexistente): " + raiz.searchMaxValue(new Node("brazil", 200)));
		
		/*System.out.println("Teste de remocao:");
		System.out.println("Removendo uma folha - 20: " + raiz.deleteNode(20));
		System.out.println("Removendo um nodo que possui um filho - 28: " + raiz.deleteNode(28));
		*/
		System.out.println("Maior valor da subarvore esquerda do nodo 60: " + raiz.searchMaxValue(raiz.search(60).getLeftChild()));
		
		System.out.println("Remocao do nodo 60: " + raiz.deleteNode(60));
		System.out.println("Remocao do nodo 58: " + raiz.deleteNode(58));
		System.out.println("Remocao do nodo 57: " + raiz.deleteNode(57));
		System.out.println("Remocao do nodo 47: " + raiz.deleteNode(47));

		printSVG(raiz);
		System.out.println("Escrita no .txt finalizada");
		System.out.println("\n" + raiz.printGraphviz(raiz, new StringBuilder()));

	}

	private static void printSVG(Node root) {

		String path = "C:\\Program Files\\Graphviz\\GraphvizArquivos\\BinarySearchTree.txt";
		File file = new File(path);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Erro ao criar arquivo !");
			}
		}
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

			StringBuilder text = new StringBuilder();
			writer.append(root.printGraphviz(root, text));

			writer.newLine();
			writer.append("}");
			writer.close();

		} catch (IOException e) {
			System.out.println("Erro no arquivo!");
		}
	}

}
