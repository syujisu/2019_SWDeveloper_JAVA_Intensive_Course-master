class A{
	int i = 100;
}

class B extends A{
	int i = 200;
	void print(){}
}

public class Test041_������_������_ĳ����_���� {
	public static void main( String[] args ) {
		A t = new B();
		System.out.println( t.i );

		//	t �����Ͱ� ����Ű�� �ν��Ͻ��� ���δ� B Ŭ���� �ν��Ͻ��� t2 �� ����Ų��.
		B t2 = (B)t;
		t2.print();
		System.out.println( t2.i );
		// ������ ��� ������ �ڼտ��� �Ȱ��� �̸����� ���� ������� ���ƾ��ϴ� ����
		// ������ ���� �� ����... �̰� �����ϱ� ���� ���� �̸����� ������ ����, �ɹ������� �ʿ�� �Ѵٸ�
		// �� ������ ���ͼ��͸� ���� �ϵ����Ѵ�.
	}
}








