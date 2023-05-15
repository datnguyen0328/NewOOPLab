package hust.soict.ict.lab01;

import java.util.Scanner;
import java.lang.Math;

public class SecondDegreeEquation {
	public static void main(String[] args) {
		double a, b, c;
		double delta;
		System.out.println("The second-degree equation with one variable is: ax^2 + bx + c");

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a:");
		a = scanner.nextDouble();
		System.out.println("Enter b:");
		b = scanner.nextDouble();
		System.out.println("Enter c:");
		c = scanner.nextDouble();

		delta = b * b - 4 * a * c;

		if (delta < 0) {
			System.out.println("No solution");
		} else if (delta == 0) {
			System.out.println("The solution is: x = " + -b / (2 * a));
		} else {
			System.out.println("The two solution is:");
			System.out.println("x1 = " + (-b + Math.sqrt(delta)) / (2 * a));
			System.out.println("x2 = " + (-b - Math.sqrt(delta)) / (2 * a));
		}
	}
}
