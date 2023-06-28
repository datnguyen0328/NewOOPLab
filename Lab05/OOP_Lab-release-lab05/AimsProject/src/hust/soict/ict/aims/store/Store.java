package hust.soict.ict.aims.store;

import java.util.ArrayList;

import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.media.Media;

import hust.soict.ict.aims.exception.EmptyException;
import hust.soict.ict.aims.exception.NotExistedException;
import javax.naming.LimitExceededException;

public class Store {
	private int capacity;
	private ArrayList<Media> items = new ArrayList<>();

	public Store(int capacity) {
		this.capacity = capacity;
	}

	public void addMedia(Media media) throws LimitExceededException {
		if (itemsInStore.size() < capacity) {
			itemsInStore.add(media);
			System.out.println("Media added");
		} else {
			System.out.println("Store is full");
			throw new LimitExceededException("Store is full");
		}
	}

	public void removeMedia(Media media)  throws EmptyException, NotExistedException {
		if (items.isEmpty()) {
			System.out.println("Store is empty");
			throw new EmptyException("Store is empty");
		}
		else if (!items.contains(media)) {
			System.out.println("Media not found");
			throw new NotExistedException("Media not found");
		}
		else {
			items.remove(media);
			System.out.println("Media removed");
		}
	}

	public Media searchByTitle(String title) {
		for (Media media : items) {
			if (media.getTitle().equals(title)) return media;
		}
		return null;
	}

	public void print() {
		System.out.println("\nSTORE: ");
		for (int i = 1; i <= items.size(); i++)
			System.out.println(i + ". " + items.get(i - 1).toString());
		System.out.println();
	}
}
