class A {
	A(){ System.out.println("A constructor"); }
}

class B extends A {
	B(){ System.out.println("B constructor"); }
}

public class Test030_���_������ȣ��_���� {
	public static void main( String[] args ) {
		B t = new B();
		//	t.B();
	}
}
/*	- ��Ӱ��谡 �����Ҷ� ( ����Ŭ���� , �ڼ�Ŭ���� ) �ڼ��� �ν��Ͻ��� �����ϸ�
		������ �����ڰ� ���� ȣ��ǰ� , �ڼ��� �����ڰ� ȣ��ȴ�.

	- �����ڴ� ��ӵ��� �ʴ´�. �ٸ� ȣ��� ���̴�. ����Լ��� �ƴϴ�.
		( ������ ������ ȣ���� �� ����. )

*/



