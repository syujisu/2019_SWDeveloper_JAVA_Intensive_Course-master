class Temp <T extends Object> {
	private T data = null;
	public T getData(){ return data; }
	public void setData( T i ){ data = i; }
}
/*	�ν��Ͻ��� �ڷ����� �������� ������ �� �ִ� : ���ʸ��� ����
	1.5 �������� �����Ǿ���. 

	< > �ȿ� ���� ������ Ÿ���� ������ ���� Ÿ���̾�� �Ѵ�. ( �ڷ��� �ȵ� )
	: C++ �� ���÷���Ʈ ... �� �̰Ŷ� ����. C++ �� �ڷ����� < > �ȿ� ���
*/
public class Test052_���׸���_�⺻_���� {
	public static void main( String[] args ) {
		Temp<Object> t = new Temp<Object>();
		t.setData("HelloWorld");
		String l = (String)t.getData();

		Temp<String> t2 = new Temp<String>();
		t2.setData("HelloWorld");
		String l2 = t2.getData();
	}
}
