class Node <T extends Object> {
	T data = null;
	Node<T> next = null;

	Node( T i, Node<T> n ){
		data = i;
		next = n;
	}
}

/*	������ ���� : LinkedList Ŭ������ ����� ���ʸ��� �Ἥ ���� ��.

class LinkedList <X extends Object>{
	add
	print
}
*/

public class Test053_���׸�_�ݺ���X_��忬�� {
	public static void main( String[] args ) {
		Node<Integer> head = new Node<String>( null, null );
		Node<String> tail = head;

		tail.next = new Node<String>("apple",null);
		tail = tail.next;

		tail.next = new Node<String>("banana",null);
		tail = tail.next;

		tail.next = new Node<String>("orange",null);
		tail = tail.next;

		tail.next = new Node<String>("kiwi",null);
		tail = tail.next;

		for( Node<String> n = head.next ; n != null ; n = n.next ){
			System.out.println( n.data );
		}
	}
}
