import java.util.*;

/*	Math.random() : 0 ���� 1 ������ �Ҽ����� �����ϰ� ����Ѵ�.
	���ؼ� ĳ���� �ϴ� ���·� �ؼ� ������ �߻���ų �� �ִ�.
*/
public class Test071_random�Լ�_���� {

    public static void main( String[] args ) {
        
        for( int i = 0 ; i < 20 ; i++ ) {
            double d = Math.random();
            System.out.println( ( int )( d * 100.0 ) );
        }
    }
}
