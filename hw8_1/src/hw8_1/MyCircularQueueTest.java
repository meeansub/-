package hw8_1;
//***************************
// ���ϸ�: MyCircularQueueTest.java
// �ۼ���: ��μ�
// �ۼ���: 2017.11.05
// ����: int�� �ڷḦ �����ϴ� ť�� ���� ť�� �����ϰ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
//***************************
import java.util.Scanner;

public class MyCircularQueueTest {

	public static void main(String[] args) {
		System.out.println("hw8_1:��μ�");
		// TODO Auto-generated method stub
		MyCircularQueue myQue =new MyCircularQueue(5);
		Scanner scan = new Scanner(System.in);
		System.out.println("�޴� ��ȣ�� �Է��ϼ���.");
		int menu = 0;
		int item = 0;
		do {
			System.out.print("1:����2:���� 3:��ü���� 4:���� --->");
			menu = scan.nextInt();
			
			switch (menu) {
			case 1:
				System.out.println("������ �����մϴ�.");
				System.out.print("������ ������ �Է�:");
				item=scan.nextInt();
				myQue.enQueue(item);
				System.out.println(myQue.toString());
		
				break;
			case 2:
				System.out.println("������ �����մϴ�.");
				System.out.println("������ ��:");
				myQue.deQueue();
				System.out.println(myQue.toString());
				break;
			
			case 3:
				System.out.println("��ü������ �����մϴ�.");
				System.out.print("��ü �����Ѱ�:");
				while(myQue.isEmpty()!=true) {
					System.out.print(myQue.deQueue()+" ");
				}
				System.out.println("");
				break;
			case 4:
				System.out.println("���α׷��� �����մϴ�.");
				break;
			default:
				System.out.println("�޴� ��ȣ ����: �޴��� �ٽ� �����ϼ���.");
			}
		}while(menu !=4);
	}
}
