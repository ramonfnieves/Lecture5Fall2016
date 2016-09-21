
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;

public class CarStage extends JComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9032539863554018689L;
	int counter = 0;
	int n;
	MutableCar theCar1 = new MutableCar(0, 0, Color.BLUE, 5, 1, 0);
	MutableCar theCar2 = new MutableCar(0, 50, Color.BLUE, 5, 1, 1);
	MutableCar theCar3 = new MutableCar(0, 100, Color.BLUE, 5, 1, 3);

	boolean someCarWon = false;
	
	Random r = new Random();
	
	public boolean someCarWon(){
		return someCarWon;
	}
	
	public int winNum(){
		return n;
	}
	
	public void paintComponent(Graphics g){
		
		theCar1.draw(g);
		theCar2.draw(g);
		theCar3.draw(g);
		
		int deltaXCar1 = r.nextInt(theCar1.getHorizontalSpeed());
		theCar1.moveInX(deltaXCar1);
		if((theCar1.getXPos()+60)>=this.getWidth()){
			n = theCar1.getNumber();
			winNum();
			
		}
		
		int deltaXCar2 = r.nextInt(theCar2.getHorizontalSpeed());
		theCar2.moveInX(deltaXCar2);
		if((theCar2.getXPos()+60)>=this.getWidth()){
			someCarWon=true;
			n = theCar2.getNumber();
			winNum();
			
		} 
		
		int deltaXCar3 = r.nextInt(theCar3.getHorizontalSpeed());
		theCar3.moveInX(deltaXCar3);
		if((theCar3.getXPos()+60)>=this.getWidth()){
			someCarWon=true;
			n = theCar3.getNumber();
			winNum();
		} 
		
		System.out.println(counter++);
	}
}
