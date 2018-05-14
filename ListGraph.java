

import java.util.LinkedList;
import java.util.Queue;

/* 
 * ���ϸ�: ListGraph.java
 * �ۼ���: 2017.12.05
 * �ۼ���: ��μ�
 * ����: ������ �׷����� �����ϰ� ������ �����ϴ� ���α׷� ,��������Ʈ
public class ListGraph {
	private Node[] list; //������ ���� ����� �迭 ����
	private int n; //vertex ���
	private boolean[] visited;
	private Queue<Integer> queue;

	public ListGraph(int n) {
		list=new Node[n];
		this.n=n;
		this.visited=new boolean[n];
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
	//���� �켱 Ž�� (DFS)
	public void depthFirstSearch() {

		//�湮���� �ʾ����� false �ʱⰪ
		for(int i=0; i<n; i++) {
			visited[i]=false;
		}

		//�湮���� ���� �����̸� Ž��
		for(int i=0; i<n; i++) {
			if(visited[i]==false) {
				dfs(i);
			}
		}
	} 
	//���� �켱 Ž�� (DFS)
	public void dfs(int v) {

		//�湮
		visited[v]=true;
		
		System.out.print(v+" ");
		
		//���� v�ȿ� ������ ���� ���̿켱 Ž��
		for(Node temp=list[v];temp !=null;temp=temp.link) {
			if(temp !=null && !visited[temp.vertex]) {
				//System.out.println(v+"���� "+temp.vertex+"�� �̵�");
				
				dfs(temp.vertex);
			
			}
			
		}
		

	}


	//�ʺ�켱Ž��(BFS)
	public void breadthFirstSearch() {
		//���� n���� �湮���� �ʱⰪ false ����
		for(int i=0;i<n;i++) {
			visited[i]=false;
		}

		//�湮���� ���� �����̸� �湮
		for(int i=0;i<n;i++) {
			if(visited[i]==false)
				bfs(i);
		}

	}
	//�ʺ�켱Ž��(BFS)
	public void bfs(int v) {
		queue=new LinkedList<Integer>();

		//�湮
		visited[v]=true;
		//ť�� ���� ����
		queue.add(v);

		//ť�� ������� ����������
		while(!queue.isEmpty()) {

			//������ ť���� ���� ������ ����
			int w=queue.remove();

			//���� w�� ��������Ʈ ã�� Ž��
			for(Node temp=list[w];temp !=null;temp=temp.link) {
				if(temp !=null && !visited[temp.vertex]) {

					visited[temp.vertex]=true;
					queue.add(temp.vertex);

				}


			}
			System.out.print(w+" ");

		}

	}

	private class Node{
		int vertex;
		Node link;

	}

}
