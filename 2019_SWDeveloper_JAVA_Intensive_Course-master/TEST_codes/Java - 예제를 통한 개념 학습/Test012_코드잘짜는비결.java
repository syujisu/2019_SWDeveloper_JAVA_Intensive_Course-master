public class Test012_�ڵ���¥�º�� {
	public static void main( String args[] ) {
		double total = 0;
		for( int j = 100 ; j > 0 ; j-- ) {
			double money = 100;
			for( int i = 0 ; i < j ; i++ ) {
				money = money + money * 0.066;
			}
			total = total + money;
		}
		System.out.println( total );
	}
}
/*
	�ڵ� �� ¥�� ��� : �� �ɰ��� §��. �ڽ��� ������ �� �ľ��ؾ� �Ѵ�.
	�ݺ����� ������ �Ƿ��� �ϴ� �þ���� - �����Ѵ�. 
*/









