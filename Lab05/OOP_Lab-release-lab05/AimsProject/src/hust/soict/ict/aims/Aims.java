package hust.soict.ict.aims;

import java.util.Scanner;

import javax.naming.LimitExceededException;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.media.Book;
import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.media.Media;
import hust.soict.ict.aims.media.Track;
import hust.soict.ict.aims.store.Store;

import hust.soict.ict.aims.exception.AlreadyExistedException;
import hust.soict.ict.aims.exception.NegativeException;
import hust.soict.ict.aims.exception.PlayerException;

public class Aims {

	public static void main(String[] args) {
		String option;
		Scanner scanner = new Scanner(System.in);
		Store store = new Store(20);

		Cart cart = new Cart();

		boolean toExit = false;
		while (!toExit) {
			showMenu();

			// let user choose in menu
			option = scanner.next();
			switch (option) {
				case "0": {
					// select 0 to exit the program
					System.out.println("Program exit");
					toExit = true;
					break;
				}

				case "1": {
					boolean stillInView = true;
					while (stillInView) {
						store.print();
						storeMenu();
						option = scanner.next();
						switch (option) {

							// move back option
							case "0": {
								stillInView = false;
								break;
							}

							case "1": {
								System.out.println("Find media using title: ");
								scanner.nextLine();

								String title = scanner.nextLine();
								Media media = store.searchByTitle(title);

								if (media == null)
									System.out.println("Media does not found");
								else {
									System.out.println("Media found: ");
									System.out.println(media.toString());

									boolean stillInDetail = true;
									while (stillInDetail) {
										mediaDetailsMenu();

										option = scanner.next();
										switch (option) {
											case "0": {
												stillInDetail = false;
												break;
											}
											case "1": { // add to cart
												try {
													cart.addMedia(media);
												} catch (LimitExceededException e) {
													e.printStackTrace();
												}
												break;
											}
											case "2": {
												// select wrong media
												if (media instanceof Book)
													System.out.println("Invalid type");

												// if compactDisc or DVD, type cast and play
												else if (media instanceof CompactDisc){
													try {
														((CompactDisc) media).play();
													} catch (PlayerException e) {
														e.printStackTrace();
													}
												}
												else{
													try {
														((DigitalVideoDisc) media).play();
													} catch (PlayerException e) {
														e.printStackTrace();
													}
												}
												break;
											}
											default: {
												System.out.println("Invalid option");
												break;
											}
										}
									}
								}
								break;
							}

							case "2": { // find and add to cart
								System.out.println("Media title: ");
								scanner.nextLine();

								String title = scanner.nextLine();
								Media media = store.searchByTitle(title);
								if (media == null)
									System.out.println("Media not found");
								else{
									try{
										cart.addMedia(media);
									}catch(LimitExceededException e){
										e.printStackTrace();
									}
								}
								break;
							}

							case "3": { // play the dvd or disc
								System.out.println("Media title: ");
								scanner.nextLine();

								String title = scanner.nextLine();
								Media media = store.searchByTitle(title);
								if (media == null)
									System.out.println("Media not found");
								else {
									if (media instanceof Book) {
										System.out.println("Invalid type");
									}

									// if correct media type, typecast and play
									else if (media instanceof CompactDisc){
										try {
											((CompactDisc) media).play();
										} catch (PlayerException e) {
											e.printStackTrace();
										}
									}
									else{
										try {
											((DigitalVideoDisc) media).play();
										} catch (PlayerException e) {
											e.printStackTrace();
										}
									}
								}
								break;
							}

							case "4": {
								cart.print();
								break;
							}

							default: {
								System.out.println("Invalid option");
								break;
							}
						}
					}

					break;
				}

				case "2": {
					while (1) {
						System.out.println("Select type (book/cd/dvd): ");
						String type = scanner.next();

						if (type.equals("book") || type.equals("dvd") || type.equals("cd")) {

							System.out.println("Media id: ");
							int id = scanner.nextInt();
							scanner.nextLine();

							System.out.println("Meida title: ");
							String title = scanner.nextLine();

							System.out.println("Enter category: ");
							String category = scanner.nextLine();

							System.out.println("Enter cost: ");
							float cost = scanner.nextFloat();
							scanner.nextLine();

							switch (type) {
								case "book": {
									System.out.println("How many authors: ");

									int num = scanner.nextInt();
									scanner.nextLine();

									try {
										Book book = new Book(id, title, category, cost);
										while (num > 0) {
											System.out.println("Enter author: ");
											String author = scanner.nextLine();
											try {
												book.addAuthor(author);
											} catch (AlreadyExistedException e) {
												e.printStackTrace();
											}
											num--;
										}
										try {
											store.addMedia(book);
										} catch (LimitExceededException e) {
											e.printStackTrace();
										}
									} catch (NegativeException e) {
										e.printStackTrace();
									}
									break;
								}

								case "dvd": {
									System.out.println("DVD's director's name: ");
									String director = scanner.nextLine();

									System.out.println("Length: ");
									int length = scanner.nextInt();
									scanner.nextLine();

									try {
										DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length,
												cost);
										try {
											store.addMedia(dvd);
										} catch (LimitExceededException e) {
											e.printStackTrace();
										}
									} catch (NegativeException e) {
										e.printStackTrace();
									}
									break;
								}

								case "cd": {
									System.out.println("CD's director's name: ");
									String director = scanner.nextLine();

									System.out.println("Artist's name: ");
									String artist = scanner.nextLine();

									System.out.println("Amount of track: ");
									int num = scanner.nextInt();
									scanner.nextLine();

									try {
										CompactDisc cd = new CompactDisc(id, title, category, cost, director, artist);
										for (int i = 0; i < num; i++) {
											System.out.println("Track " + (i + 1) + "'s title: ");
											String trackTitle = scanner.nextLine();

											System.out.println("Length: ");
											int trackLength = scanner.nextInt();
											scanner.nextLine();

											try {
												cd.addTrack(new Track(trackTitle, trackLength));
											} catch (AlreadyExistedException e) {
												e.printStackTrace();
											}
										}

										try {
											store.addMedia(cd);
										} catch (LimitExceededException e) {
											e.printStackTrace();
										}
									} catch (NegativeException e) {
										e.printStackTrace();
									}
								}
							}

							// if correct type then next
							break;
						} else
							System.out.println("Invalid type");
					}
					store.print();
					break;
				}

				case "3": {
					boolean stillInCart = true;
					while (stillInCart) {
						cartMenu();

						option = scanner.next();
						switch (option) {
							case "0": {
								// select 0 to get out of loop
								stillInCart = false;
								break;
							}

							case "1": {
								System.out.println("1) Search by id");
								System.out.println("2) Search by title");

								option = scanner.next();
								while (option != "1" && option != "2") {
									System.out.println("Invalid option");
									option = scanner.next();
								}

								switch (option) {
									case "1": {
										System.out.println("Search with id: ");
										int id = scanner.nextInt();
										scanner.nextLine();

										cart.searchById(id);
										break;
									}
									case "2": {
										System.out.println("Search with title: ");
										scanner.nextLine();

										String title = scanner.nextLine();
										cart.searchByTitle(title);
										break;
									}
								}
								break;
							}

							case "2": {
								System.out.println("1) Sort by title");
								System.out.println("2) Sort by cost");
								option = scanner.next();
								while (option != "1" && option != "2") {
									System.out.println("Invalid option");
									option = scanner.next();
								}

								switch (option) {
									case "1": {
										cart.sortByTitle();
										cart.print();
										break;
									}
									case "2": {
										cart.sortByCost();
										cart.print();
										break;
									}
								}
								break;
							}

							case "3": {
								System.out.println("Enter media's title to remove: ");
								scanner.nextLine();

								String title = scanner.nextLine();
								Media media = cart.findByTitle(title);
								if (media == null)
									System.out.println("Media not found");
								else {
									try {
										cart.removeMedia(media);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
								break;
							}

							case "4": {
								System.out.println("Choose media (title): ");
								scanner.nextLine();

								String title = scanner.nextLine();
								Media media = cart.findByTitle(title);
								if (media == null)
									System.out.println("Media not found");
								else {
									if (media instanceof Book)
										System.out.println("Invalid media type");

									// if correct media type
									else if (media instanceof CompactDisc) {
										try {
											((CompactDisc) media).play();
										} catch (PlayerException e) {
											e.printStackTrace();
										}
									} else {
										try {
											((DigitalVideoDisc) media).play();
										} catch (PlayerException e) {
											e.printStackTrace();
										}
									}
								}
								break;
							}

							case "5": {
								System.out.println("Order placed");
								cart.makeEmpty();
								break;
							}

							default:
								System.out.println("Invalid option");
						}
					}
					break;
				}

				default:
					System.out.println("Invalid option");
			}
		}

	}

	public static void showMenu() {
		System.out.println("AIMS:");
		System.out.println("----------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("----------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	public static void storeMenu() {
		System.out.println("Options:");
		System.out.println("----------------------");
		System.out.println("1. See a media's detail");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("----------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

	public static void cartMenu() {
		System.out.println("Options:");
		System.out.println("----------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("----------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}

	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("----------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("----------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
}
