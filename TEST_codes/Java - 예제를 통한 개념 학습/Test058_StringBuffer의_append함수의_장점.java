public class Test058_StringBuffer��_append�Լ���_���� {
    public static void main( String[] args ) {
		StringBuffer sb = new StringBuffer();
		sb.append("apple");
		sb.append("banana");

		String l = sb.toString();
		System.out.println( l );

		System.out.println( "apple" + "banana" );
	}
}
//	"apple" + "banana" �� �����Ϸ��� new StringBuffer().append("apple")
//		.append("banana").toString();
/*
		�Ʒ� �ڵ�� �� �ٸ��� new StringBuffer() �� �����ؾ� �Ѵ�.
		�嵥 ���� main �� ������ �ϳ��� StringBuffer �� ����Ѵ�.
		: ���� �Լ��� �ڵ尡 �޸� ȿ���� �ξ� ����.

		String l = ""
		l = l + "*";
		l = l + "*";
		l = l + "*";
		....

*/