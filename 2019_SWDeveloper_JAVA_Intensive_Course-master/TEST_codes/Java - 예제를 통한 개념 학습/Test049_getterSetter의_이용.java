class Temp {
	private int data = 100;
	public int getData(){ return data; }
	public void setData( int i ){ data = i; }
}

public class Test049_getterSetter��_�̿� {
	public static void main( String[] args ) {
		Temp t =  new Temp();
		t.setData( 200 );
		System.out.println( t.getData() );
	}
}
//	��������� private ���� . ���� ���� ���� getter �Լ��� ������ ����.
//	�ν��Ͻ� ���� �������� �б��������� �Ϸ���? getter �� ����� �ش�.
//	�ν��Ͻ� ���� �������� �ٲٰ� �������� setter �� ���°��� ����!