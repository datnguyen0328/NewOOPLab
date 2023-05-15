package hust.soict.ict.test.store;
import hust.soict.ict.aims.disc.DigitalVideoDisc;
import hust.soict.ict.aims.store.Store;

public class StoreTest {
	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		
		Store store = new Store();
		
		store.addDVD(dvd1);
		store.addDVD(dvd2);
		store.addDVD(dvd3);
		
		store.print();
		
		store.removeDVD(1);
		store.removeDVD(10);
		store.removeDVD(10);
		store.removeDVD(10);
		
		store.print();
	}
}
