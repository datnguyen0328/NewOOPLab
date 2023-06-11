package hust.soict.ict.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.store.Store;

public class Service {
	private ArrayList<Media> storeMedias = new ArrayList<>();
	private ArrayList<Media> cartMedias = new ArrayList<>();
	private Store store = new Store(storeMedias);
	private Cart cart = new Cart(cartMedias);
	private Media targetMedia;
	private String titleString;

	public void inputMediaTitle() {
		System.out.println("Input the title of the media:");
		titleString = new Scanner(System.in).nextLine();
	}

	// storeMenu 1
	public void showMediaDetails() {
		inputMediaTitle();
		for (Media media : storeMedias) {
			if (media.getTitle().equals(titleString)) {
				targetMedia = media;
				System.out.println(media);
				return;
			}
		}
		System.out.println("No media found.");
	}

	public void mediaDetailsMenu() {
		int mediaDetailChoice;

		while (true) {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Add to cart");
			System.out.println("2. Play");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");

			mediaDetailChoice = new Scanner(System.in).nextInt();
			if (mediaDetailChoice == 0) {
				break;
			}
			switch (mediaDetailChoice) {
			case 1:
				cart.addMedia(targetMedia);
				break;
			case 2:
				if (targetMedia instanceof DigitalVideoDisc) {
					((DigitalVideoDisc) targetMedia).play();
				} else if (targetMedia instanceof CompactDisc) {
					((CompactDisc) targetMedia).play();
				}
				break;
			}
		}
	}

	// storeMenu 2
	public void addMediaToCart() {
		inputMediaTitle();
		for (Media media : storeMedias) {
			if (media.getTitle().equals(titleString)) {
				cart.addMedia(media);
				return;
			}
		}
		System.out.println("No media found.");
		cart.print();
	}

	// storeMenu 3
	public void playMedia() {
		inputMediaTitle();

		for (Media media : storeMedias) {
			if (media.getTitle().equals(titleString) && media instanceof DigitalVideoDisc) {
				DigitalVideoDisc digitalVideoDisc = (DigitalVideoDisc) media;
				digitalVideoDisc.play();
				return;
			} else if (media.getTitle().equals(titleString) && media instanceof CompactDisc) {
				CompactDisc compactDisc = (CompactDisc) media;
				compactDisc.play();
				return;
			}
		}
		System.out.println("No media found.");
	}

