package hust.soict.ict.aims.cart;

import java.util.ArrayList;
import java.util.Collections;

import javax.naming.LimitExceededException;
import hust.soict.ict.aims.exception.EmptyException;
import hust.soict.ict.aims.exception.NotExistedException;
import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	private static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<>();
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public void addMedia(Media media)  throws LimitExceededException {
		if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(media);
			System.out.println("Media added");
		} else {
			System.out.println("Cart is full!");
			throw new LimitExceededException("Error: Maximum size of items reach");
		}
	}

	public void removeMedia(Media media) throws EmptyException, NotExistedException  {
		if (itemsOrdered.isEmpty()){
			System.out.println("Cart is empty!");
			throw new EmptyException("Cart is empty!");
		}
		else if (!itemsOrdered.contains(media)){
			System.out.println("Media not found");
			throw new NotExistedException("Media not found");
		}
		else {
			System.out.println("Media removed");
			itemsOrdered.remove(media);
		}
	}

	public float totalCost() {

		// initialize cost
		float totalCost = .0f;

		for (Media media : itemsOrdered)
			totalCost += media.getCost();
		return totalCost;
	}

	public void searchById(int id) {
		for (Media media : itemsOrdered) {
			if (media.getId() == id) {
				System.out.println(media.toString());
				return;
			}
		}
		System.out.println("Item not found");
	}

	public void searchByTitle(String title) {
		for (Media media : itemsOrdered) {
			if (media.getTitle().equals(title)) {
				System.out.println(media.toString());
				return;
			}
		}
		System.out.println("Item not found");
	}

	public void print() {
		System.out.println("\nYOUR CART: ");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println((i + 1) + ") " + itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + this.totalCost() + "$\n");
	}

	public void sortByTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}

	public void sortByCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}

	public void makeEmpty() {
		itemsOrdered.clear();
	}

	public Media findByTitle(String title) {
		for (Media media : itemsOrdered) {
			if (media.getTitle().equals(title))
				return media;
		}
		return null;
	}

	public void placeOrder() {
		if (itemsOrdered.size() > 0) {
			System.out.println("Cart ordered");
			itemsOrdered.clear();
		} else {
			System.out.println("No items in the cart.");
		}
	}
}
