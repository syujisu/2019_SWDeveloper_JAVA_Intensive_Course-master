class Temp {
	public void print(){ System.out.println(1); }
	public void print( int i ){}
	public void print( double i ){}
	public void print( int i, int j ){}
}
/*	�ϳ��� Ŭ���� �ȿ� �̸��� ������ �Ű����� ���°� Ʋ�� �Լ��� ������ ��������
	- method overloading �̶�� �Ѵ�.

	�� �Ű������� ���� ������ ���� ������ �ڵ� ����ȯ �Ǵ� ���� ã�Ƽ� ȣ���Ѵ�.
*/
public class Test040_overloading_���� {
	public static void main( String[] args ) {
		Temp t = new Temp();
		t.print();

		//	float j = 3.14;	�̰� �� �ȵǴ��� ����.
		//	float j = (float)3.14;	-- �����ϱ� �ϴ� ...
		float j = 3.14F;
		t.print( j );
	}
}








