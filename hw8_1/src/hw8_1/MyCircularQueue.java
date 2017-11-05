package hw8_1;
//***************************
// ���ϸ�: MyCircularQueue.java
// �ۼ���: ��μ�
// �ۼ���: 17.11.05
// ����: int�� �ڷḦ �����ϴ� ť�� ���� ť�� �����ϰ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
//***************************
import java.util.NoSuchElementException;

public class MyCircularQueue {
	//�Ǿ� ���� ���� ����Ų��
	private int front;
	//�ǵڿ��Ҹ� ����Ų��
	private int rear;
	//ũ��
	private int queSize;
	//������ �迭
	private int[] queArray;
	
	
	
	//����
	public MyCircularQueue(int size) {
		front= 0;
		rear= 0;
		
		this.queSize=size;
		queArray=new int[queSize];
		
	}
	//������� Ȯ��
	public boolean isEmpty() {
		return (front==rear);
	}
	//��á���� Ȯ��
	public boolean isFull() {
		return ((rear+1)%queSize==front);
	}

	//���� �޼ҵ�
	public void enQueue(int item) {
		if(isFull())
			System.out.println("���Խ���: ť�� �������ֽ��ϴ�");
		else {
			rear= (rear+1)%queSize;
			queArray[rear]=item;
		  
		}
	}
	//���� �޼ҵ�, ������� ���� �߻�
	public int deQueue() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException("�������� :������ ����ֽ��ϴ�.������ ���Ұ� �����ϴ�.");
		}
		else {
			front=(front+1)%queSize;
			return queArray[front];
		}
			
	}
	//���
	public String toString() {
		StringBuffer str =new StringBuffer("���� ť-> ");
		for(int i=(front+1)%queSize;i!=(rear+1)%queSize;i=(i+1)%queSize) 
			str.append(queArray[i]  + " "); 
		return str.toString();

	}
}
