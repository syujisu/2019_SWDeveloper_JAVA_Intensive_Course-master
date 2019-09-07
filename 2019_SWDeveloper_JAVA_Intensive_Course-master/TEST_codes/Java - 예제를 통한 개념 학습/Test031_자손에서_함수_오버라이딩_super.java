class A {
	void print(){ System.out.println("A print"); }
}

class B extends A {
	void print(){
		System.out.println("B print");

		// �������� �ڼ��ʿ��� �������� �Լ��� ȣ���ϰ� ������ super �� �̿��Ѵ�.
		super.print();
	}
}

public class Test031_�ڼտ���_�Լ�_�������̵�_super {
	public static void main( String[] args ) {
		B t = new B();
		t.print();

		A t2 = new A();
		t2.print();
	}
}
/* 	method overridding : ���󿡼� ������ ����Լ��� �ڼտ��� �ٽ� ������ �� �ִ�.
	: �ڼ��� �ν��Ͻ��� print �� ȣ��Ǹ� ( ����? �ڼ�? ) �ڼ�!

	���? ������? �ڼտ��� �������� �Լ� �� ����? �׷��� ���󿡼� ����� �Լ��� ����?
	N0! super. ������ ������ ���� ȣ�Ⱑ��!
*/