	public static void showMenu() {
		System.out.println("AIMS:");
		System.out.println("-----------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("-----------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	// showMenu 1
	public void storeMenu() {
		store.print();
		int storeChoice;

		while (true) {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. See a media’s details");
			System.out.println("2. Add a media to cart");
			System.out.println("3. Play a media");
			System.out.println("4. See current cart");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4");

			storeChoice = new Scanner(System.in).nextInt();

			if (storeChoice == 0) {
				break;
			}
			switch (storeChoice) {
			case 1:
				showMediaDetails(); // neu ma no media found -> k hien mediaDetailMenu
				mediaDetailsMenu();
				break;
			case 2:
				addMediaToCart();
				break;
			case 3:
				playMedia();
				break;
			case 4:
				cart.print();
				break;
			}
		}
	}

	// showMenu 2
	public void updateStore() {
		int updateStoreChoice;

		while (true) {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Add a media to store");
			System.out.println("2. Remove a media from store");
			System.out.println("0. Back");

			updateStoreChoice = new Scanner(System.in).nextInt();

			if (updateStoreChoice == 0) {
				break;
			}
			switch (updateStoreChoice) {
			case 1:
				addItemStore();
				break;
			case 2:
				inputMediaTitle();
				for (int i = 0; i < storeMedias.size(); i++) {
					if (storeMedias.get(i).getTitle().equals(titleString)) {
						store.removeMedia(storeMedias.get(i));
					}
				}
				break;
			}
		}
	}

	public void addItemStore() {
		int addItemStoreChoice;

		while (true) {
			System.out.println("Choose kind of media to add:");
			System.out.println("1. Digital Video Disc");
			System.out.println("2. Compact Disc");
			System.out.println("3. Book");
			System.out.println("0. Back");

			addItemStoreChoice = new Scanner(System.in).nextInt();

			if (addItemStoreChoice == 0) {
				break;
			}
			switch (addItemStoreChoice) {
			case 1:
				addDigitalVideoDisc();
				break;
			case 2:
				addCompactDisc();
				break;
			case 3:
				addBook();
				break;
			}
		}
	}

	public void addDigitalVideoDisc() {
		System.out.println("Input information of the new DVD:");
		System.out.println("Title:");
		String title = new Scanner(System.in).nextLine();
		System.out.println("Category:");
		String category = new Scanner(System.in).nextLine();
		System.out.println("Director:");
		String director = new Scanner(System.in).nextLine();
		System.out.println("Length:");
		int length = new Scanner(System.in).nextInt();
		System.out.println("Cost:");
		float cost = new Scanner(System.in).nextFloat();

		DigitalVideoDisc digitalVideoDisc = new DigitalVideoDisc(title, category, director, length, cost);
		store.addMedia(digitalVideoDisc);
	}

	public void addCompactDisc() {
		int addTrackChoice;
		String trackTitle;
		int trackLength;

		System.out.println("Input information of the new CD:");
		System.out.println("Title:");
		String title = new Scanner(System.in).nextLine();
		System.out.println("Category:");
		String category = new Scanner(System.in).nextLine();
		System.out.println("Director:");
		String director = new Scanner(System.in).nextLine();
		System.out.println("Length:");
		int length = new Scanner(System.in).nextInt();
		System.out.println("Cost:");
		float cost = new Scanner(System.in).nextFloat();
		System.out.println("Artist:");
		String artist = new Scanner(System.in).nextLine();
		System.out.println("Tracks:");
		ArrayList<Track> tracks = new ArrayList<>();
		while (true) {
			System.out.println("1. Add new track");
			System.out.println("0. Back");

			addTrackChoice = new Scanner(System.in).nextInt();

			if (addTrackChoice == 0) {
				break;
			} else {
				System.out.println("Track title:");
				trackTitle = new Scanner(System.in).nextLine();
				System.out.println("Track length:");
				trackLength = new Scanner(System.in).nextInt();
				Track track = new Track(title, length);
				tracks.add(track);
			}
		}

		CompactDisc compactDisc = new CompactDisc(title, category, director, length, cost, artist, tracks);
		store.addMedia(compactDisc);
	}

	public void addBook() {
		int addAuthorChoice;
		String author;

		System.out.println("Input information of the new book:");
		System.out.println("Title:");
		String title = new Scanner(System.in).nextLine();
		System.out.println("Category:");
		String category = new Scanner(System.in).nextLine();
		System.out.println("Cost:");
		float cost = new Scanner(System.in).nextFloat();
		System.out.println("Authors:");
		ArrayList<String> authors = new ArrayList<>();
		while (true) {
			System.out.println("1. Add new author");
			System.out.println("0. Back");

			addAuthorChoice = new Scanner(System.in).nextInt();

			if (addAuthorChoice == 0) {
				break;
			} else {
				System.out.println("Author:");
				author = new Scanner(System.in).nextLine();
				authors.add(author);
			}
		}

		Book book = new Book(title, category, cost, authors);
		store.addMedia(book);
	}

	// showMenu 3
	public void cartMenu() {
		cart.print();

		int cartMenuChoice;

		while (true) {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Filter medias in cart");
			System.out.println("2. Sort medias in cart");
			System.out.println("3. Remove media from cart");
			System.out.println("4. Play a media");
			System.out.println("5. Place order");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4-5");

			cartMenuChoice = new Scanner(System.in).nextInt();

			if (cartMenuChoice == 0) {
				break;
			}
			switch (cartMenuChoice) {
			case 1:
				filterMedia();
				break;
			case 2:
				sortMedia();
				break;
			case 3:
				inputMediaTitle();
				for (int i = 0; i < cartMedias.size(); i++) {
					if (cartMedias.get(i).getTitle().equals(titleString)) {
						cart.removeMedia(cartMedias.get(i));
					}
				}
				break;
			case 4:
				playCartMedia();
				break;
			case 5:
				System.out.println("An order is created.");
				for (Media media : cart.getItemsOrdered()) {
					cart.removeMedia(media);
				}
				break;
			}
		}

	}
	
	public void playCartMedia() {
		inputMediaTitle();
		for (Media media : cartMedias) {
			if (media.getTitle().equals(titleString) && media instanceof DigitalVideoDisc) {
				DigitalVideoDisc digitalVideoDisc = (DigitalVideoDisc) media;
				digitalVideoDisc.play();
				return;
			} else if (media.getTitle().equals(titleString) && media instanceof CompactDisc) {
				CompactDisc compactDisc = (CompactDisc) media;
				compactDisc.play();
				return;
			}
		}
		System.out.println("No media found.");
	}

	public void filterMedia() {
		int filterMediaChoice;

		while (true) {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Filter medias in cart by id");
			System.out.println("2. Filter medias in cart by title");
			System.out.println("3. Back");

			filterMediaChoice = new Scanner(System.in).nextInt();
			if (filterMediaChoice == 0) {
				break;
			}
			switch (filterMediaChoice) {
			case 1:
				System.out.println("Input id:");
				int searchId = new Scanner(System.in).nextInt();
				cart.searchMediaById(searchId);
				break;
			case 2:
				System.out.println("Input title:");
				String searchTitle = new Scanner(System.in).nextLine();
				cart.searchMediaByTitle(searchTitle);
				break;
			}
		}
	}

	public void sortMedia() {
		int sortMediaChoice;

		while (true) {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Sort medias in cart by cost");
			System.out.println("2. Sort medias in cart by title");
			System.out.println("0. Back");

			sortMediaChoice = new Scanner(System.in).nextInt();
			if (sortMediaChoice == 0) {
				break;
			}
			switch (sortMediaChoice) {
			case 1:
				cart.sortMediaByCost();
				break;
			case 2:
				cart.sortMediaByTitle();
				break;
			}
		}
	}
}
