interface ICalc {
	public int execute( int i );
}

class AddCalc implements ICalc , PrintStars {
	private int data = 0;
	AddCalc( int j ) {
		data = j;
	}
	public int execute( int i ){
		return ( i + data );
	}
}

/*	���⸦ �� ���� ** �� �ٿ��� ����Ʈ �϶�� ��Ű�� �ʹ�.
	�Ͻ������� ��Ű�� ���� ��찡 �ִ���.

	���� ���α׷��ӵ��� �� �������̽��� �̷� �� �̿��ߴ�.

	���� ���ϴ� ���忡�� ���� �ʿ��� � �ǰ��� �����ϴ� ��ΰ� �ʿ��Ҷ� 
	�Ʒ��� �� �������̽��� �̿��ϸ� ����� ������.
	�̰��� ü��ȭ �� ���� 1.5 ���Ŀ� ���Ե� Annotation ������ �ȴ�.
*/

interface PrintStars{}

class MinusCalc implements ICalc {
	private int data = 0;
	MinusCalc( int j ) {
		data = j;
	}
	public int execute( int i ){
		return ( i - data );
	}
}

public class Test056_Ŀ�ǵ�����_���������̽��ǻ�� {
    public static void main( String[] args ) {
		ICalc i = new AddCalc( 3 );

		int r = 5;
		r = i.execute( r );
		System.out.println( r );

		ICalc[] ls = new ICalc[5];
		ls[0] = new AddCalc( 2 );
		ls[1] = new MinusCalc( 6 );
		ls[2] = new AddCalc( 3 );
		ls[3] = new AddCalc( 7 );
		ls[4] = new MinusCalc( 5 );

		int y = 10;
		for( int l = 0 ; l < ls.length ; l++ ) {
			y = ls[l].execute( y );

			if( ls[l] instanceof PrintStars ) {
				System.out.print( "**" );
			}
			System.out.println( y );
		}
    }
}
/*	�Ϲ������� �ڷᰪ�� ������ , ������ �Լ��� �����.

	������ �ϳ��� �ν��Ͻ��� �����ϰ� �ϴ� ��찡 �ִ�.
	- �̷� �������� Command Pattern �̶�� �Ѵ�.
*/