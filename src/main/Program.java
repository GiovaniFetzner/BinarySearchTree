package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		Node raiz = new Node("A", 25);
		
		raiz.add("B", 65);
		raiz.add("C", 95);
		raiz.add("D", 84);
		raiz.add("E", 28);
		raiz.add("X", 14);
		raiz.add("Y", 4);
		raiz.add("Z", 33);
		raiz.add("W", 29);
		raiz.add("U", 6);
		raiz.add("V", 71);
		
		System.out.println("\n" + "PreOrdem:");
		raiz.printPreOrder(raiz);
		System.out.println("\n" + "InOrdem:");
		raiz.printInOrder(raiz);
		System.out.println("\n" + "PostOrdem:");
		raiz.printPostOrder(raiz);

		System.out.println("Pesquisas na arvore BST:");
		
		printSVG(raiz);
		terminalProcess();
		System.out.println("Escrita no .txt finalizada");
		System.out.println("\n" + raiz.printGraphviz(raiz, new StringBuilder()));

	}

	private static void printSVG(Node root) {

		String path = "C:\\Users\\giova\\eclipse-workspace\\BinarySearchTree\\GraphvizArquivos\\BinarySearchTree.txt";
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
	
	private static void terminalProcess() {
		 try {
	            String caminhoTxt = "C:\\Users\\giova\\eclipse-workspace\\BinarySearchTree\\GraphvizArquivos\\BinarySearchTree.txt";
	            String caminhoSvg = "C:\\Users\\giova\\eclipse-workspace\\BinarySearchTree\\GraphvizArquivos\\BinarySearchTree.svg";
	            String comando = "cmd /c dot -Tsvg \"" + caminhoTxt + "\" -o \"" + caminhoSvg + "\"";
	            Process processo = Runtime.getRuntime().exec(comando);

	            processo.waitFor();

	            int exitCode = processo.exitValue();
	            if (exitCode == 0) {
	                System.out.println("Comando executado com sucesso.");
	            } else {
	                System.out.println("Erro ao executar o comando. Código de saída: " + exitCode);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	
	private static void addRandomChild(Node root) {
		
        char randomChar = (char) (Math.random() * 26 + 'A');
        String randomKey = String.valueOf(randomChar);

        int randomValue = (int) (Math.random() * 100);

        root.add(randomKey, randomValue);
	}

}
