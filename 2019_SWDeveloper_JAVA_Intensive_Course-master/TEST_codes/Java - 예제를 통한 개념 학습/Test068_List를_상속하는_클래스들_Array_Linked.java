import java.util.*;

/*	ArrayList �ӵ��� ������. ���������� �迭�� �̿��Ѵ�. 
	- �迭�� �Ἥ �ܼ��� ���� �ӵ��� ������ , �߰� �����ÿ��� ��ȿ�����̴�. 

	LinkedList �� Node �� �̿��ϱ⿡ �ܼ��ϰ� �״� �ӵ��� ������.
		�߰��� �߰� ������ ����� ��쿡�� �����ϴ�.

	�� �� List �� ����Ѵ�. List �� ��ӹ��� Ŭ������ Ư¡�� �����Ѵ�.
	- �ߺ��Ǵ� �� ��� �Ѵ�. �˻��ÿ� �� ������� ���´� ( ������� �����Ѵ� )
*/
public class Test068_List��_����ϴ�_Ŭ������_Array_Linked {
    public static void main( String[] args ) throws Exception {
		List<String> l = new ArrayList<String>();
		l.add("apple");
		l.add("banana");
		l.add("orange");
		l.add("kiwi");
		l.add("apple");

		//	���� for ����
		for( String t : l ) {
			System.out.println( t );
		}
	}
}
