class A {

}

class B extends A {
	public void print(){ System.out.println( 100 ); }
}

public class Test062_instanceof��_���� {
	public static void main( String[] args ) {
		A t = new A();

		//	[���������� instanceof Ŭ������ ] : ������ ������ Ŭ���������� ĳ������ �������� �˾ƺ��� ���
			//	(B)t �̰��� �����ϸ� true / �ƴϸ� false 

		if( t instanceof B ) {
		//	t �� ����Ű�� �ν��Ͻ��� ���δ� B �ν��Ͻ� ������ �����ؾ߸� ����
			B t2 = (B)t;
			t2.print();
		}
	}
}