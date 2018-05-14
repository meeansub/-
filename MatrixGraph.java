package hw10_2;

/* 
 * 파일명: MatrixGraph.java
 * 작성일: 2017.12.05
 * 작성자: 김민섭
 * 설명: 무방향 그래프를 생성하고 연산을 수행하는 프로그램 ,DFS,BFS
 */
import java.util.LinkedList;
import java.util.Queue;


public class MatrixGraph {
	//정점과 정점을 연결해서 간선을 만들어 저장
	private int[][] matrix;
	//총 정점갯수 n
	private int n; 
	//방문여부 저장
	private boolean[] visited;
	//너비우선탐색을 위한 큐
	private Queue<Integer> queue;

	
	
	public MatrixGraph(int n) {
		matrix= new int[n][n];
		this.n=n;
		this.visited=new boolean[n];

	}
	//정점 삽입해서 간선만들기
	public void addEdge(int v1, int v2) {
		if(v1<0 || v1>=n ||v2<0 || v2>=n ||v1==v2)
			System.out.println("간선 삽입오류 -잘못된 정점 번호입니다");
		else if(matrix[v1][v2]==1 ||matrix[v2][v1]==1)
			System.out.println("간선 삽입오류 -이미 존재하는 간선입니다");
		else {
			matrix[v1][v2]=1;
			matrix[v2][v1]=1;
		}
			


	}
	//정점에 인접한 정점 출력
	public void printAdjacentVertices(int v1) {
		if(v1<0 || v1>=n)
			System.out.println("인접 정점 출력 오류 - 잘못된 정점 번호 입니다");
		else {
			System.out.print(v1+"에 인접한 정점= ");
			for(int i=0;i<n;i++) {
				if(matrix[v1][i]==1 ||matrix[i][v1]==1)
					System.out.print(i+" ");
			}

		}
	}


	//깊이 우선 탐색
	public void depthFirstSearch() {
		//방문여부를 false로 초기값 지정
		for(int i=0; i<n; i++) {
			visited[i]=false;
		}

		//방문을 하지 않은 정점이면 방문
		for(int i=0; i<n; i++) {
			if(visited[i]==false) {
				dfs(i);
			}
		}
	} 
	//깊이 우선탐색
	public void dfs(int v) {
		//정점 v 방문
		visited[v]=true;
		
		
		System.out.print(v+" ");
		
		for(int i=0; i<n; i++) {
			if(matrix[v][i]==1 && !visited[i]) {
				//System.out.println(v+"에서 "+i+"이동");
				dfs(i);
			}
			
		}
		
	}

	//너비우선탐색
	public void breadthFirstSearch() {
		//초기 방문 여부 false로 지정
		for(int i=0;i<n;i++) {
			visited[i]=false;
		}
		//정점을 방문 하지않았으면 탐색
		for(int i=0;i<n;i++) {
			if(visited[i]==false)
				bfs(i);
		}

	}
	//너비우선탐색
	public void bfs(int v) {
		queue=new LinkedList<Integer>();

		//방문
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