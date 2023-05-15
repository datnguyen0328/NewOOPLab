package hust.soict.ict.lab01;

import java.util.Scanner;

public class EquationSolving {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a, b;

		System.out.println("Enter a: ");
		a = sc.nextDouble();
		while (a == 0) {
			System.out.println("Invalid value for a. Enter a: ");
			a = sc.nextDouble();
		}

		System.out.println("Enter b: ");
		b = sc.nextDouble();

		System.out.println("The root is: x = " + (-b / a));

	}
}
