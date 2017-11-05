
package hw6_3;

import java.util.Scanner;

public class MyDoublyLinkedListTest {
	public static void main(String[] args) {
		
		System.out.println("hw6_3: 김민섭\n");

		MyDoublyLinkedList list = new MyDoublyLinkedList();

		Scanner scan = new Scanner(System.in);
		System.out.println("메뉴 번호를 입력하세요.");
		int menu = 0;
		int item = 0;
		do {
			System.out.print("1:리스트출력 2:맨앞삽입 3:맨앞삭제 4:값삭제 8:양방향연결확인 9:종료 --->");
			menu = scan.nextInt();
			switch(menu) {
			case 1:
				System.out.println("리스트출력을 수행합니다.");
				System.out.println(list.toString());
				break;
			case 2:
				System.out.println("맨앞삽입을 수행합니다.");
				System.out.print("삽입할 정수 입력:");
				item = scan.nextInt();
				list.addFirst(item);
				break;
			case 3:
				System.out.println("맨앞삭제를 수행합니다.");
				System.out.println("삭제한 원소 = " + list.removeFirst());
				break;
			case 4:
				System.out.println("값삭제를 수행합니다.");
				System.out.print("삭제할 정수 입력:");
				item = scan.nextInt();
				list.remove(item);
				break;
			case 8:
				System.out.println("양방향 연결을 확인합니다.");
				list.printLink();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("메뉴 번호 오류: 메뉴를 다시 선택하세요.");
			}
		} while(menu != 9);
	}
}
