/*
 * hw5_1
 * 201432005 ��μ�
 * MyList ����/���� 
 * ���� ����Ʈ�� �����ϴ� MyList Ŭ������ �ۼ��ϰ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�
 * 2017. 09. 18
 */
package hw5_1;

import java.util.Scanner;

class MyList{
	private int [] arr;
	private int capacity;
	private int count;

	//ũ�Ⱑ 10�������迭, ����뷮 10, ���尹��0 ������
	public MyList() {
		arr= new int[10];
		capacity=10;
		count=0;
	}
	//�������� �Ű������� �޾� �迭�� ����
	public void add(int num) {
		if(arr.length==count) {
			capacity *=2;
			int[] tempArray= new int[capacity];
			int length= arr.length;
			for(int i=0;i<length;i++) {
				tempArray[i]=arr[i];
			}
			arr=tempArray;
			System.out.println("�뷮����: "+capacity/2+"->"+capacity);
		}

		arr[count]=num;
		count++;

	}

	//����Ʈ ��ü�� �� �ٿ� ���
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


	//�ε����� �Ű������� �޾� �迭�� �ε��� ��ġ ���Ҹ� ����
	public int get(int index) {
		//�ε����� �Ű������� ���� �޼ҵ�鿡�� �ε����� �߸��� ������ ���
		if(index<0 || index >count-1) {
			System.out.println("�ε��� ��ġ�� �߸��Ǿ����ϴ�");
			System.out.println("���α׷��� �����մϴ�");
			System.exit(0);
		}
		
		return arr[index];
	}

	//�ε��� ���� �� �Ű�����,�迭�� �ε��� ��ġ ���Ҹ� ���������� ��ġ
	public void set(int index,int num) {
		//�ε����� �Ű������� ���� �޼ҵ�鿡�� �ε����� �߸��� ������ ���
		if(index<0 || index >count-1) {
			System.out.println("�ε��� ��ġ�� �߸��Ǿ����ϴ�");
			System.out.println("���α׷��� �����մϴ�");
			System.exit(0);
		}
		
		arr[index]=num;
	}

	//����� ���� ������ ����
	public int size() {
		return count;
	}

	//�ε��� ������ �Ű�����, �迭�� �ε��� ��ġ�� ����
	public void add(int index, int num) {
		//�ε����� �Ű������� ���� �޼ҵ�鿡�� �ε����� �߸��� ������ ���
		if(index<0 || index >count-1) {
			System.out.println("�ε��� ��ġ�� �߸��Ǿ����ϴ�");
			System.out.println("���α׷��� �����մϴ�");
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

			System.out.println("�뷮����: "+capacity/2+"->"+capacity);
		}

		for(int i=count-1;i>=index;i--) {
			arr[i+1]=arr[i];
		}
		count++;

		arr[index]=num;
	}

	//�ε��� �Ű�����, �迭�� �ε��� ��ġ ���� �����ϰ� ����
	public int remove(int index) {
		//�ε����� �Ű������� ���� �޼ҵ�鿡�� �ε����� �߸��� ������ ���
		if(index<0 || index >count-1) {
			System.out.println("�ε��� ��ġ�� �߸��Ǿ����ϴ�");
			System.out.println("���α׷��� �����մϴ�");
			System.exit(0);
		}
		
		//������ �ε��� ���� remove������ ����
		int remove = arr[index];
		//���� �ε��� ���� �ִ� ������ ��ĭ�� ���
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
		System.out.println("hw5_1 : ��μ�");
		Scanner input =new Scanner(System.in);

		//MyList ��ü ����
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

		//����Ʈ ũ�� Ȯ��
		int size=list.size();
		System.out.println("����Ʈ ũ��="+size);

		//��ȸ
		System.out.print("��ȸ�� �ε��� �Է�: ");
		int index= input.nextInt();
		System.out.println("�ε��� "+index+"�� ����: "+list.get(index)+"\n");

		//����
		System.out.print("777�� ������ �ε��� �Է�: ");
		index= input.nextInt();
		list.set(index, 777);
		System.out.println(list+"\n");

		//����
		System.out.print("999�� ������ �ε��� �Է�: ");
		index= input.nextInt();
		list.add(index, 999);
		System.out.println(list+"\n");

		//����
		System.out.print("������ �ε��� �Է�: ");
		index= input.nextInt();
		System.out.println("������ �ε��� "+index+"�� ���� ="+list.get(index));
		list.remove(index);
		System.out.println(list);

		//***********�ɼ�1**************
		System.out.println("\n******�ɼ�1 ���********");

		for(int i=1;i<26;i++) {
			list.add(i);
		}
		System.out.println(list);


	}

}
