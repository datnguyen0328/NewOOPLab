package hust.soict.ict.lab01;

import java.util.Scanner;

public class ArraySort {

	int partition(int a[], int l, int r) {
		int pivot = a[r];
		int i = l - 1;

		for (int j = l; j < r; j++) {
			if (a[j] <= pivot) {
				i++;
				int temp1 = a[i];
				a[i] = a[j];
				a[j] = temp1;
			}
		}

		i++;
		int temp2 = a[i];
		a[i] = a[r];
		a[r] = temp2;
		return i;
	}

	void quickSort(int a[], int l, int r) {
		if (l < r) {
			int p = partition(a, l, r);
			quickSort(a, l, p - 1);
			quickSort(a, p + 1, r);
		}
	}

	int arraySum(int a[]) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}

		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter size n of the array:");
		n = scanner.nextInt();

		int a[] = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}

		System.out.print("The old array is: ");
		for (int i = 0; i < n; i++) {
			System.out.print(a[i]);
			System.out.print(" ");
		}

		ArraySort obArraySort = new ArraySort();
		obArraySort.quickSort(a, 0, n - 1);

		System.out.println();
		System.out.print("The sorted array is: ");
		for (int i = 0; i < n; i++) {
			System.out.print(a[i]);
			System.out.print(" ");
		}

		System.out.println();
		System.out.println("The sum of the array elements is: " + obArraySort.arraySum(a));

		System.out.println("The average value of the array elements is: " + obArraySort.arraySum(a) / n);
	}
}
