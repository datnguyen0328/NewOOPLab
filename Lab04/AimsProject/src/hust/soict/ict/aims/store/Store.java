package hust.soict.ict.aims.store;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<>(); 

	public Store(ArrayList<Media> itemsInStore) {
		this.itemsInStore = itemsInStore;
	}

	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}

	public void setItemsInStore(ArrayList<Media> itemsInStore) {
		this.itemsInStore = itemsInStore;
	}
	
	public void addMedia(Media... medias) {
		for(Media media : medias) {
			if(!itemsInStore.contains(media)) {
				itemsInStore.add(media);
			}
		}
	}

	public void removeMedia(Media... medias) {
		for(Media media : medias) {
			if(itemsInStore.contains(media)) {
				itemsInStore.remove(media);
			}
		}
	}

	public void print() {
		System.out.println("Items in store:");
		for(Media media : itemsInStore) {
			System.out.println(media);
		}
	}

}
