package hust.soict.ict.aims.cart;
import hust.soict.ict.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	int qtyOrdered;
	int targetId;
	float myTotalCost = 0;

	public boolean checkFull(int newDisc) {
		if (qtyOrdered + newDisc <= MAX_NUMBERS_ORDERED) {
			return false;
		} else {
			return true;
		}
	}

	public boolean checkExist(DigitalVideoDisc disc) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].equals(disc)) {
				targetId = i;
				return true;
			}
		}
		return false;
	}

//	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
//		int j = 0;
//		if(!checkFull(dvdList.length)) {
//			for(int i = qtyOrdered; i < dvdList.length; i++) {
//				itemsOrdered[i] = dvdList[j];
//				j++;
//			}
//			System.out.println("List of objects added successfully.");
//		}else {
//			System.out.println("The cart is full.");
//		}
//	}

	public void addDigitalVideoDisc(DigitalVideoDisc... args) {
		int j = 0;
		if (!checkFull(args.length)) {
			for (int i = qtyOrdered; i < args.length; i++) {
				itemsOrdered[i] = args[j];
				j++;
			}
			System.out.println("List of objects added successfully.");
		} else {
			System.out.println("The cart is full.");
		}
	}

	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (!checkFull(2)) {
			itemsOrdered[qtyOrdered] = dvd1;
			qtyOrdered++;
			itemsOrdered[qtyOrdered] = dvd2;
			qtyOrdered++;

			System.out.println("Added successfully.");
		} else {
			System.out.println("The cart is full.");
		}
	}

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (!checkFull(1)) {
			itemsOrdered[qtyOrdered] = disc;
			System.out.println("Object added successfully.");
			qtyOrdered++;
		} else {
			System.out.println("The cart is full.");
		}
	}

	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == 0) {
			System.out.println("The cart is empty. Can not remove any object.");
		} else {
			if (checkExist(disc) && qtyOrdered > 1) {
				for (int i = targetId; i < qtyOrdered - 1; i++) {
					int j = i + 1;
					DigitalVideoDisc temp = itemsOrdered[i];
					itemsOrdered[i] = itemsOrdered[j];
					itemsOrdered[j] = temp;

				}
				qtyOrdered--;
				System.out.println("Remove successfully.");
			} else if (checkExist(disc)) {
				qtyOrdered--;
				System.out.println("Remove successfully.");
			} else {
				System.out.println("There is no object matching the object you want to delete.");
			}
		}
	}

	public float totalCost() {
		for (int i = 0; i < qtyOrdered; i++) {
			myTotalCost += itemsOrdered[i].getCost();
		}
		return myTotalCost;
	}

	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 1; i <= qtyOrdered; i++) {
			System.out.print(i + ". ");
			System.out.println(itemsOrdered[i - 1].toString());
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************");
	}
	
	public void searchDvdById(int id) {
		for(int i = 0; i < qtyOrdered; i++) {
			if(itemsOrdered[i].getId() == id) {
				System.out.println(itemsOrdered[i]);
				return;
			}
		}
		System.out.println("No match is found.");
	}
	
	public void searchDvdByTitle(String title) {
		for(int i = 0; i < qtyOrdered; i++) {
			if(itemsOrdered[i].getTitle().equals(title)) {
				System.out.println(itemsOrdered[i]);
				return;
			}
		}
		System.out.println("No match is found");
	}

}
