class A {
	private int mayak = 0;
	protected int monarisa = 0;
	public int house2 = 0;
}

class B extends A {
	void print() {
		System.out.println( house2 );
	}
}

public class Test033_protected��_���� {
	public static void main( String[] args ) {
		A look = new A();
		System.out.println( look.house2 );
	}
}
/*	look.monarisa �� ���� ��Ű�������� ���� ����. �ٸ� ��Ű�������� ���� �Ұ�.

	protected �� ������ �������� �����ϸ� ����.
	���� ���� �ٸ� Ŭ�������Դ� �˷������� , �ٸ� ���� �Ҽӵ� Ŭ������ ���� �Ұ��ؾ� �Ѵ�.
	�Ĺ迡�� �����ٶ��� �翬�� ���� �����ؾ� �Ѵ�.

	( ���������� private / public ���� ���� )
*/








