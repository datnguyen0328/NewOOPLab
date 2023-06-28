package hust.soict.ict.test.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.ict.aims.media.Media;
import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.media.Book;
import hust.soict.ict.aims.media.CompactDisc;

public class MediaTest {

	public static void main(String[] args) {
		List<Media> media = new ArrayList<Media>();

        DigitalVideoDisc dvd = new DigitalVideoDisc("Hey you", "Animation", "IDK", 123, 20.11f);
	    Book book = new Book(0, "Caging sky", "Comedy", 20.4f);
	    CompactDisc cd = new CompactDisc(10, "Come and get your love", "R&B", 12f, "IDK", "Peter Quill");

        media.add(cd);
        media.add(dvd);
        media.add(book);

        for (Media item : media) {
            System.out.println(item.toString());
        }

	}

}
