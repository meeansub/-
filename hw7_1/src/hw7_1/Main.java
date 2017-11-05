//***************************
// ���ϸ�: Main.java
// �ۼ���: ��μ�
// �ۼ���: 17.10.31
// ����: ��ȣ���� �Է¹ް� �ùٸ� ��ȣ������ �˻��ϴ� ���α׷�
//***************************

package hw7_1;
import java.util.Scanner;
import java.util.Stack;
public class Main {

	public static void main(String[] args) {
		System.out.println("hw7_1 : ��μ�");

		Scanner input =new Scanner(System.in);

		//��ȣ�� �Է� 
		System.out.print("��ȣ�� �Է�:");
		String s=input.nextLine();
		
		//���� ��� Ȯ��
		if(checkStack(s)==true) {
			System.out.println("������ �ùٸ�");
		}else {
			System.out.println("������ �ùٸ��� ����");
		}




	}
	//�Է¹��� ���� �˻��ϴ� �޼ҵ�
	static boolean checkStack(String sc) {
		//���� �ϳ��� ���� c, �ݴ°�ȣ ���� ���� openPair
		char c, openPair;
		Stack<Character> stack =new Stack<Character>();

		//��ȣ�˻�
		for(int i=0;i<sc.length();i++) {
			c= sc.charAt(i);

			
			switch(c) {
			//���� ��ȣ�϶�
			case '(' :case'[': case '{':case'<':
				//����
				
				stack.push(c);
				break;
			//�ݴ� ��ȣ�϶�
			case ')':case']':case'}':case'>':
				//������ ��������� false
				if(stack.isEmpty()) {
					return false;
				}
				else {
					openPair=(char)stack.pop();
					//�ݴ°�ȣ�� ����� ��ġ���� ������ false
					if((openPair==')')&&(c !='(')||
						(openPair==']')&&(c !='[')||
						(openPair=='}')&&(c !='{')||
						(openPair=='>')&&(c !='<')) {
						return false;
					}
				}

				break;

			}
		}
		//�˻��� stack�� ������� true
		if(stack.isEmpty()) {
			return true;
		//�ƴϸ� false
		}else {
			return false;
		}
	
	
	
	
	}
	
	
	
	
}









