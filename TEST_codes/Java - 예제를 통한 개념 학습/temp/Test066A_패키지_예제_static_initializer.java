package temp;

public class Test066A_��Ű��_����_static_initializer 
{
	//	static initializer �� �Ѵ�. Ŭ������ �ε��Ǵ� ������ ȣ��˴ϴ�.
	static {
		System.out.println( "Test066A loaded" );
	}
    
	public int print(){ return 200; }
    public int print2( int i ){ return 300 * i ; }

    public static int print3(){
        return 100;
    }
}
//	C:\A\ �Ʒ��� ������ ����. javac -d C:\A\ Test066A.java