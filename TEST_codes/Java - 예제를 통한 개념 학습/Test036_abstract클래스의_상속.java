abstract class A {
	abstract public void print();
}

class B extends A {
	public void print(){
		System.out.println( 100 );
	}
}

public class Test036_abstractŬ������_��� {
	public static void main( String[] args ) {
		A t = new B();
		t.print();
	}
}
/*	abstract �޼ҵ带 �������̵� �ϸ� abstract ������ �������� �ȴ�.
	A t ? new B()? A t = new B() ? t.print()?
	- �̰� �� ���������� ���������� ������ �ʿ䰡 �ִ�.
*/








