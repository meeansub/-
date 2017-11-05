package hw6_3;



/*
 * ���ϸ�: MyDoublyLinkedList.java
 * �ۼ���: ��μ�
 * �ۼ���: 2017�� 10�� 05��
 * ����: ���߿����ڷᱸ���� ��������Ʈ�� ������ MyDoublyLinkedList Ŭ����
 */

public class MyDoublyLinkedList {

	private Node head;	// ����Ʈ�� ù��° ��带 ����ų ����
	private int count;	// ����Ʈ�� ���� ���� ��Ÿ���� ����

	public MyDoublyLinkedList() {
		head = null;
		count = 0;
	}

	// ����Ʈ ���̸� ����
	public int size() {
		return count;
	}

	//1
	@Override
	public String toString() {
		StringBuilder str= new StringBuilder();
		Node temp=head;
		str.append("[");
		while(temp !=null) {
			str.append(temp.data);
			temp=temp.rlink;
			if(temp !=null) {
				str.append(", ");
			}
		}
		str.append("]");
		return str.toString();

	}
	// 2.����Ʈ�� �� �տ� item�� ����
	public void addFirst(int item) {

		// (1) �����Ͱ� item�� ���ο� ��� ����
		Node newNode = new Node(item);

		// (2) ���ο� ��带 ����Ʈ�� �� �տ� ����
		if(head==null) {
			head=newNode;
		}
		else {
			newNode.rlink= head;
			head.llink=newNode;
			head=newNode;
		}
		// (3) ���� �� 1 ����
		count++;
	}
	//3. �Ǿջ���
	public Object removeFirst() {
		Object remove;
		if(head==null) {
			System.out.println("����Ʈ�� ������ϴ�.");
			return null;

		}
		if(head.rlink==null) {
			remove=head.data;
			head=null;
			count--;
			return remove;
		}
		else {
			Node temp=head;
			temp.rlink.llink=temp.llink;
			head=temp.rlink;
			remove=temp.data;
			count--;
			return remove;
		}

	}

	//4. ������
	public void remove(int input) {
		Node pre,temp;
		//����Ʈ�� �������
		if(head==null) {
			System.out.println("����Ʈ�� ������ϴ�.");
		}
		//ù��° ��� ���� �϶�
		if(head.data==input) {
			removeFirst();
		}
		//����Ʈ�� �����ҳ�尡 ������ ����϶�

		//������
		else {
			pre = null;
			temp = head;
			while(temp != null) {
				if(temp.rlink==null) {
					if(temp.data ==input) {
					pre.rlink=null;
					break;
					}
				}
				
				if(temp.data ==input) {
					pre.rlink=temp.rlink;
					temp.rlink.llink=pre;
					break;
				}


				pre=temp;
				temp=temp.rlink;
			}
			count--;

		}
	}


		// ����Ʈ�� ����⿬���� ����� �̷�������� Ȯ��
		public void printLink() {
			if (head == null) {
				System.out.println("���鸮��Ʈ��");
			}
			else {
				// ����Ʈ�� ���������� ���
				Node temp = head;
				System.out.print("����Ʈ ����=" + count + " ������ ��ũ: ");
				while(temp.rlink != null) {
					System.out.print(temp.data + "->");
					temp = temp.rlink;
				}
				System.out.print(temp.data);

				// ����Ʈ�� ���������� ���
				System.out.print(" ������ ��ũ: ");
				while(temp.llink != null) {
					System.out.print(temp.data + "->");
					temp = temp.llink;
				}
				System.out.println(temp.data);
			}
		}

		// ���߿��Ḯ��Ʈ ��� ����
		private class Node {
			int data;
			Node llink; 
			Node rlink;

			Node() {
				this(0, null, null);
			}
			Node(int data) {
				this(data, null, null);
			}
			Node(int data, Node llink, Node rlink) {
				this.data = data;
				this.llink = llink;
				this.rlink = rlink;
			}
		}
	}