import java.util.*;

/*	Map �� �������� ���� key=value ������ ��ġ ������ ���� ���·� �����մϴ�.
	put �Լ��� ���� , get �Լ��� key �� �ش��ϴ� value �� �̾Ƴ���.

	List , Set , Map ���·� ������ �����ϴ� ���¸� ���� Collection �̶�� �Ѵ�.
	- ������ �ߺ� , ���� ���θ� �����ϼ���.
*/
public class Test070_Map��_���� {
    public static void main( String[] args ) {
		Map<String,String> map = new Hashtable<String,String>();
		map.put("apple","���");
		map.put("banana","�ٳ���");
		map.put("orange","������");
		map.put("kiwi","Ű��");
		map.put("apple","���2");

		String value = map.get("kiwi");
		System.out.println( value );

		//	Iterator �� ǥ�� �˻�����̴�. keySet() �� key ������ Set �� �����Ѵ�.
		Set<String> keys = map.keySet();
		Iterator<String> it = keys.iterator();
		while( it.hasNext() ) {
			String l = it.next();
			String v = map.get( l );
			System.out.println( l + "," + v );
		}

		System.out.println( map.toString() );
	}
}
