package hw10_1;

import java.util.LinkedList;

/* 
 * ���ϸ�: ListGraph.java
 * �ۼ���: 2017.11.28
 * �ۼ���: ��μ�
 * ����: ������ �׷����� �����ϰ� ������ �����ϴ� ���α׷� ,��������Ʈ
 */
public class ListGraph {
	private Node[] list; //������ ���� ����� �迭 ����
	private int n; //vertex ���
	
	
	
	public ListGraph(int n) {
		list=new Node[n];
		this.n=n;
		
	}
	// ������ �̷�� �ΰ��� ���� v1, v2�� �Ű������� �޾� �׷����� ������ �߰�
	public void addEdge(int v1, int v2) {
		
		//�߸��� ���� ��ȣ�� ��� ���� �޽��� ���
		if(v1<0 || v1>=n ||v2<0 || v2>=n || v1==v2)
			System.out.println("���� ���Կ��� -�߸��� ���� ��ȣ�Դϴ�");
		//�̹� �����ϴ� ������ ��� ���� �޽��� ���    
		else if(list[v1]==null) {
			Node newNode =new Node();
			newNode.vertex=v2;
			list[v1]=newNode;

			Node newNode2=new Node();
			newNode2.vertex=v1;
			list[v2]=newNode2;
		}

		else if(list[v1]!=null){
			Node temp=list[v1];
			while(temp!=null) {
				if(temp.vertex==v2) {
					System.out.println("�̹� �����ϴ� �����Դϴ�");
					break;
				}
				else
					temp=temp.link;
			}
			//�̹� �����ϴ� ������ ������
			if(temp==null) {
				//������ �׷����̱� ������ ���� �ΰ��� ��� �� ����
				Node newNode =new Node();
				newNode.vertex=v2;
				newNode.link=list[v1];
				list[v1]=newNode;

				Node newNode2=new Node();
				newNode2.vertex=v1;
				newNode2.link=list[v2];
				list[v2]=newNode2;
			}



		}

	}


	//������ �Ű������� �޾� �� ������ ������ �������� ��� ���
	public void printAdjacentVertices(int v1) {
		//�߸��� ���� ��ȣ�� ��� ���� �޽��� ���
		if(v1<0 || v1>=n)
			System.out.println("���� ���� ��� ���� - �߸��� ���� ��ȣ �Դϴ�");
		else {
			System.out.print("����"+v1+"�� ������ ����:");
			for(Node temp=list[v1];temp !=null;temp=temp.link) {
				
				System.out.print(+temp.vertex);
				
				if(temp.link!=null) {
					System.out.print("->");
				}
			}
		}

	}

	private class Node{
		int vertex;
		Node link;

	}

}
