class Temp {
	private Object data = null;
	public Object getData(){ return data; }
	public void setData( Object i ){ data = i; }
}

/*	String : new ���� "" �� �ν��Ͻ��� ������ ������ Ŭ����
	������ ������ �񱳴� ������ �ν��Ͻ��� ����ų�� true ( ������ null �� true )

	l == t �� true �� ���´�? l �� t �� ������ �ν��Ͻ��� ����Ų��.
		( �Ʒ��ڵ��� String �ν��Ͻ��� 1�� �̴� )
	StringPool �̶�� ��Ư�� java �� ������ ���´�.

	"" �� ������ VM�� StringPool �� ������ ������ ����� , ������ ��Ȱ��
	- �� ���α׷��ֿ� �ſ� �����ϴ�. HTML ������ String ���� �����
		��Ȱ���ϴ� ���� �޸� ������ �����ϴ�.
*/
public class Test050_String��_StringPool��_���� {
	public static void main( String[] args ) {
		String l = "HelloWorld";
		String t = "HelloWorld";
		System.out.println( l == t );

		Object o = "HelloWorld";
		String r = (String)o;
	}
}
