package hust.soict.ict.lab01;

import java.util.Scanner;

public class TriangleDisplay {

	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter n: ");
		n = scanner.nextInt();

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < (n - i); j++) {
				System.out.print(" ");
			}
			for (int k = 1; k < (2*i); k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
