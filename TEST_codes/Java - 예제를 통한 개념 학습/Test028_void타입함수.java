class Apple {
	int data = 0;
	
	//	return ������ ���� �Լ��� �����ƾ�̶� �Ѵ�. ����Ÿ���� void �� �����Ѵ�.
	//	����Լ� �ȿ��� �ڽ��� �Ҽӵ� �ν��Ͻ��� ���� �����͸� ��밡�� : this 

	//	���� ���� : ������ temp04.c ������ �м��ؼ� java �� ���ؼ� ����Ʈ �ۼ�.
	//	�Լ� �ϳ��� ���̰� ũ�ٰ� �ؼ� �ν��Ͻ��� ���� �����ϸ� �޸𸮿� �δ㰡��? NO

	void print( ){
		System.out.println( this.data );
	}
}

public class Test028_voidŸ���Լ�{
	public static void main( String[] args ){
		Apple t = new Apple( );
		t.data = 10;
		t.print();

		Apple l = new Apple( );
		l.data = 20;
		l.print(); 
	}
}




