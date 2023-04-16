package Lab01;

import java.util.Scanner;

public class TwoVariablesEquation {

	public static void main(String[] args) {
		double a1, b1, c1, a2, b2, c2;

		System.out.println("The system of first-degree quations with two variables is: ");
		System.out.println("a1x + b1y + c1 = 0");
		System.out.println("a2x + b2y + c2 = 0");

		Scanner sc = new Scanner(System.in);
		System.out.println("Input a1: ");
		a1 = sc.nextDouble();

		System.out.println("Input b1: ");
		b1 = sc.nextDouble();

		System.out.println("Input c1: ");
		c1 = sc.nextDouble();

		System.out.println("Input a2: ");
		a2 = sc.nextDouble();

		System.out.println("Input b2: ");
		b2 = sc.nextDouble();

		System.out.println("Input c2: ");
		c2 = sc.nextDouble();

		if (a1 / a2 - b1 / b2 == 0 && a1 / a2 - c1 / c2 != 0) {
			System.out.println("No solution");
		} else if (a1 / a2 - b1 / b2 == 0 && b1 / b2 - c1 / c2 == 0) {
			System.out.println("Infinite solutions");
		} else {
			System.out.println("The first root x is: x = " + (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1));
			System.out.println("The second root y is: y = " + (c1 * a2 - c2 * a1) / (a1 * b2 - a2 * b1));
		}

	}

}
