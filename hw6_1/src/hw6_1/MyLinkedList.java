package hw6_1;

//***************************
//파일명: MyLinkedListTest.java
//작성자: 김민섭
//작성일: 2017 10 05
//설명: 정수 리스트를 관리하는 MyLinkedList 클래스를 작성하고 사용하는 프로그램
//***************************
public class MyLinkedList {
	// (1) 인스턴스 변수 head 선언: 연결리스트의 첫번째 노드를 가리킴
	private  Node head;	

	// (2)리스트의 길이를 알아보기 위해
	private int count;

	// (3) 비어있는 리스트를 생성
	public MyLinkedList() {
		head=null;
		count=0;
	}

	// (4) 리스트의 맨 앞에 item을 삽입
	public void addFirst(int item) {
		// data 필드가 item인 새로운 Node 객체를 생성(newNode)
		Node newNode =new Node(item);
		count++;

		// head가 가리키는 연결리스트의 맨 앞에 newNode를 삽입
		newNode.link=head;
		head=newNode;
	}

	// (5) 리스트의 길이를 리턴
	public int size() {
		return count;
	}

	// (6)리스트 원소들을 모두 출력
	public void printList() {
		Node temp = head;
		System.out.print("[");
		while(temp != null) {
			System.out.print(temp.data);
			temp = temp.link;
			if(temp != null)
				System.out.print(", ");
		}
		System.out.println("]");
	}
	//(7)첫번째 원소를 삭제하고 원소값을 리턴(삭제할 원소가 없을경우)
	public Object removeFirst() {
		if(head==null) {
			System.out.println("삭제할 원소가 없습니다");
			return null;

		}
		else {
			Node temp=head;
			head=temp.link;
			temp.link=null;
			count--;
			Object remove=temp.data;

			return remove;
		}

	}


	//(8)정수값을 매개변수로 받아  검색 결과(boolean값) 리턴
	public boolean contains(int input) {
		Node temp=head;
		while(temp !=null) {
			if(temp.data==input)
				return true;
			temp=temp.link;
		}

		return false;

	}
	//입력받은 인덱스 안의 값이 무었인지 리턴
	Node node(int index) {
		Node x= head;
		for(int i=0; i<index; i++) {
			x= x.link;
		}
		return x;
	}
	//(9)인덱스 정수값 매개변수, 리스트의 인덱스위치에 정수값 삽입
	public void add(int index, int input) {
		if(index<0 || index>count) {
			System.out.println("잘못된 인덱스 입니다");
		}
		else if(index==0) {
			addFirst(input);
		}
		else{
			Node temp1= node(index-1);
			Node temp2=temp1.link;

			Node newNode= new Node(input);
			newNode.link=temp2;
			temp1.link= newNode;
			
			
			
			count++;
		}

	}


	//(10)인덱스 매개변수로 받아 리스트의 인덱스 위치 원소를삭제 원소값을 리턴
	public Object remove(int index) {

		if(index<0 || index>=count) {
			System.out.println("잘못된 인덱스 입니다");
			return null;

		}
		//첫번째 인덱스 일때
		else if(index==0) {
			return removeFirst();
		}
		//나머지 인덱스 일때

		Node temp= node(index-1);
		Node remove= temp.link;
		temp.link=remove.link;
		count--;
		return remove.data;

	}

	//(11)문자열로 출력
	@Override
	public String toString() {
		StringBuilder str =new StringBuilder();
		Node temp=head;
		str.append("[");
		while(temp!=null) {
			str.append(temp.data);
			temp= temp.link;
			if(temp !=null)
				str.append(", ");

		}
		str.append("]");
		return str.toString();

	}
	//옵션1 사용자로부터 x,y를 입력받아서 x값 다음에 y값을 집어넣는 메소드
	public void inserNext(int x, int y) {
		Node temp=head;
		Node pre=null;
		Node newNode= new Node(y);
		while(temp!=null) {
			if(temp.data==x) {
				newNode.link=temp.link;
				temp.link=newNode;
				
				count++;
				break;

			}
			temp=temp.link;
			
		}


	}




	//옵션2 사용자로부터 x를 입력받아 해당하는 x 값을 삭제
	public void removeMatch(int x) {
		Node pre,temp;
		if(head==null) {
			System.out.println("삭제할 원소가 없습니다");
		}
		//삭제할 원소가 첫번째 노드일때 삭제
		if(head.data==x) {
			removeFirst();

		}

		else {
			pre=null;
			temp=head;
			while(temp !=null) {
				if(temp.link==null) {
					pre.link=null;
					break;
				}
				if(temp.data==x) {
					pre.link=temp.link;
					temp.link=pre;
					break;
				}
				pre=temp;
				temp=temp.link;
			}
			count--;
		}
	}


	// 리스트에서 item이 저장된 노드를 탐색하는 private 메소드 -- lab6_1에서는 사용하지 않음
	private Node searchNode(int item) {
		Node temp = head;
		while(temp != null) {
			if(item == temp.data)  
				return temp;		// 탐색 성공시 해당 노드 리턴
			else 
				temp = temp.link;
		}
		return temp;				// 탐색 실패시 null 리턴
	}

	// 연결리스트 노드 구조를 표현하는 private 클래스
	private class Node {
		int data;	 //정수값을 저장할 데이터 필드 data 선언
		Node link;	 //다음 노드 참조값을 저장할 링크 필드link 선언

		Node() {
			data = 0;
			link = null;
		}

		Node(int data) {
			this.data = data;
			this.link = null;
		}

		Node(int data, Node link) {
			this.data = data;
			this.link = link;
		}
	}
}