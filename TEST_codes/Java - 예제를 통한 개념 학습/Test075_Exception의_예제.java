//	���� ���̶�� ������ Ŭ������ �����.
class FuelException extends Exception {
	public void solve(){
		System.out.println( "�������� �ҷ���" );
	}
}

/*	Exception �� ����ϴ� : �������� �ȵȴ� ... 
	- �Լ����� ������ �߻��� �� �ִٸ� �� ����� ����ο� ����ؾ� ������ �ȴ�.

*/
public class Test075_Exception��_���� {

	public void carDrive( int fuel ) throws FuelException {
		if( fuel == 0 ){
			throw new FuelException();
		}
		System.out.println( "GOGO" );
	}

    public static void main( String[] args ) {

		Test075 t = new Test075();

		try {
			t.carDrive( 0 );
		}
		catch( FuelException e ){
			e.solve();
			System.out.println( "�������� �ҷ���" );
		}
	}
}
/*
	throws FuelException ���� ����� �Լ��� ȣ���Ҷ��� 
	�ݵ�� ������ �߻��� �� �ִ� ������ try { ... } �� �����ش�.

	try ���� �ݵ�� 1�� �̻��� catch �� �־�� �Ѵ�.
	������ �߻��Ǹ� ���� �ν��Ͻ��� throw �Ѵ�

	catch( FuelException e ) �� �ִ� e ������ �߻��� ���� �ν��Ͻ��� ����ų �� ������
	catch �� ���� { ... } ������ �����Ѵ�.
	... ���� ������ ������ �� �ִ� �ڵ尡 ���� ���� �ٶ����ϴ�.

	catch( Exception e ) �� �ᵵ �Ǵ°�? OK
*/