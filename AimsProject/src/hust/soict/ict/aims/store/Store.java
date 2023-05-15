package hust.soict.ict.aims.store;
import hust.soict.ict.aims.disc.DigitalVideoDisc;

public class Store {
	private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[1000];
	int count = 0;
	boolean isFound = false;
	int targetId;

	public DigitalVideoDisc[] getItemsInStore() {
		return itemsInStore;
	}

	public void setItemsInStore(DigitalVideoDisc[] itemsInStore) {
		this.itemsInStore = itemsInStore;
	}

	public void addDVD(DigitalVideoDisc... dvdList) {
		for (DigitalVideoDisc dvd : dvdList) {
			itemsInStore[count] = dvd;
			count++;
		}
	}

	public void removeDVD(int id) {
		isFound = false;
		if (count == 0) {
			System.out.println("There is no item to remove");
		} else {
			for (int i = 0; i < count; i++) {
				if (itemsInStore[i].getId() == id) {
					targetId = i;
					isFound = true;
				}
			}
			if (isFound) {
				for (int i = targetId; i < count - 1; i++) {
					int j = i + 1;
					DigitalVideoDisc temp = itemsInStore[i];
					itemsInStore[i] = itemsInStore[j];
					itemsInStore[j] = temp;
				}
				count--;
				System.out.println("Remove successfully");
			} else {
				System.out.println("No item match.");
			}
		}
	}

	public void print() {
		for (int i = 0; i < count; i++) {
			System.out.println(itemsInStore[i]);
		}
	}

}
