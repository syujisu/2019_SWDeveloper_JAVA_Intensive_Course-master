import java.lang.reflect.Method;

public class Test066_2_getMethods��_�̿���_Ŭ������_�޼������_������_���� {
    public static void main( String[] args ) throws Exception
	{
        Class<?> cls = Class.forName("temp.Test066A");
		Object obj = cls.newInstance();

		/*	getMethods() : Ŭ���� �ȿ��� ����� �Լ��� ���� �����͵��� �����Ѵ�.

		*/
		Method[] mtds = cls.getMethods();
		for( int i = 0 ; i < mtds.length ; i++ ) {
			System.out.println( mtds[i] );
		}
	}
}