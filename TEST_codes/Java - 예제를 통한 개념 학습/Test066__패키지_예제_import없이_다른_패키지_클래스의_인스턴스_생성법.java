public class Test066__��Ű��_����_import����_�ٸ�_��Ű��_Ŭ������_�ν��Ͻ�_������ {
    public static void main( String[] args ) throws Exception
	{
		//	Ŭ������ ã�Ƴ��� �ش� Ŭ������ ������ �޸𸮿� �ε���Ų��.
		//		�ε���Ű�� Ŭ������ static initializer �� �����Ѵ�.
        Class<?> cls = Class.forName("temp.Test066A");

		/*	Class : �ε��� Ŭ������ ������ ������ �Ѵ�.
			cls.newInstance() : cls �� �����ϴ� temp.Test066A �� �ν��Ͻ��� �����Ѵ�.

			obj.getClass().getName() : obj �� ����Ű�� �ν��Ͻ��� ������Ų Ŭ���� ��

			: import ���̵� �ٸ� ��Ű���� Ŭ������ �ν��Ͻ��� ������ �� �ִ�.
		*/

		Object obj = cls.newInstance();
		System.out.println( obj.getClass().getName() );
    }
}