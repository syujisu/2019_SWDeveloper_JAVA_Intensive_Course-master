class Temp {
	private Object data = null;
	public Object getData(){ return data; }
	public void setData( Object i ){ data = i; }
}

class Temp2 {
	private String data = null;
	public String getData(){ return data; }
	public void setData( String i ){ data = i; }
}

//	�Ʒ� �ڵ忡�� ĳ������ �ʿ��� ���� �ʿ����� ���� ��츦 �����Ѵ�.
//	��� �ν��Ͻ��� ���� ������ ����? ĳ���� ���� ���� �� �ִ� ����?

public class Test051_Object��������_ĳ���� {
	public static void main( String[] args ) {
		Temp2 t2 = new Temp2();
		t2.setData( "HelloWorld" );
		String l2 = t2.getData();

		Temp t = new Temp();
		t.setData( "HelloWorld" );
		String l = (String)t.getData();
	}
}
