public class Test063_double����_�񱳴�X {
	public static void main( String[] args ) {
		boolean i = true;
		boolean j = false;

		System.out.println( 10 < 5 );
		System.out.println( 10 / 3 );	// �� ( ������ ���� )
		System.out.println( 10 % 3 );
		System.out.println( 10.0 / 3 );

		//	double ���� ��Ȯ�ϴٰ� �Ҽ� ���⿡ == �񱳴� �ؼ��� �ȵȴ�.
		System.out.println( 3.3333 * 3 == 10.0 );

		//	�񱳿����� boolean ���� ���� : == != > < >= <=
		//	���� ��� ������ ���� �ڷ��� ���� ���� : int / int = int
	}
}
//	C �� ������ 0 �� false , 0 �� �ƴ� ��� ������ true 
//	if( 100 )