class Temp {

}

class Temp2 extends Temp {}

/*	����Ŭ������ �������� ������ Object �� ���� ��ӹ޴´�.
	java ������ �⺻������ �����Ǵ� Ŭ�������� ������ ...
		java.lang ��Ű���� �Ҽӵ� Ŭ������ import ���� ��밡���ϴ�.
		( ���� �⺻���� Ŭ���� ���� , �� ������ �ᵵ �ȴ� ��� )

	toString() �� Object �� ����Ǿ��� , ��ӵǾ���.
	Temp@490eb6ae : Ŭ������@�ؽ��ڵ尪 ( �ν��Ͻ��� �ٸ��� ���ڰ� �ٸ� )

	- Object �� ��� Ŭ������ ������ �ȴ�? YES 
	- Object �� ������ � �ν��Ͻ��� ����ų �� �ִ�? YES
*/

public class Test048_ObjectŬ������ {
	public static void main( String[] args ) {
		Object t = new Temp();
		System.out.println( t.toString() );

		Object t2 = new Temp();
		System.out.println( t2.toString() );
	}
}