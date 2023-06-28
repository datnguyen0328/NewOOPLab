package hust.soict.ict.test.store;
import hust.soict.ict.aims.media.Book;
import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.media.Media;
import hust.soict.ict.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		Store store = new Store(3);

		DigitalVideoDisc dvd = new DigitalVideoDisc("Hey you", "Animation", "IDK", 123, 20.11f);
	    Book book = new Book(0, "Caging sky", "Comedy", 20.4f);
	    CompactDisc cd = new CompactDisc(10, "Come and get your love", "R&B", 12f, "IDK", "Peter Quill");
		
		store.addMedia(dvd);
		store.addMedia(book);
		store.addMedia(cd);
		
		//search and print
		Media media = store.searchByTitle("Hey You");
		System.out.println(media.toString());
	}

}
