class A {
	int i = 100;
	void print(){ System.out.println("A print"); }
}

class B extends A {
	int i = 200;
	void print2(){ System.out.println("B print2"); }
	void print(){ System.out.println("B print"); }
}

public class Test032_�����������̵�X {
	public static void main( String[] args ) {
		A t = new B();
		t.print();
		System.out.println( t.i );
		//	t.print2();
	}
}
/* 	����Ÿ���� ������ �ڼ��� �ν��Ͻ��� ����ų �� �ִ�.
	���󿡼� ����� ����Լ� ��������� ȣ���� �����ϴ�.
		- B �� �ν��Ͻ� �ȿ� print2 �� �����Ѵ�. ������ ȣ���� �� ����.
	���� �������̵� �� �Լ��� ȣ���Ѵٸ� �̶��� �������̵� �� ���� ȣ��ȴ�.

	�� 100 �� �������� �� ������ ��������. ( ����������� �������̵� ������ ���� )
*/








