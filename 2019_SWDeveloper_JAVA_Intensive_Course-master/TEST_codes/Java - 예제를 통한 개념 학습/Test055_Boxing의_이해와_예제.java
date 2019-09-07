
public class Test055_Boxing��_���ؿ�_���� {
	public static void main( String[] args ) {
		Integer i = 100;
		Object t = 200;
		System.out.println( i.getClass().getName() );
		System.out.println( t.getClass().getName() );

		int j = i;
		System.out.println( j );
	}
}
/*
	Integer i = 100; �� �����Ϸ��� Integer i = new Integer(100); �� �ڵ��ٲ�.
	���� ����Ŭ������ �����ϴ� �ڵ�� �ڵ����� �ν��Ͻ� �����ؼ� ���� �����ش�.
	-- �̰��� Auto Boxing �̶�� �Ѵ�.

	Object t = 200; Object �� ������ ���ؼ��� AutoBoxing �� �����Ѵ�.

	int j = i; �� int j = i.intValue() �� �ڵ� ��ȯ�Ͽ� �ش�. ( Unboxing �̶� �� )
	int k = t; �� �ȵȴ�. Object Ÿ������ ����ڽ̵� �ν��Ͻ��� ��ڽ� �ȵȴ�.
		( t.intValue() �� ȣ���� �� ���� 
		
	Object t = true; �� ����ڽ����� �ν��Ͻ��� �����ȴ�.
*/
