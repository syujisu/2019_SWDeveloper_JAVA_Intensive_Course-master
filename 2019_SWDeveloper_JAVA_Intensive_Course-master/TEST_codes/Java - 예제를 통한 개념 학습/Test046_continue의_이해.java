public class Test046_continue��_���� {
	public static void main( String[] args )
	{
		int[] i = new int[]{1,2,3,4};

		for( int j = 0 ; j < i.length ; j++ ) {
			if( j == 2 )
				continue;
			System.out.println( i[j] );
		}
	}
}
/*	break : �ݺ����� Ż���Ѵ�.
	continue : �ݺ����� �Ʒ� �ڵ�� ������ �ǳʶٰ� �ݺ��� ����Ѵ�.
*/