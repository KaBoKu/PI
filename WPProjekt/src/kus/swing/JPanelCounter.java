package kus.swing;

import javax.swing.JPanel;

public class JPanelCounter extends JPanel{
	static int c;
	//public global<> l;
	int numberOfInstance = 0;
	JPanelCounter(){
		c++;
		numberOfInstance = c;
	}
	
	public void say() {
		// TODO Auto-generated method stub
		System.out.println(c);
	}
	
	public void sayC(){
		System.out.println(numberOfInstance);
	}
	
	
	
	
	public void main(String ...strings ){
		
	}
}


class box{
	int i;

	public int getI() {
		return i;
	}
	
	int getterI(){
		return i;
	}
	
	void setI(int i){
		this.i = i;
	}
}
