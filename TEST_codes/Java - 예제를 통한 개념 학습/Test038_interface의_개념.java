interface ICalc {
	public void print();
}

interface IUnknown{}
class Apple {}

class Calc extends Apple implements ICalc , IUnknown{
	public void print(){ System.out.println("A"); }
}

public class Test038_interface��_���� {
	public static void main( String[] args ) {
		ICalc ic = new Calc();
		ic.print();
	}
}
//	�������̽��� ����� method �� ���� abstract �ؾ� �Ѵ�.
//	�������̽��� ����ؼ� Ŭ������ �����Ҷ��� implements �� �̿��ؾ� �Ѵ�.
//	��ӹ��� Ŭ������ �������̽��� ����� �޼ҵ带 ���� �������̵� �ؾ� �Ѵ�.
//	�������̽��� ������ abstract Ŭ�����̴�. - �������� , ��Ӵ��� ���� , �ν��Ͻ� ���� �Ұ�.
//	2�� �̻��� �������̽� ���? OK , ���ÿ� Ŭ���� 1�� ���? OK 



