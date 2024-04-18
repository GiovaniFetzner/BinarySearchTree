package main;

public class Node {

	private String key;
	private int value;
	private Node leftChild;
	private Node rightChild;
	private Node parent;

	public Node(String key, int value) {
		this.key = key;
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
		this.parent = null;
	}

	public void add(String key, int value) {
		if (this.value > value) {
			if (leftChild == null) {
				setLeftChild(new Node(key, value));
				leftChild.parent = this;
			} else {
				leftChild.add(key, value);
			}
		} else {
			if (rightChild == null) {
				setRightChild(new Node(key, value));
				rightChild.parent = this;
			} else {
				rightChild.add(key, value);
			}
		}

	}

	public Node search(int value) {
		if (this.value == value) {
			return this;  
		} else if (this.value > value && leftChild != null) {
			return leftChild.search(value);  
		} else if (this.value < value && rightChild != null) {
			return rightChild.search(value); 
		}
		return null;
	}
	
	public Node search(String key) {
	    if (this.key.equals(key)) {
	        return this;
	    } 
	    Node foundInLeft = leftChild != null ? leftChild.search(key) : null;
	    if (foundInLeft != null) {
	        return foundInLeft;
	    } 
	    return rightChild != null ? rightChild.search(key) : null;
	}


	public Node searchMinValue(Node rootReference) {
		Node node = search(rootReference.value);
		if(node == null) {
			return null;
		}
		if(node.leftChild == null) {
			return node;
		}else {
			return searchMinValue(node.leftChild);
		}
	}
	
	
	public Node searchMaxValue(Node rootReference) {
		Node node = search(rootReference.value);
		if(node == null) {
			return null;
		}
		if(node.rightChild == null) {
			return node;
		}else {
			return searchMaxValue(node.rightChild);
		}
	}

		
	private boolean leafDelete(int value) {
	    Node nodeToDelete = search(value);
	    if (nodeToDelete != null && nodeToDelete.parent != null) {
	    	
	            if (nodeToDelete.parent.leftChild == nodeToDelete) {
	                nodeToDelete.parent.leftChild = null;
	            } else {
	                nodeToDelete.parent.rightChild = null;
	            }
	            return true;
	        }
	   
	    return false; 
	}
	
	private boolean oneChildDelete(Node nodeToDelete) {
		/* Node nodeToDelete = search(value); */
	    if (nodeToDelete != null && nodeToDelete.parent != null) {
	        if (nodeToDelete.leftChild != null && nodeToDelete.rightChild != null) {
	            return false;
	        }

	        Node childNode = nodeToDelete.leftChild != null ? nodeToDelete.leftChild : nodeToDelete.rightChild;
	        if (nodeToDelete.parent.leftChild == nodeToDelete) {
	            nodeToDelete.parent.leftChild = childNode;
	        } else {
	            nodeToDelete.parent.rightChild = childNode;
	        }
	        if (childNode != null) {
	            childNode.parent = nodeToDelete.parent;
	        }

	        return true;
	    }
	    return false;
	}
	
	private boolean copyDelete(Node nodeToDelete) {
		if(nodeToDelete != null && nodeToDelete.parent != null) {
			if(nodeToDelete.leftChild != null) {
				Node auxiliar = searchMaxValue(nodeToDelete.leftChild);
				int auxValue = auxiliar.getValue();
				String auxKey = auxiliar.getKey();
				
				if(auxiliar.isLeaf()) {
					leafDelete(auxiliar.getValue());
				}else {
					oneChildDelete(auxiliar);
				}
				
				nodeToDelete.setKey(auxKey);
				nodeToDelete.setValue(auxValue);
				return true;
			}
			
		}
		return false;
	}
	
	public boolean deleteNode(int value) {
		Node nodeToDelete = search(value);
		if(nodeToDelete != null) {
			if(nodeToDelete.isLeaf()) {
				return nodeToDelete.leafDelete(value);
			}else if(nodeToDelete.leftChild != null && nodeToDelete.rightChild != null) {
				return copyDelete(nodeToDelete);
			}else {
				return nodeToDelete.oneChildDelete(nodeToDelete);
			}
		}
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

	private void printTreeHelper(Node node, int depth) {
		if (node != null) {
			printTreeHelper(node.getRightChild(), depth + 1);
			for (int i = 0; i < depth; i++) {
				System.out.print("   ");
			}
			System.out.println(node.getValue());
			printTreeHelper(node.getLeftChild(), depth + 1);
		}
	}

	public void printPreOrder(Node root) {
		if(root != null) {
			System.out.println(root.value);
			printPreOrder(root.leftChild);
			printPreOrder(root.rightChild);
		}
	}

	public void printInOrder(Node root) {
		if(root != null) {
			printInOrder(root.leftChild);
			System.out.println(root.value);
			printInOrder(root.rightChild);
		}
	}

	public void printPostOrder(Node root) {
		if(root != null) {
			printInOrder(root.leftChild);
			printInOrder(root.rightChild);
			System.out.println(root.value);
		}
	}

	public StringBuilder printGraphviz(Node root, StringBuilder text) {
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
	
	public boolean isLeaf() {
		return leftChild == null && rightChild == null;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
		if (leftChild != null) {
			leftChild.setParent(this);
		}
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
		if (rightChild != null) {
			rightChild.setParent(this);
		}
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Node getParent() {
		return parent;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "Node [key=" + key + ", value=" + value + "]";
	}

	
}
