package de.pjetrog;

public class Operation {

	public static double  addition(double z1, double z2) {
		return z1 + z2;
	}
	public static double subtraction(double z1, double z2) {
		return z1 - z2;
	}
	public static double multiplication(double z1, double z2) {
		return z1 * z2;
	}
	public static double division(double z1, double z2) {
		if(z2 != 0) {
			return z1 / z2;
		}
		System.out.println("Es kann nicht durch \"0\" geteilt werden!");
		return 0;
	}
	
}
