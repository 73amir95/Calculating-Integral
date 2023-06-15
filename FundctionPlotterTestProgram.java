package calculating_integral;

import org.mariuszgromada.math.mxparser.Function;

import processing.core.PApplet;

public class FundctionPlotterTestProgram extends PApplet{
	public static void main(String[] args) {
		PApplet.main(calculating_integral.FundctionPlotterTestProgram.class);
	}
	
	FunctionPlotter1D plotter;
	
	public void settings() {
		size(800, 500);
	}
	
	public void setup() {
		Function f = new Function("P(t) = (3.0842 * t) + sin(4 * pi * t)");
		plotter = new FunctionPlotter1D(f, 0, 20);
	}
	
	public void draw() {
		this.background(0);
		plotter.plot(this);
	}

}
