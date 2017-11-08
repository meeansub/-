package hw8_2;

import java.util.NoSuchElementException;

//***************************
// 파일명: MyLinkedQueue.java
// 작성자: 김민섭
// 작성일: 17.11.08
// 설명: 연결자료구조로 구현한 큐
//***************************
public class MyLinkedQueue {

	private Node front;
	private Node rear;
	public MyLinkedQueue() {
		front=null;
		rear=null;
	}
	//isEmpty: 큐가 비어있는지 여부를 리턴
	public boolean isEmpty() {
		return front==null;
	}
	// enQueue: 정수값을 매개변수로 받아 큐의 가장 뒤에 저장한다. 
	public void enQueue(int item) {
		Node newNode=new Node();
		newNode.data=item;
		//노드가 비었을때 삽입
		if(isEmpty()) {
			front=newNode;
			rear=newNode;
		}
		else {
			rear.link=newNode;
			rear=newNode;
		}
	}
	// deQueue: 큐의 가장 앞의 값을 삭제하여 리턴한다. 
	// 배열이 비어서 삭제할 수 없을 때는 예외 발생 
	public int deQueue() throws NoSuchElementException{
		if(isEmpty()) {
			throw new NoSuchElementException("삭제실패!:삭제할 원소가 없습니다.");
			
		}
		//삭제연산
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