package Lab01;

import java.util.Scanner;

public class DayDisplay {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputMonth;
		int inputYear;
		boolean isLeapYear;

		System.out.println("Enter month: ");
		inputMonth = scanner.next();

		System.out.println("Input year: ");
		inputYear = scanner.nextInt();
		while (inputYear < 0) {
			System.out.println("Invalid value for year. Enter new year:");
			inputYear = scanner.nextInt();
		}

		if (inputYear % 4 == 0 && inputYear % 100 != 0) {
			isLeapYear = true;
		} else if (inputYear % 100 == 0 && inputYear % 400 == 0) {
			isLeapYear = true;
		} else {
			isLeapYear = false;
		}

		if (inputMonth.equals("January") || inputMonth.equals("Jan.") || inputMonth.equals("Jan")
				|| inputMonth.equals("1")) {
			System.out.println("January has 31 days.");
		}
		if (inputMonth.equals("Febuary") || inputMonth.equals("Feb.") || inputMonth.equals("Feb")
				|| inputMonth.equals("2")) {
			if (isLeapYear) {
				System.out.println("Febuary has 29 days.");
			} else {
				System.out.println("Febuary has 28 days");
			}
		}
		if (inputMonth.equals("March") || inputMonth.equals("Mar.") || inputMonth.equals("Mar")
				|| inputMonth.equals("3")) {
			System.out.println("March has 31 days.");
		}
		if (inputMonth.equals("April") || inputMonth.equals("Apr.") || inputMonth.equals("Apr")
				|| inputMonth.equals("4")) {
			System.out.println("April has 30 days.");
		}
		if (inputMonth.equals("May") || inputMonth.equals("May.") || inputMonth.equals("May")
				|| inputMonth.equals("5")) {
			System.out.println("May has 31 days.");
		}
		if (inputMonth.equals("June") || inputMonth.equals("Jun.") || inputMonth.equals("Jun")
				|| inputMonth.equals("6")) {
			System.out.println("June has 30 days.");
		}
		if (inputMonth.equals("July") || inputMonth.equals("Jul.") || inputMonth.equals("Jul")
				|| inputMonth.equals("7")) {
			System.out.println("July has 31 days.");
		}
		if (inputMonth.equals("August") || inputMonth.equals("Aug.") || inputMonth.equals("Aug")
				|| inputMonth.equals("8")) {
			System.out.println("August has 31 days.");
		}
		if (inputMonth.equals("September") || inputMonth.equals("Sep.") || inputMonth.equals("Sep")
				|| inputMonth.equals("9")) {
			System.out.println("September has 30 days.");
		}
		if (inputMonth.equals("October") || inputMonth.equals("Oct.") || inputMonth.equals("Oct")
				|| inputMonth.equals("10")) {
			System.out.println("October has 31 days.");
		}
		if (inputMonth.equals("November") || inputMonth.equals("Nov.") || inputMonth.equals("Nov")
				|| inputMonth.equals("11")) {
			System.out.println("November has 30 days.");
		}
		if (inputMonth.equals("December") || inputMonth.equals("Dec.") || inputMonth.equals("Dec")
				|| inputMonth.equals("12")) {
			System.out.println("December has 31 days.");
		}
	}
}
