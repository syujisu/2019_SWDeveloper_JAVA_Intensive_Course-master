public class Test045_�迭_�⺻ {
	public static void main( String[] args )
	{
		int[] i = new int[]{1,2,3,4};

		System.out.println( i[0] );
		System.out.println( i[1] );
		System.out.println( i[2] );
		System.out.println( i[3] );
		System.out.println( i.length );

		//	�� �ڵ�� �ܿ��.
		for( int j = 0 ; j < i.length ; j++ ) {
			System.out.println( i[j] );
		}
	}
}
/*	�迭 : ������ ������ �����Ұ� �������� �Ҵ�� ������.
		�ڹ��� �迭�� �ν��Ͻ���. i �� ������������.
		i.length �� �迭�� ��������̰� ���̸� �ǹ��Ѵ�.

	int[] i = {1,2,3,4}; �� ����. �嵥 �̰� new int[] �� ������ ����.
*/