package calculating_integral;

import org.mariuszgromada.math.mxparser.Function;

import processing.core.PApplet;

public class Integral2TestProgram extends PApplet{
	public static void main(String[] args) {
		PApplet.main(calculating_integral.Integral2TestProgram.class);
	}
	
	Integral in;
	
	public void settings() {
		size(500, 800);
	}
	
	public void setup() {
		Function f = new Function("P(t) = 3.0842*t + sin(4*pi*t)");
		in = new Integral(f, 0, 20);
		double i = in.getIntegral2();
		System.out.println("The approximated integral with the second method is: " +i);
		double a = in.getAbsError(i);
		System.out.println("The absolute error is: " +a);
		double r = in.getRelError(i);
		System.out.println("The relative error is: " +r +"%");

	}
	
	public void draw() {
		this.background(0);
		in.plot(this);
	}

}
