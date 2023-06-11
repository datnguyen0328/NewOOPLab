package hust.soict.ict.aims.cart;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.media.*;

public class Cart {
	private float myTotalCost = 0;
	private ArrayList<Media> itemsOrdered = new ArrayList<>();
	
	public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public Cart(ArrayList<Media> itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}

	public void addMedia(Media... medias) {
		for(Media media : medias) {
			if(!itemsOrdered.contains(media)) {
				itemsOrdered.add(media);
			}
		}
	}

	public void removeMedia(Media... medias) {
		for(Media media : medias) {
			if(itemsOrdered.contains(media)) {
				itemsOrdered.remove(media);
			}
		}
	}
	
	public float totalCost() {
		for (Media media : itemsOrdered) {
			myTotalCost += media.getCost();
		}
		return myTotalCost;
	}

	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.print(i+1 + ". ");
			System.out.println(itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************");
	}
	
	public void searchMediaById(int id) {
		for(Media media : itemsOrdered) {
			if(media.getId() == id) {
				System.out.println(media);
				return;
			}
		}
		System.out.println("No match is found.");
	}
	
	public void searchMediaByTitle(String title) {
		for(Media media : itemsOrdered) {
			if(media.getTitle().equals(title)) {
				System.out.println(media);
				return;
			}
		}
		System.out.println("No match is found");
	}

	public void sortMediaByCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
		print();
	}
	
	public void sortMediaByTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
		print();
	}
}
