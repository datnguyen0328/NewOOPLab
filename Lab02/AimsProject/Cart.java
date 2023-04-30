import java.awt.PageAttributes.PrintQualityType;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	int qtyOrdered;
	int targetId;
	float myTotalCost = 0;

	public boolean checkFull() {
		if (qtyOrdered < 20) {
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

	public void readDigitalVideoDisc() {
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println(itemsOrdered[i]);
		}
	}

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (!checkFull()) {
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

}
