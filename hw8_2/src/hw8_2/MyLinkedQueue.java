package hw8_2;

import java.util.NoSuchElementException;

//***************************
// ���ϸ�: MyLinkedQueue.java
// �ۼ���: ��μ�
// �ۼ���: 17.11.08
// ����: �����ڷᱸ���� ������ ť
//***************************
public class MyLinkedQueue {

	private Node front;
	private Node rear;
	public MyLinkedQueue() {
		front=null;
		rear=null;
	}
	//isEmpty: ť�� ����ִ��� ���θ� ����
	public boolean isEmpty() {
		return front==null;
	}
	// enQueue: �������� �Ű������� �޾� ť�� ���� �ڿ� �����Ѵ�. 
	public void enQueue(int item) {
		Node newNode=new Node();
		newNode.data=item;
		//��尡 ������� ����
		if(isEmpty()) {
			front=newNode;
			rear=newNode;
		}
		else {
			rear.link=newNode;
			rear=newNode;
		}
	}
	// deQueue: ť�� ���� ���� ���� �����Ͽ� �����Ѵ�. 
	// �迭�� �� ������ �� ���� ���� ���� �߻� 
	public int deQueue() throws NoSuchElementException{
		if(isEmpty()) {
			throw new NoSuchElementException("��������!:������ ���Ұ� �����ϴ�.");
			
		}
		//��������
		else {
			int remove=front.data;
			front=front.link;
			return remove;
		}
		
	}
	@Override
	public String toString() {
		StringBuilder str=new StringBuilder("LinkedQue->");
		Node temp=front;
		while(temp !=null) {
			str.append(temp.data+" ");
			temp=temp.link;
		}
		return str.toString();
	}
	
	
	
}
class Node{
	int data;
	Node link;
	public Node() {
		link=null;
	}
}