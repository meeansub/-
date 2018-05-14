package hw9_2;

/* 
 * 파일명: MyBinarySearchTree.java
 * 작성일: 2017.11.22
 * 작성자: 김민섭
 * 설명: int형 키값 저장하는 이진탐색트리를 연결자료구조로 구현한 클래스, 삭제 구현
 */

import java.util.NoSuchElementException;

class MyBinarySearchTree {
	// 트리의 루트 노드를 가리킬 인스턴스 변수 root 선언하고 null로 초기화
	// (가) 
	private Node root =null;



	// 트리의 노드를 표현하는 클래스 - 필드(int형 key, leftChild, rightChild), 생성자(key값을 매개변수하여 초기화)
	private class Node {
		// (나)
		private int key;
		private Node leftChild;
		private Node rightChild;

		public Node(int key) {
			this.key=key;
			this.leftChild=null;
			this.rightChild=null;
		}



	}

	// (1) 전체조회를 위한 toString() 오버라이드
	@Override
	public String toString() {
		String result = inorder(root);
		return result;
	}

	// p를 루트로 하는 트리를 중위 순회하며 키값을 문자열로 리턴하는 메소드(재귀 알고리즘)
	private String inorder(Node p) {
		String result = "";
		if(p != null) {
			result += inorder(p.leftChild);
			result += p.key + " ";
			result += inorder(p.rightChild);
		}
		return result;
	}

	// (2) 재귀 삽입
	public void insert(int key) { 
		root = insertKey(root, key);
	}

	// p를 루트로 하는 트리에 key를 삽입하는 메소드 (재귀 알고리즘)
	private Node insertKey(Node p, int key) {
		if(p == null) {		
			Node newNode = new Node(key);
			return newNode;	
		}
		else if(key < p.key) {
			p.leftChild = insertKey(p.leftChild, key);
			return p;		// 루트 불변
		}
		else if(key > p.key) {
			p.rightChild = insertKey(p.rightChild, key);
			return p;		// 루트 불변        
		}
		else {  // key = p.key 인 경우 삽입 실패
			System.out.println("Insertion fail! key duplication : " + key);
			return p;  	// 루트 불변
		}
	}   

	// (3) 후위 순회
	public void printPostorder() {
		postorder(root);
		System.out.println();
	}

	// p를 루트로 하는 트리를 후위 순회하며 키값을 출력하는 메소드
	private void postorder(Node p) {

		// (다) ...
		if(p !=null) {
			postorder(p.leftChild);
			postorder(p.rightChild);
			System.out.print(p.key+ " ");
		}
	}
	//(4) 탐색 contains
	public boolean contains(int item) {
		Node p= root;
		while(p !=null) {
			//item이 루트의 값보다 클때
			if(p.key<item) {
				p=p.rightChild;
			}
			//item이 루트의 값 보다 작을때
			else if(p.key>item) {
				p=p.leftChild;
			}
			//item과 루트의 값과 같을때
			else if(p.key==item) {
				return true;
			}

		}
		return false;

	}


	//(5) 최댓값 max
	public int max(){
		Node p =root;
		//노드의 값이 없을때
		if(p == null) {
			throw new NoSuchElementException("노드가 비었음");

		}
		//노드에 값이 있을때
		else {
			while(p !=null) {
				//오른쪽 서브트리가 없을때까지
				if(p.rightChild !=null) {
					p=p.rightChild;
				}
				else
					break;

			}

		}
		return p.key;
	}

	//(6) 삽입 add
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
		//삽입할 값 newNode 생성
		Node newNode=new Node(item);
		//루트가 비어있을때
		if(root==null) {
			root=newNode;
			return true;
		}
		//삽입할 item 값이 키값보다 클때
		else if(item>q.key) {
			q.rightChild=newNode;
			return true;
		}
		//삽입할 item 값이 키값보다 작을때
		else if(item<q.key) {
			q.leftChild=newNode;
			return true;
		}
		else
			return false;

	}
	//(7)삭제 remove 아직 구현 못함(노드 두개 일때가 문제)
	public boolean remove(int item) {
		//삭제할노드
		Node p=root;

		//삭제할 노드의 부모노드
		Node parent=null;

		//삭제할 노드 탐색
		while(p != null) {
			if(p.key==item)
				break;
			parent=p;
			if(item>p.key)
				p=p.rightChild;
			else if(item<p.key)
				p=p.leftChild;

		}
		//이진탐색트리가 비었을때
		if(p==null) {
			return false;
		}


		//삭제할 노드가 단말노드일때
		if(p.leftChild==null && p.rightChild==null) {
			if(parent==null) {
				root=null;
			}
			//p가 왼쪽 자식인 경우
			else if(parent.leftChild==p) {
				parent.leftChild=null;
			}
			//p가 오른쪽 자식인경우
			else if(parent.rightChild==p) {
				parent.rightChild=null;
			}
			return true;
		}
		//삭제할 노드의 자식이 하나인 경우 (키 값을 넣어야됨)
		else if(p.leftChild ==null || p.rightChild ==null) {

			//p가 왼쪽 자식만 갖는경우
			if(p.leftChild !=null) {
				//삭제후 p의 왼쪽 자식이 루트
				if(parent==null)
					root= p.leftChild;
				//p가 왼쪽 자식인 경우
				else if(parent.leftChild==p) 
					parent.leftChild=p.leftChild;
				//p가 오른쪽 자식인 경우
				else if(parent.rightChild==p) 
					parent.rightChild=p.leftChild;

				return true;
			}
			//p가 오른쪽 자식만 갖는 경우
			else {
				if(p.rightChild !=null) {
					//p의 오른쪽 자식이 루트가 됨
					if(parent==null)
						root=p.rightChild;
					//p가 왼쪽 자식인 경우
					else if(parent.leftChild==p)
						parent.leftChild=p.rightChild;
					//p가 오른쪽 자식인 경우
					else if(parent.rightChild==p)
						parent.rightChild=p.rightChild;
					return true;

				}
			}
		}
		//노드의 자식이 두개인 경우
		else {
			Node temp =p.leftChild;

			while(temp !=null) {
				//오른쪽 서브트리가 없을때까지
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

