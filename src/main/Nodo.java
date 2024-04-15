package main;

public class Nodo {

	private String key;
	private int value;
	private Nodo leftChild;
	private Nodo rightChild;
	private Nodo parent;

	public Nodo(int valor) {
		super();
		this.value = valor;
		this.leftChild = null;
		this.rightChild = null;
		this.parent = null;
	}

	public void add(int valor) {
		if (this.value > valor) {
			if (leftChild == null) {
				setLeftChild(new Nodo(valor));
				leftChild.parent = this;
			} else {
				leftChild.add(valor);
			}
		} else {
			if (rightChild == null) {
				setRightChild(new Nodo(valor));
				rightChild.parent = this;
			} else {
				rightChild.add(valor);
			}
		}

	}
	
	public boolean search(int valor) {
	    if (this.value == valor) {
	        return true;  
	    } else if (this.value > valor && leftChild != null) {
	        return leftChild.search(valor);  
	    } else if (this.value < valor && rightChild != null) {
	        return rightChild.search(valor); 
	    }
	    return false;
	}


	private int compareItens(int left, int right) {
		return left - right; // Se esquerda maior, retorna positivo. Senão o valor da direita é maior
	}

	public int getValor() {
		return value;
	}

	public void setValor(int valor) {
		this.value = valor;
	}

	public Nodo getLeftChild() {
		return leftChild;
	}

	public Nodo getRightChild() {
		return rightChild;
	}

	public void setLeftChild(Nodo leftChild) {
		this.leftChild = leftChild;
		if (leftChild != null) {
			leftChild.setParent(this);
		}
	}

	public void setRightChild(Nodo rightChild) {
		this.rightChild = rightChild;
		if (rightChild != null) {
			rightChild.setParent(this);
		}
	}

	public void setParent(Nodo parent) {
		this.parent = parent;
	}

	public Nodo getParent() {
		return parent;
	}

	public boolean isLeaf() {
		return leftChild == null && rightChild == null;
	}

	public void printTree() {
	    if (this.parent != null) {
	        System.out.println("Voce deve chamar esse metodo no no raiz!!!");
	    } else {
	        System.out.println("Arvore binaria:");
	        printTreeHelper(this, 0);
	    }
	}

	private void printTreeHelper(Nodo node, int depth) {
	    if (node != null) {
	        printTreeHelper(node.getRightChild(), depth + 1);
	        for (int i = 0; i < depth; i++) {
	            System.out.print("   ");
	        }
	        System.out.println(node.getValor());
	        printTreeHelper(node.getLeftChild(), depth + 1);
	    }
	}

	private void printInOrder(Nodo raiz) {
		if (raiz != null) {
			printInOrder(raiz.getLeftChild());
			System.out.print(raiz.getValor() + " ");
			printInOrder(raiz.getRightChild());
		}
	}

	public String getChave() {
		return key;
	}

	public void setChave(String chave) {
		this.key = chave;
	}
}
