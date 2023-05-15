package hust.soict.ict.lab01;

import java.util.Scanner;

public class MatrixAdd {

	void matrixAddMethod(int a[][], int b[][]) {
		int row = a.length;
		int col = a[0].length;
		int result[][] = new int[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				result[i][j] = a[i][j] + b[i][j];
			}
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int row, col;
		System.out.println("Enter number of rows:");
		row = scanner.nextInt();
		System.out.println("Enter number of columns:");
		col = scanner.nextInt();
		
		int a[][] = new int[row][col];
		int b[][] = new int[row][col];
		System.out.println("Enter a:");
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				a[i][j] = scanner.nextInt();
			}
		}
		System.out.println("Enter b:");
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				b[i][j] = scanner.nextInt();
			}
		}
		
		MatrixAdd obAdd = new MatrixAdd();
		System.out.println("The new matrix is: ");
		obAdd.matrixAddMethod(a, b);
	}

}
