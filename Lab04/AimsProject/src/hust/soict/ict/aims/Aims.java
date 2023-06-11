package hust.soict.ict.aims;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hust.soict.dsai.aims.media.*;
import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.store.Store;
import hust.soict.ict.service.Service;

public class Aims {
	public static void main(String[] args) {
		int aimChoice;
		Service service = new Service();
		while (true) {
			Service.showMenu();
			aimChoice = new Scanner(System.in).nextInt();

			if (aimChoice == 0) {
				break;
			}
			switch (aimChoice) {
			case 1:
				service.storeMenu();
				break;
			case 2:
				service.updateStore();
				break;
			case 3: 
				service.cartMenu();
				break;
			}
		}
	}
}
