import java.lang.reflect.Method;

public class Test066_3_getMethods��_�̿���_Ŭ������_Ư��_�޼�����_������_���� {
    public static void main( String[] args ) throws Exception
	{
        Class<?> cls = Class.forName("temp.Test066A");
		Object obj = cls.newInstance();
		/*
			Method �� C �� �Լ��������� ������ �Ѵ�.
			cls.getMethods() : ��� ����Լ��� �����͸� �ѱ��.
			cls.getMethod(...) : �� �ϳ��� ����Լ��� �����͸� �ѱ��.
				... ���� �Լ��̸� , �Ű������� ���¸� ����Ѵ�.
		*/
		//	Method mtd = cls.getMethod( "print" );
		Method mtd = cls.getMethod( "print2" , int.class );
		System.out.println( mtd );

		Object r = mtd.invoke( obj, 20 );
		System.out.println( ((Integer)r).intValue() );
	}
}