package Lab01;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		String a = "test";
		Scanner scanner = new Scanner(System.in);
		String b;
		b = scanner.next();
		if(b.equals(a)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
		System.out.println(a == "test");
	}

}
