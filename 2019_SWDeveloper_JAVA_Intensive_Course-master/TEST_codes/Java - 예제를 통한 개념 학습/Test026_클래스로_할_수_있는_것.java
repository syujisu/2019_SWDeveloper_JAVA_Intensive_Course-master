class Apple2 {
	int data = 0;
	int add( int i, int j ) {
		return 100;
	}
}
//	������� ( property ) , ����Լ� ( method )
//	Ŭ������ �� ����? ������ ���� ����, �ν��Ͻ� ����  
//	�ν��Ͻ��� Ŭ���� ���� , ������ ������ �ν��Ͻ� ����.

public class Test026_Ŭ������_��_��_�ִ�_��{
	public static void main( String[] args ){
		Apple2 t = new Apple2();
		int i = t.add( 10, 20 );
	}
}