/*	Wrapper Class : �ڷ��� ���� �����ִ� ������ Ŭ���� .
	int -> Integer ��� Ŭ������ ����
	double -> Double �̶�� Ŭ���� ����
*/

public class Test054_WrapperClass��_���� {
	public static void main( String[] args ) {
		Object ob = new Integer(100);
		Object ob2 = new Double(3.14);

		int i = ((Integer)ob).intValue();
		System.out.println( i );

		double j = ((Double)ob2).doubleValue();
		System.out.println( j );
	}
}
