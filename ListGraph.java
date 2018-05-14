package hw10_1;

import java.util.LinkedList;

/* 
 * 파일명: ListGraph.java
 * 작성일: 2017.11.28
 * 작성자: 김민섭
 * 설명: 무방향 그래프를 생성하고 연산을 수행하는 프로그램 ,인접리스트
 */
public class ListGraph {
	private Node[] list; //정점을 담을 노드형 배열 선언
	private int n; //vertex 계수
	
	
	
	public ListGraph(int n) {
		list=new Node[n];
		this.n=n;
		
	}
	// 간선을 이루는 두개의 정점 v1, v2를 매개변수로 받아 그래프에 간선을 추가
	public void addEdge(int v1, int v2) {
		
		//잘못된 정점 번호인 경우 오류 메시지 출력
		if(v1<0 || v1>=n ||v2<0 || v2>=n || v1==v2)
			System.out.println("간선 삽입오류 -잘못된 정점 번호입니다");
		//이미 존재하는 간선인 경우 오류 메시지 출력    
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
					System.out.println("이미 존재하는 간선입니다");
					break;
				}
				else
					temp=temp.link;
			}
			//이미 존재하는 간선이 없을때
			if(temp==null) {
				//무방향 그래프이기 때문에 정점 두개에 모두 값 연결
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


	//정점을 매개변수로 받아 그 정점에 인접한 정점들을 모두 출력
	public void printAdjacentVertices(int v1) {
		//잘못된 정점 번호인 경우 오류 메시지 출력
		if(v1<0 || v1>=n)
			System.out.println("인접 정점 출력 오류 - 잘못된 정점 번호 입니다");
		else {
			System.out.print("정점"+v1+"에 인접한 정점:");
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
