package hw6_3;



/*
 * 파일명: MyDoublyLinkedList.java
 * 작성자: 김민섭
 * 작성일: 2017년 10월 05일
 * 내용: 이중연결자료구조로 선형리스트를 구현한 MyDoublyLinkedList 클래스
 */

public class MyDoublyLinkedList {

	private Node head;	// 리스트의 첫번째 노드를 가리킬 변수
	private int count;	// 리스트의 원소 수를 나타내는 변수

	public MyDoublyLinkedList() {
		head = null;
		count = 0;
	}

	// 리스트 길이를 리턴
	public int size() {
		return count;
	}

	//1
	@Override
	public String toString() {
		StringBuilder str= new StringBuilder();
		Node temp=head;
		str.append("[");
		while(temp !=null) {
			str.append(temp.data);
			temp=temp.rlink;
			if(temp !=null) {
				str.append(", ");
			}
		}
		str.append("]");
		return str.toString();

	}
	// 2.리스트의 맨 앞에 item을 삽입
	public void addFirst(int item) {

		// (1) 데이터가 item인 새로운 노드 생성
		Node newNode = new Node(item);

		// (2) 새로운 노드를 리스트의 맨 앞에 삽입
		if(head==null) {
			head=newNode;
		}
		else {
			newNode.rlink= head;
			head.llink=newNode;
			head=newNode;
		}
		// (3) 원소 수 1 증가
		count++;
	}
	//3. 맨앞삭제
	public Object removeFirst() {
		Object remove;
		if(head==null) {
			System.out.println("리스트가 비었습니다.");
			return null;

		}
		if(head.rlink==null) {
			remove=head.data;
			head=null;
			count--;
			return remove;
		}
		else {
			Node temp=head;
			temp.rlink.llink=temp.llink;
			head=temp.rlink;
			remove=temp.data;
			count--;
			return remove;
		}

	}

	//4. 값삭제
	public void remove(int input) {
		Node pre,temp;
		//리스트가 비었을때
		if(head==null) {
			System.out.println("리스트가 비었습니다.");
		}
		//첫번째 노드 삭제 일때
		if(head.data==input) {
			removeFirst();
		}
		//리스트값 삭제할노드가 마지막 노드일때

		//나머지
		else {
			pre = null;
			temp = head;
			while(temp != null) {
				if(temp.rlink==null) {
					if(temp.data ==input) {
					pre.rlink=null;
					break;
					}
				}
				
				if(temp.data ==input) {
					pre.rlink=temp.rlink;
					temp.rlink.llink=pre;
					break;
				}


				pre=temp;
				temp=temp.rlink;
			}
			count--;

		}
	}


		// 리스트가 양방향연결이 제대로 이루어졌는지 확인
		public void printLink() {
			if (head == null) {
				System.out.println("공백리스트임");
			}
			else {
				// 리스트를 순방향으로 출력
				Node temp = head;
				System.out.print("리스트 길이=" + count + " 순방향 링크: ");
				while(temp.rlink != null) {
					System.out.print(temp.data + "->");
					temp = temp.rlink;
				}
				System.out.print(temp.data);

				// 리스트를 역방향으로 출력
				System.out.print(" 역방향 링크: ");
				while(temp.llink != null) {
					System.out.print(temp.data + "->");
					temp = temp.llink;
				}
				System.out.println(temp.data);
			}
		}

		// 이중연결리스트 노드 구조
		private class Node {
			int data;
			Node llink; 
			Node rlink;

			Node() {
				this(0, null, null);
			}
			Node(int data) {
				this(data, null, null);
			}
			Node(int data, Node llink, Node rlink) {
				this.data = data;
				this.llink = llink;
				this.rlink = rlink;
			}
		}
	}