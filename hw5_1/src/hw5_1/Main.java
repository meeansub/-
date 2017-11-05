/*
 * hw5_1
 * 201432005 김민섭
 * MyList 삽입/삭제 
 * 정수 리스트를 관리하는 MyList 클래스를 작성하고 사용하는 프로그램을 작성하시오
 * 2017. 09. 18
 */
package hw5_1;

import java.util.Scanner;

class MyList{
	private int [] arr;
	private int capacity;
	private int count;

	//크기가 10인정수배열, 저장용량 10, 저장갯수0 생성자
	public MyList() {
		arr= new int[10];
		capacity=10;
		count=0;
	}
	//정수값을 매개변수로 받아 배열에 저장
	public void add(int num) {
		if(arr.length==count) {
			capacity *=2;
			int[] tempArray= new int[capacity];
			int length= arr.length;
			for(int i=0;i<length;i++) {
				tempArray[i]=arr[i];
			}
			arr=tempArray;
			System.out.println("용량증가: "+capacity/2+"->"+capacity);
		}

		arr[count]=num;
		count++;

	}

	//리스트 전체를 한 줄에 출력
	public void print() {
		System.out.print("[");

		for(int i=0;i<count;i++) {
			System.out.print(arr[i]);

			if(i<count-1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}


	//인덱스를 매개변수로 받아 배열의 인덱스 위치 원소를 리턴
	public int get(int index) {
		//인덱스를 매개변수로 갖는 메소드들에서 인덱스가 잘못된 범위인 경우
		if(index<0 || index >count-1) {
			System.out.println("인덱스 위치가 잘못되었습니다");
			System.out.println("프로그램을 종료합니다");
			System.exit(0);
		}
		
		return arr[index];
	}

	//인덱스 정수 값 매개변수,배열의 인덱스 위치 원소를 정수값으로 대치
	public void set(int index,int num) {
		//인덱스를 매개변수로 갖는 메소드들에서 인덱스가 잘못된 범위인 경우
		if(index<0 || index >count-1) {
			System.out.println("인덱스 위치가 잘못되었습니다");
			System.out.println("프로그램을 종료합니다");
			System.exit(0);
		}
		
		arr[index]=num;
	}

	//저장된 정수 개수를 리턴
	public int size() {
		return count;
	}

	//인덱스 정수값 매개변수, 배열의 인덱스 위치에 삽입
	public void add(int index, int num) {
		//인덱스를 매개변수로 갖는 메소드들에서 인덱스가 잘못된 범위인 경우
		if(index<0 || index >count-1) {
			System.out.println("인덱스 위치가 잘못되었습니다");
			System.out.println("프로그램을 종료합니다");
			System.exit(0);
		}
		
		if(arr.length<count) {
			capacity *=2;
			int[] tempArray= new int[capacity];
			int length= arr.length;
			for(int i=0;i<length;i++) {
				tempArray[i]=arr[i];
			}
			arr=tempArray;

			System.out.println("용량증가: "+capacity/2+"->"+capacity);
		}

		for(int i=count-1;i>=index;i--) {
			arr[i+1]=arr[i];
		}
		count++;

		arr[index]=num;
	}

	//인덱스 매개변수, 배열의 인덱스 위치 원소 삭제하고 리턴
	public int remove(int index) {
		//인덱스를 매개변수로 갖는 메소드들에서 인덱스가 잘못된 범위인 경우
		if(index<0 || index >count-1) {
			System.out.println("인덱스 위치가 잘못되었습니다");
			System.out.println("프로그램을 종료합니다");
			System.exit(0);
		}
		
		//삭제할 인덱스 원소 remove변수에 저장
		int remove = arr[index];
		//삭제 인덱스 위에 있는 값들을 한칸씩 당김
		for(int i=index+1;i<=count-1;i++) {
			arr[i-1]=arr[i];

		}
		count--;
		return remove;

	}


	@Override
	public String toString() {
		StringBuffer str = new StringBuffer("[");
		for(int i=0;i<count;i++) {
			str.append(arr[i]);
			if(i<count-1) {
				str.append(", ");
			}
		}
		return str.toString()+"]";


	}
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw5_1 : 김민섭");
		Scanner input =new Scanner(System.in);

		//MyList 객체 생성
		MyList list = new MyList();
		list.add(20);
		list.add(30);
		list.add(20);
		list.add(40);
		list.add(-999);
		list.add(50);
		list.add(90);
		list.add(10);

		System.out.println(list);

		//리스트 크기 확인
		int size=list.size();
		System.out.println("리스트 크기="+size);

		//조회
		System.out.print("조회할 인덱스 입력: ");
		int index= input.nextInt();
		System.out.println("인덱스 "+index+"의 원소: "+list.get(index)+"\n");

		//갱신
		System.out.print("777로 갱신할 인덱스 입력: ");
		index= input.nextInt();
		list.set(index, 777);
		System.out.println(list+"\n");

		//삽입
		System.out.print("999를 삽입할 인덱스 입력: ");
		index= input.nextInt();
		list.add(index, 999);
		System.out.println(list+"\n");

		//삭제
		System.out.print("삭제할 인덱스 입력: ");
		index= input.nextInt();
		System.out.println("삭제할 인덱스 "+index+"의 원소 ="+list.get(index));
		list.remove(index);
		System.out.println(list);

		//***********옵션1**************
		System.out.println("\n******옵션1 출력********");

		for(int i=1;i<26;i++) {
			list.add(i);
		}
		System.out.println(list);


	}

}
