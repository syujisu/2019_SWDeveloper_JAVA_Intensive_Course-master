public class Test060_String��_����Լ���_�̿� {
    public static void main( String[] args ) {
		String l = "HelloWorld";
		System.out.println( l.substring(2,5) );

		//	���ڿ� ���� �κ� ���ڿ��� ��ġ�� ���� : 6
		System.out.println( l.indexOf("or") );

		//	���� ���ڿ��� ã�� ��쿡�� -1 �� �����Ѵ�.
		System.out.println( l.indexOf("xx") );

		//	���۵Ǵ� �ܾ ���Ѵ�. 
		System.out.println( l.startsWith("Hell") );

		//	������ �ܾ ���Ѵ�.
		System.out.println( l.endsWith("ld") );

		//	�ڷ����� �迭�� ������ �ش�.
		char[] ch = l.toCharArray();
		for( int i = 0 ; i < ch.length ; i++ ){
			System.out.println( ch[i] );
		}
	}
}
