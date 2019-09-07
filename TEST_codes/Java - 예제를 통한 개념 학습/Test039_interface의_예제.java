interface IGreet {
	public String greet();
}

class MerciGreet implements IGreet {
	public String greet(){ return "Merci"; }
}

class HelloGreet implements IGreet {
	public String greet(){ return "Hello"; }
}

abstract class GreetDeco implements IGreet {
	protected IGreet ig = null;

	GreetDeco( IGreet i ){
		ig = i;
	}
}

//	�ڼ��� �����ڿ��� ������ ������ �� �Ű����� �ִ� �����ڸ� ȣ�� ���ϸ� super �� ����.
class SharpDeco extends GreetDeco {
	SharpDeco( IGreet i ){
		super( i );
	}
	public String greet(){ return "#" + ig.greet()+ "#"; }
}

class StarDeco extends GreetDeco {
	StarDeco( IGreet i ){
		super( i );
	}
	public String greet(){ return "*" + ig.greet()+ "*"; }
}

public class Test039_interface��_���� {
	public static void main( String[] args ) {
		IGreet ig = new StarDeco( new SharpDeco( new MerciGreet() ) );
		System.out.println( ig.greet() );
	}
}











