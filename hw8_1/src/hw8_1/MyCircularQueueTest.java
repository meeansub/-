package hw8_1;
//***************************
// 파일명: MyCircularQueueTest.java
// 작성자: 김민섭
// 작성일: 2017.11.05
// 설명: int형 자료를 저장하는 큐를 원형 큐로 구현하고 사용하는 프로그램을 작성하시오.
//***************************
import java.util.Scanner;

public class MyCircularQueueTest {

	public static void main(String[] args) {
		System.out.println("hw8_1:김민섭");
		// TODO Auto-generated method stub
		MyCircularQueue myQue =new MyCircularQueue(5);
		Scanner scan = new Scanner(System.in);
		System.out.println("메뉴 번호를 입력하세요.");
		int menu = 0;
		int item = 0;
		do {
			System.out.print("1:삽입2:삭제 3:전체삭제 4:종료 --->");
			menu = scan.nextInt();
			
			switch (menu) {
			case 1:
				System.out.println("삽입을 수행합니다.");
				System.out.print("삽입할 정수값 입력:");
				item=scan.nextInt();
				myQue.enQueue(item);
				System.out.println(myQue.toString());
		
				break;
			case 2:
				System.out.println("삭제를 수행합니다.");
				System.out.println("삭제한 값:");
				myQue.deQueue();
				System.out.println(myQue.toString());
				break;
			
			case 3:
				System.out.println("전체삭제를 수행합니다.");
				System.out.print("전체 삭제한값:");
				while(myQue.isEmpty()!=true) {
					System.out.print(myQue.deQueue()+" ");
				}
				System.out.println("");
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("메뉴 번호 오류: 메뉴를 다시 선택하세요.");
			}
		}while(menu !=4);
	}
}
