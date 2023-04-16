package Lab01;
import java.util.Scanner;

public class Caculate {
	public static void main(String[] args) {
		double number1, number2;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the first number: ");
		number1 = sc.nextDouble();
		System.out.println("Enter the second number: ");
		number2 = sc.nextDouble();
		
		System.out.println("Sum: "+ (number1+number2));
		System.out.println("Difference: "+ (number1-number2));
		System.out.println("Product: "+ (number1*number2));
		System.out.println("Quotient: "+ (number1/number2));
	}
}
