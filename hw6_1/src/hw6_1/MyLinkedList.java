package hw6_1;

//***************************
//���ϸ�: MyLinkedListTest.java
//�ۼ���: ��μ�
//�ۼ���: 2017 10 05
//����: ���� ����Ʈ�� �����ϴ� MyLinkedList Ŭ������ �ۼ��ϰ� ����ϴ� ���α׷�
//***************************
public class MyLinkedList {
	// (1) �ν��Ͻ� ���� head ����: ���Ḯ��Ʈ�� ù��° ��带 ����Ŵ
	private  Node head;	

	// (2)����Ʈ�� ���̸� �˾ƺ��� ����
	private int count;

	// (3) ����ִ� ����Ʈ�� ����
	public MyLinkedList() {
		head=null;
		count=0;
	}

	// (4) ����Ʈ�� �� �տ� item�� ����
	public void addFirst(int item) {
		// data �ʵ尡 item�� ���ο� Node ��ü�� ����(newNode)
		Node newNode =new Node(item);
		count++;

		// head�� ����Ű�� ���Ḯ��Ʈ�� �� �տ� newNode�� ����
		newNode.link=head;
		head=newNode;
	}

	// (5) ����Ʈ�� ���̸� ����
	public int size() {
		return count;
	}

	// (6)����Ʈ ���ҵ��� ��� ���
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
	//(7)ù��° ���Ҹ� �����ϰ� ���Ұ��� ����(������ ���Ұ� �������)
	public Object removeFirst() {
		if(head==null) {
			System.out.println("������ ���Ұ� �����ϴ�");
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


	//(8)�������� �Ű������� �޾�  �˻� ���(boolean��) ����
	public boolean contains(int input) {
		Node temp=head;
		while(temp !=null) {
			if(temp.data==input)
				return true;
			temp=temp.link;
		}

		return false;

	}
	//�Է¹��� �ε��� ���� ���� �������� ����
	Node node(int index) {
		Node x= head;
		for(int i=0; i<index; i++) {
			x= x.link;
		}
		return x;
	}
	//(9)�ε��� ������ �Ű�����, ����Ʈ�� �ε�����ġ�� ������ ����
	public void add(int index, int input) {
		if(index<0 || index>count) {
			System.out.println("�߸��� �ε��� �Դϴ�");
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


	//(10)�ε��� �Ű������� �޾� ����Ʈ�� �ε��� ��ġ ���Ҹ����� ���Ұ��� ����
	public Object remove(int index) {

		if(index<0 || index>=count) {
			System.out.println("�߸��� �ε��� �Դϴ�");
			return null;

		}
		//ù��° �ε��� �϶�
		else if(index==0) {
			return removeFirst();
		}
		//������ �ε��� �϶�

		Node temp= node(index-1);
		Node remove= temp.link;
		temp.link=remove.link;
		count--;
		return remove.data;

	}

	//(11)���ڿ��� ���
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
	//�ɼ�1 ����ڷκ��� x,y�� �Է¹޾Ƽ� x�� ������ y���� ����ִ� �޼ҵ�
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




	//�ɼ�2 ����ڷκ��� x�� �Է¹޾� �ش��ϴ� x ���� ����
	public void removeMatch(int x) {
		Node pre,temp;
		if(head==null) {
			System.out.println("������ ���Ұ� �����ϴ�");
		}
		//������ ���Ұ� ù��° ����϶� ����
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


	// ����Ʈ���� item�� ����� ��带 Ž���ϴ� private �޼ҵ� -- lab6_1������ ������� ����
	private Node searchNode(int item) {
		Node temp = head;
		while(temp != null) {
			if(item == temp.data)  
				return temp;		// Ž�� ������ �ش� ��� ����
			else 
				temp = temp.link;
		}
		return temp;				// Ž�� ���н� null ����
	}

	// ���Ḯ��Ʈ ��� ������ ǥ���ϴ� private Ŭ����
	private class Node {
		int data;	 //�������� ������ ������ �ʵ� data ����
		Node link;	 //���� ��� �������� ������ ��ũ �ʵ�link ����

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