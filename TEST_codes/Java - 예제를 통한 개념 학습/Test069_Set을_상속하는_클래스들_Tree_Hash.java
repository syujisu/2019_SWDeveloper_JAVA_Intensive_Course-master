import java.util.*;
/*
	Set �������̽��� ��ӹ��� �� : TreeSet , HashSet
	����Ư¡ : ���������� ����. �ߺ������� ������� �ʴ´�. �˻��ӵ��� List ���� ����

	TreeSet : Ʈ���� �̿��Ͽ� ����, HashSet �� �ؽ� �˰������� �����Ҹ� ����
*/
public class Test069_Set��_����ϴ�_Ŭ������_Tree_Hash {
    public static void main( String[] args ) {
		Set<String> ls = new HashSet<String>();
		ls.add("apple");
		ls.add("banana");
		ls.add("orange");
		ls.add("kiwi");
		ls.add("apple");

		//	java �� ǥ�� �˻������ Iterator 
		Iterator<String> it = ls.iterator();
		while( it.hasNext() ) {
			String l = it.next();
			if( l.indexOf("an") != -1 ) {
				it.remove();
			}
		}

		System.out.println( ls );
	}
}
