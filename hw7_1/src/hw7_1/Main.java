//***************************
// 파일명: Main.java
// 작성자: 김민섭
// 작성일: 17.10.31
// 설명: 괄호식을 입력받고 올바른 괄호식인지 검사하는 프로그램
//***************************

package hw7_1;
import java.util.Scanner;
import java.util.Stack;
public class Main {

	public static void main(String[] args) {
		System.out.println("hw7_1 : 김민섭");

		Scanner input =new Scanner(System.in);

		//괄호식 입력 
		System.out.print("괄호식 입력:");
		String s=input.nextLine();
		
		//수식 결과 확인
		if(checkStack(s)==true) {
			System.out.println("수식이 올바름");
		}else {
			System.out.println("수식이 올바르지 않음");
		}




	}
	//입력받은 수식 검사하는 메소드
	static boolean checkStack(String sc) {
		//문자 하나씩 저장 c, 닫는괄호 저장 변수 openPair
		char c, openPair;
		Stack<Character> stack =new Stack<Character>();

		//괄호검사
		for(int i=0;i<sc.length();i++) {
			c= sc.charAt(i);

			
			switch(c) {
			//여는 괄호일때
			case '(' :case'[': case '{':case'<':
				//스택
				
				stack.push(c);
				break;
			//닫는 괄호일때
			case ')':case']':case'}':case'>':
				//스택이 비어있으면 false
				if(stack.isEmpty()) {
					return false;
				}
				else {
					openPair=(char)stack.pop();
					//닫는괄호와 모양이 일치하지 않으면 false
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
		//검사후 stack이 비었으면 true
		if(stack.isEmpty()) {
			return true;
		//아니면 false
		}else {
			return false;
		}
	
	
	
	
	}
	
	
	
	
}









