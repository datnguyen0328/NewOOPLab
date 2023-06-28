package hust.soict.ict.test.cart;
import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.media.Book;
import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.media.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) {
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd = new DigitalVideoDisc("Hey you", "Animation", "IDK", 123, 20.11f);
	    Book book = new Book(0, "Caging sky", "Comedy", 20.4f);
	    CompactDisc cd = new CompactDisc(10, "Come and get your love", "R&B", 12f, "IDK", "Peter Quill");
		
		cart.addMedia(dvd);
		cart.addMedia(book);
		cart.addMedia(cd);
		
		
		//sort by title
		cart.sortByTitle();
		cart.print();
		
		//sort by cost
		cart.sortByCost();
		cart.print();
	}

}
