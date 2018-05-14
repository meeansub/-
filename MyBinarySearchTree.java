package hw9_2;

/* 
 * ���ϸ�: MyBinarySearchTree.java
 * �ۼ���: 2017.11.22
 * �ۼ���: ��μ�
 * ����: int�� Ű�� �����ϴ� ����Ž��Ʈ���� �����ڷᱸ���� ������ Ŭ����, ���� ����
 */

import java.util.NoSuchElementException;

class MyBinarySearchTree {
	// Ʈ���� ��Ʈ ��带 ����ų �ν��Ͻ� ���� root �����ϰ� null�� �ʱ�ȭ
	// (��) 
	private Node root =null;



	// Ʈ���� ��带 ǥ���ϴ� Ŭ���� - �ʵ�(int�� key, leftChild, rightChild), ������(key���� �Ű������Ͽ� �ʱ�ȭ)
	private class Node {
		// (��)
		private int key;
		private Node leftChild;
		private Node rightChild;

		public Node(int key) {
			this.key=key;
			this.leftChild=null;
			this.rightChild=null;
		}



	}

	// (1) ��ü��ȸ�� ���� toString() �������̵�
	@Override
	public String toString() {
		String result = inorder(root);
		return result;
	}

	// p�� ��Ʈ�� �ϴ� Ʈ���� ���� ��ȸ�ϸ� Ű���� ���ڿ��� �����ϴ� �޼ҵ�(��� �˰���)
	private String inorder(Node p) {
		String result = "";
		if(p != null) {
			result += inorder(p.leftChild);
			result += p.key + " ";
			result += inorder(p.rightChild);
		}
		return result;
	}

	// (2) ��� ����
	public void insert(int key) { 
		root = insertKey(root, key);
	}

	// p�� ��Ʈ�� �ϴ� Ʈ���� key�� �����ϴ� �޼ҵ� (��� �˰���)
	private Node insertKey(Node p, int key) {
		if(p == null) {		
			Node newNode = new Node(key);
			return newNode;	
		}
		else if(key < p.key) {
			p.leftChild = insertKey(p.leftChild, key);
			return p;		// ��Ʈ �Һ�
		}
		else if(key > p.key) {
			p.rightChild = insertKey(p.rightChild, key);
			return p;		// ��Ʈ �Һ�        
		}
		else {  // key = p.key �� ��� ���� ����
			System.out.println("Insertion fail! key duplication : " + key);
			return p;  	// ��Ʈ �Һ�
		}
	}   

	// (3) ���� ��ȸ
	public void printPostorder() {
		postorder(root);
		System.out.println();
	}

	// p�� ��Ʈ�� �ϴ� Ʈ���� ���� ��ȸ�ϸ� Ű���� ����ϴ� �޼ҵ�
	private void postorder(Node p) {

		// (��) ...
		if(p !=null) {
			postorder(p.leftChild);
			postorder(p.rightChild);
			System.out.print(p.key+ " ");
		}
	}
	//(4) Ž�� contains
	public boolean contains(int item) {
		Node p= root;
		while(p !=null) {
			//item�� ��Ʈ�� ������ Ŭ��
			if(p.key<item) {
				p=p.rightChild;
			}
			//item�� ��Ʈ�� �� ���� ������
			else if(p.key>item) {
				p=p.leftChild;
			}
			//item�� ��Ʈ�� ���� ������
			else if(p.key==item) {
				return true;
			}

		}
		return false;

	}


	//(5) �ִ� max
	public int max(){
		Node p =root;
		//����� ���� ������
		if(p == null) {
			throw new NoSuchElementException("��尡 �����");

		}
		//��忡 ���� ������
		else {
			while(p !=null) {
				//������ ����Ʈ���� ����������
				if(p.rightChild !=null) {
					p=p.rightChild;
				}
				else
					break;

			}

		}
		return p.key;
	}

	//(6) ���� add
	public boolean add(int item) {
		Node p =root;
		Node q = null;
		while(p !=null) {
			if(p.key == item)
				return false;
			q=p;
			if(item<p.key)
				p=p.leftChild;
			else if(item>p.key)
				p=p.rightChild;
		}
		//������ �� newNode ����
		Node newNode=new Node(item);
		//��Ʈ�� ���������
		if(root==null) {
			root=newNode;
			return true;
		}
		//������ item ���� Ű������ Ŭ��
		else if(item>q.key) {
			q.rightChild=newNode;
			return true;
		}
		//������ item ���� Ű������ ������
		else if(item<q.key) {
			q.leftChild=newNode;
			return true;
		}
		else
			return false;

	}
	//(7)���� remove ���� ���� ����(��� �ΰ� �϶��� ����)
	public boolean remove(int item) {
		//�����ҳ��
		Node p=root;

		//������ ����� �θ���
		Node parent=null;

		//������ ��� Ž��
		while(p != null) {
			if(p.key==item)
				break;
			parent=p;
			if(item>p.key)
				p=p.rightChild;
			else if(item<p.key)
				p=p.leftChild;

		}
		//����Ž��Ʈ���� �������
		if(p==null) {
			return false;
		}


		//������ ��尡 �ܸ�����϶�
		if(p.leftChild==null && p.rightChild==null) {
			if(parent==null) {
				root=null;
			}
			//p�� ���� �ڽ��� ���
			else if(parent.leftChild==p) {
				parent.leftChild=null;
			}
			//p�� ������ �ڽ��ΰ��
			else if(parent.rightChild==p) {
				parent.rightChild=null;
			}
			return true;
		}
		//������ ����� �ڽ��� �ϳ��� ��� (Ű ���� �־�ߵ�)
		else if(p.leftChild ==null || p.rightChild ==null) {

			//p�� ���� �ڽĸ� ���°��
			if(p.leftChild !=null) {
				//������ p�� ���� �ڽ��� ��Ʈ
				if(parent==null)
					root= p.leftChild;
				//p�� ���� �ڽ��� ���
				else if(parent.leftChild==p) 
					parent.leftChild=p.leftChild;
				//p�� ������ �ڽ��� ���
				else if(parent.rightChild==p) 
					parent.rightChild=p.leftChild;

				return true;
			}
			//p�� ������ �ڽĸ� ���� ���
			else {
				if(p.rightChild !=null) {
					//p�� ������ �ڽ��� ��Ʈ�� ��
					if(parent==null)
						root=p.rightChild;
					//p�� ���� �ڽ��� ���
					else if(parent.leftChild==p)
						parent.leftChild=p.rightChild;
					//p�� ������ �ڽ��� ���
					else if(parent.rightChild==p)
						parent.rightChild=p.rightChild;
					return true;

				}
			}
		}
		//����� �ڽ��� �ΰ��� ���
		else {
			Node temp =p.leftChild;

			while(temp !=null) {
				//������ ����Ʈ���� ����������
				if(temp.rightChild !=null) {

					temp=temp.rightChild;
				}
				else
					break;
			}
			int tmpdata=temp.key;
			remove(temp.key);
			p.key=tmpdata;



			return true;
		}
		return false;

	}

}

