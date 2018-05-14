package hw10_2;

/* 
 * ���ϸ�: MatrixGraph.java
 * �ۼ���: 2017.12.05
 * �ۼ���: ��μ�
 * ����: ������ �׷����� �����ϰ� ������ �����ϴ� ���α׷� ,DFS,BFS
 */
import java.util.LinkedList;
import java.util.Queue;


public class MatrixGraph {
	//������ ������ �����ؼ� ������ ����� ����
	private int[][] matrix;
	//�� �������� n
	private int n; 
	//�湮���� ����
	private boolean[] visited;
	//�ʺ�켱Ž���� ���� ť
	private Queue<Integer> queue;

	
	
	public MatrixGraph(int n) {
		matrix= new int[n][n];
		this.n=n;
		this.visited=new boolean[n];

	}
	//���� �����ؼ� ���������
	public void addEdge(int v1, int v2) {
		if(v1<0 || v1>=n ||v2<0 || v2>=n ||v1==v2)
			System.out.println("���� ���Կ��� -�߸��� ���� ��ȣ�Դϴ�");
		else if(matrix[v1][v2]==1 ||matrix[v2][v1]==1)
			System.out.println("���� ���Կ��� -�̹� �����ϴ� �����Դϴ�");
		else {
			matrix[v1][v2]=1;
			matrix[v2][v1]=1;
		}
			


	}
	//������ ������ ���� ���
	public void printAdjacentVertices(int v1) {
		if(v1<0 || v1>=n)
			System.out.println("���� ���� ��� ���� - �߸��� ���� ��ȣ �Դϴ�");
		else {
			System.out.print(v1+"�� ������ ����= ");
			for(int i=0;i<n;i++) {
				if(matrix[v1][i]==1 ||matrix[i][v1]==1)
					System.out.print(i+" ");
			}

		}
	}


	//���� �켱 Ž��
	public void depthFirstSearch() {
		//�湮���θ� false�� �ʱⰪ ����
		for(int i=0; i<n; i++) {
			visited[i]=false;
		}

		//�湮�� ���� ���� �����̸� �湮
		for(int i=0; i<n; i++) {
			if(visited[i]==false) {
				dfs(i);
			}
		}
	} 
	//���� �켱Ž��
	public void dfs(int v) {
		//���� v �湮
		visited[v]=true;
		
		
		System.out.print(v+" ");
		
		for(int i=0; i<n; i++) {
			if(matrix[v][i]==1 && !visited[i]) {
				//System.out.println(v+"���� "+i+"�̵�");
				dfs(i);
			}
			
		}
		
	}

	//�ʺ�켱Ž��
	public void breadthFirstSearch() {
		//�ʱ� �湮 ���� false�� ����
		for(int i=0;i<n;i++) {
			visited[i]=false;
		}
		//������ �湮 �����ʾ����� Ž��
		for(int i=0;i<n;i++) {
			if(visited[i]==false)
				bfs(i);
		}

	}
	//�ʺ�켱Ž��
	public void bfs(int v) {
		queue=new LinkedList<Integer>();

		//�湮
		visited[v]=true;
		queue.add(v);


		while(!queue.isEmpty()) {
			
			int w=queue.remove();
			
			for(int i=0;i<n;i++) {
				if(matrix[w][i]==1 && !visited[i]) {
					
					visited[i]=true;
					queue.add(i);
					
				}
			

			}
			System.out.print(w+" ");




		}



	}


}