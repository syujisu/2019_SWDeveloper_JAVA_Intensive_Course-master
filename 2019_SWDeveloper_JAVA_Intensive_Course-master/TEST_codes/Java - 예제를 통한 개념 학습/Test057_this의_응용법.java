class Temp {
	int data = 0;

	//	�Ʒ��ڵ��� t �� this �� ����Ű�� ����� ����.
	//		���� t.add( 10 ) �� 10�� ���� �Ŀ� t �� �ٲ� �� �� �־�����.
	//		StringBuffer �� append ���� �� �� �ִ�.

	Temp add( int i ) {
		data = data + i;
		return this;
	}
}
public class Test057_this��_����� {
    public static void main( String[] args ) {
		Temp t = new Temp();
		t.add( 10 ).add( 10 ).add( 10 ).add( 10 ).add( 10 );
		System.out.println( t.data );
	}
}