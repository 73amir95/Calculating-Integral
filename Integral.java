package calculating_integral;

import java.awt.Color;


import org.mariuszgromada.math.mxparser.Function;

import grafica.GPoint;
import processing.core.PApplet;

public class Integral {
	
	private double a = 0.0;
	private double b = 0.0;
	private static final int N_PIECES = 200;
	private static final double ABSOLUTE_INTEGRAL = 616.7604;
	private Function f;
	private FunctionPlotter1D fp;
	
	public Integral(Function f, double a, double b) {
		this.a = a;
		this.b = b;
		this.f = f;
		fp = new FunctionPlotter1D(this.f, this.a, this.b);
	}
	
	
	public void plot(PApplet app) {
		this.fp.plot(app);
	}


	/**
	 * Calculates the integral using the first method.
	 *
	 * @return The calculated integral.
	 */
		
	public double getIntegral1() {						//getting integral with the first method
		double integral = 0.0;
		double area = 0.0;
		double dx  = (this.b - this.a)/N_PIECES;
		this.fp.clearPoints();
		
		for(int i = 0; i < N_PIECES; i++) {
			double x = this.a + i*dx;
			double fx = this.f.calculate(x);
				 
			GPoint pointA = new GPoint((float) x, 0);
			GPoint pointB = new GPoint((float) x, (float) fx);
			GPoint pointC = new GPoint((float) (x + dx), (float) fx);
			this.fp.addLine(pointA, pointB, Color.BLUE);
			this.fp.addLine(pointC, pointB, Color.BLUE);
					
			area = fx * dx;
			integral = integral + area;
		}
		 
		return integral;
	}


	/**
	 * Calculates the integral using the second method.
	 *
	 * @return The calculated integral.
	 */

	public double getIntegral2() {						//getting integral with the second method
		double integral = 0.0;
		double area = 0.0;
		double dx  = (this.b - this.a)/N_PIECES;
		this.fp.clearPoints();
		
		for(int i = 0; i < N_PIECES; i++) {
			double x = this.a + (0.5 * dx) + i*dx;
			double fx = this.f.calculate(x);
				 
			GPoint pointA = new GPoint((float) (x - (0.5 * dx)), 0);
			GPoint pointB = new GPoint((float) (x - (0.5 * dx)) , (float) fx);
			GPoint pointC = new GPoint((float) (x + (0.5 * dx)), (float) fx);
			this.fp.addLine(pointA, pointB, Color.RED);
			this.fp.addLine(pointC, pointB, Color.RED);
					
			area = fx * dx;
			integral = integral + area;
		}
		 
		return integral;
	}


	/**
	 * Calculates the integral using the third method.
	 *
	 * @return The calculated integral.
	 */


	public double getIntegral3() {						//getting integral with the third method
		double integral = 0.0;
		double area = 0.0;
		double dx  = (this.b - this.a)/N_PIECES;
		this.fp.clearPoints();
		
		for(int i = 0; i < N_PIECES; i++) {
			double x = this.a + i*dx;
			double fx = this.f.calculate(x);
			double fx1 = this.f.calculate(x + dx);
				 
			GPoint pointA = new GPoint((float) (x), 0);
			GPoint pointB = new GPoint((float) (x) , (float) fx);
			GPoint pointC = new GPoint((float) (x + dx), (float) fx);
			this.fp.addLine(pointA, pointB, Color.GREEN);
			this.fp.addLine(pointC, pointB, Color.GREEN);
					
			area = (fx + fx1)/2 * dx;
			integral = integral + area;
		}
		 
		return integral;
	}
	
	public double getAbsError(double apprxIntegral) {
		double getAbsError = Math.abs(ABSOLUTE_INTEGRAL - apprxIntegral);
		return getAbsError;
	}
	
	public double getRelError(double apprxIntegral) {
		double getRelError = (Math.abs(ABSOLUTE_INTEGRAL - apprxIntegral)/ABSOLUTE_INTEGRAL)*100;
		return getRelError;
	}
}
