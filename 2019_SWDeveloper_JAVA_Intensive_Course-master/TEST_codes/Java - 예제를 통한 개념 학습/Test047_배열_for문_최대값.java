public class Test047_�迭_for��_�ִ밪 {
	public static void main( String[] args )
	{
		int[] i = new int[]{4,9,6,5};

		int max = i[0];
		for( int j = 1 ; j < i.length ; j++ ) {
			if( max < i[j] ){
				max = i[j];
			}
		}
		System.out.println( max );
	}
}

/*	������ �ڵ�.

		int max = i[0];
		if( max < i[1] ){
			max = i[1];
		}
		if( max < i[2] ){
			max = i[2];
		}
		if( max < i[3] ){
			max = i[3];
		}

*/