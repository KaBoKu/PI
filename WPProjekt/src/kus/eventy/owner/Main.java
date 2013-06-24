package kus.eventy.owner;

public class Main {

	/**
	 * @param args
	 */
	static Owner own;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		own = own.INSTANCE;
		own.getEmail();
		System.out.println(own.getEmail());
		A a = new A();
		B b = new B();
		a.setB(b);
		a.refB.bFun();
	}

}

class foo {
	public <T> T fu(T a) {
		return a;
	}
}

class Pair {
	private Object e1, e2;

	public Pair(Object e1, Object e2) {
		this.e1 = e1;
		this.e2 = e2;
	}

	public Object getFst() {
		return e1;
	}

	public Object getSnd() {
		return e2;
	}

	public String toString() {
		return "(" + e1 + ", " + e2 + ")";
	}
}



class A{
	  public B refB;
	  void setB(B obj){
	     this.refB = obj;
	 }//Teraz mozesz za pomoca refB korzystac z objektu B tylko musisz go sobie w kodzie setterm podlaczyc
	  
	  

}


	class B{
	    void bFun(){
	    System.out.println("Jakas fun");
	  }
	}