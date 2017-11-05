package hw8_1;
//***************************
// 파일명: MyCircularQueue.java
// 작성자: 김민섭
// 작성일: 17.11.05
// 설명: int형 자료를 저장하는 큐를 원형 큐로 구현하고 사용하는 프로그램을 작성하시오.
//***************************
import java.util.NoSuchElementException;

public class MyCircularQueue {
	//맨앞 원소 앞을 가리킨다
	private int front;
	//맨뒤원소를 가리킨다
	private int rear;
	//크기
	private int queSize;
	//정수형 배열
	private int[] queArray;
	
	
	
	//생성
	public MyCircularQueue(int size) {
		front= 0;
		rear= 0;
		
		this.queSize=size;
		queArray=new int[queSize];
		
	}
	//비었는지 확인
	public boolean isEmpty() {
		return (front==rear);
	}
	//꽉찼는지 확인
	public boolean isFull() {
		return ((rear+1)%queSize==front);
	}

	//삽입 메소드
	public void enQueue(int item) {
		if(isFull())
			System.out.println("삽입실패: 큐가 가득차있습니다");
		else {
			rear= (rear+1)%queSize;
			queArray[rear]=item;
		  
		}
	}
	//삭제 메소드, 비었을때 오류 발생
	public int deQueue() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException("삭제실패 :스택이 비어있습니다.삭제할 원소가 없습니다.");
		}
		else {
			front=(front+1)%queSize;
			return queArray[front];
		}
			
	}
	//출력
	public String toString() {
		StringBuffer str =new StringBuffer("원형 큐-> ");
		for(int i=(front+1)%queSize;i!=(rear+1)%queSize;i=(i+1)%queSize) 
			str.append(queArray[i]  + " "); 
		return str.toString();

	}
}
