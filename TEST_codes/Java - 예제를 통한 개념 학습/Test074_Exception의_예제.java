
class TempException extends RuntimeException{}
/*
	java ���� ���� ������ class �� �����ȴ�. 
		extends Exception , extends RuntimeException

	�ڵ� ����� ������ �߻��Ǹ� �ش� ���� Ŭ������ �ν��Ͻ��� throw �Ѵ�.
	�߻��� ���ܸ� �����ϰ� ó������ ���ϸ� ���α׷��� �����Ѵ�.

	"���ܴ� �Լ� ����ÿ� �߻��ǰ� , �Լ��� �� ����� ����Ѵ�."
*/
public class Test074_Exception��_���� {
    public static void main( String[] args ) {
		int i = 0;
		if( i == 0 ) {
			throw new TempException();
		}
		System.out.println( 0 );
	}
}
