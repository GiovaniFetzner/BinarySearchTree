package main;

public class Nodo {

	private String key;
	private int value;
	private Nodo leftChild;
	private Nodo rightChild;
	private Nodo parent;
	
	public Nodo(String key, int valor) {
		this.key = key;
		this.value = valor;
		this.leftChild = null;
		this.rightChild = null;
		this.parent = null;
	}

	public void add(String key, int value) {
		if (this.value > value) {
			if (leftChild == null) {
				setLeftChild(new Nodo(key, value));
				leftChild.parent = this;
			} else {
				leftChild.add(key, value);
			}
		} else {
			if (rightChild == null) {
				setRightChild(new Nodo(key, value));
				rightChild.parent = this;
			} else {
				rightChild.add(key, value);
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
	
	public int buscarMin(Nodo root) {
		if(root.leftChild == null) {
			return root.getValor();
		}else {
			return buscarMin(root.leftChild);
		}
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

	public void printPreOrder(Nodo raiz) {
		if(raiz != null) {
			System.out.println(raiz.value);
			printPreOrder(raiz.leftChild);
			printPreOrder(raiz.rightChild);
		}
	}
	
	public void printInOrder(Nodo raiz) {
		if(raiz != null) {
			printInOrder(raiz.leftChild);
			System.out.println(raiz.value);
			printInOrder(raiz.rightChild);
		}
	}
	
	public void printPostOrder(Nodo raiz) {
		if(raiz != null) {
			printInOrder(raiz.leftChild);
			printInOrder(raiz.rightChild);
			System.out.println(raiz.value);
		}
	}

	public StringBuilder printGraphviz(Nodo raiz, StringBuilder text) {
	    if (raiz != null) {
	        if (raiz.getLeftChild() != null) {
	            text.append(raiz.getValor()).append(" -> ").append(raiz.getLeftChild().getValor()).append("\n");
	        }
	        if (raiz.getRightChild() != null) {
	            text.append(raiz.getValor()).append(" -> ").append(raiz.getRightChild().getValor()).append("\n");
	        }
	        printGraphviz(raiz.getLeftChild(), text);
	        printGraphviz(raiz.getRightChild(), text);
	    }
	    return text;
	}
	
	public String getChave() {
		return key;
	}

	public void setChave(String chave) {
		this.key = chave;
	}

}
