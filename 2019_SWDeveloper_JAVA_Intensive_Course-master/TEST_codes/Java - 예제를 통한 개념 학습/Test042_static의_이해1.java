class Temp {
	static int i = 100;
}

public class Test042_static��_����1 {
	public static void main( String[] args ) {
		int j = Temp.i;		
	}
}
/*	�ڹ� ����ȯ���� Ŭ������ �ʿ������� .class ������ �޸𸮿� �ø���.
		�� �Ŀ� �ν��Ͻ� ������ �����ϴ�.

	static ����� Ŭ���� �ε��ÿ� �޸𸮸� �Ҵ�޴´�. ������ �����ϴ�.
		( �ν��Ͻ��� ��̰� ���� )
	non-static ����� �ν��Ͻ��� �����ɶ�. �ν��Ͻ����� ���� ���� ����.
*/