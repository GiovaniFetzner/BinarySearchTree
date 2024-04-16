package main;

public class Nodo {

	private String key;
	private int value;
	private Nodo leftChild;
	private Nodo rightChild;
	private Nodo parent;

	public Nodo(String key, int value) {
		this.key = key;
		this.value = value;
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

	public boolean search(int value) {
		if (this.value == value) {
			return true;  
		} else if (this.value > value && leftChild != null) {
			return leftChild.search(value);  
		} else if (this.value < value && rightChild != null) {
			return rightChild.search(value); 
		}
		return false;
	}

	public int searchMin(Nodo root) {
		if(root.leftChild == null) {
			return root.getValue();
		}else {
			return searchMin(root.leftChild);
		}
	}

	public boolean isLeaf() {
		return leftChild == null && rightChild == null;
	}
	
	public boolean removeCoping() {
		return false;
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
			System.out.println(node.getValue());
			printTreeHelper(node.getLeftChild(), depth + 1);
		}
	}

	public void printPreOrder(Nodo root) {
		if(root != null) {
			System.out.println(root.value);
			printPreOrder(root.leftChild);
			printPreOrder(root.rightChild);
		}
	}

	public void printInOrder(Nodo root) {
		if(root != null) {
			printInOrder(root.leftChild);
			System.out.println(root.value);
			printInOrder(root.rightChild);
		}
	}

	public void printPostOrder(Nodo root) {
		if(root != null) {
			printInOrder(root.leftChild);
			printInOrder(root.rightChild);
			System.out.println(root.value);
		}
	}

	public StringBuilder printGraphviz(Nodo root, StringBuilder text) {
		if (root != null) {
			if (root.getLeftChild() != null) {
				text.append(root.getValue()).append(" -> ").append(root.getLeftChild().getValue()).append("\n");
			}
			if (root.getRightChild() != null) {
				text.append(root.getValue()).append(" -> ").append(root.getRightChild().getValue()).append("\n");
			}
			printGraphviz(root.getLeftChild(), text);
			printGraphviz(root.getRightChild(), text);
		}
		return text;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
