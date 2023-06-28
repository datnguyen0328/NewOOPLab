package hust.soict.ict.aims.media;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Media;
import hust.soict.ict.aims.exception.AlreadyExistedException;
import hust.soict.ict.aims.exception.NegativeException;
import hust.soict.ict.aims.exception.NotExistedException;

public class Book extends Media {
	private static int numberOfBooks = 0;
	private List<String> authors = new ArrayList<String>();

	public Book(int id, String title, String category, float cost)  throws NegativeException {
		super(numberOfBooks++, title, category, cost);
	}

	public Book(int id, String title, String category, float cost, ArrayList<String> authors) throws NegativeException{
		super(numberOfBooks++, title, category, cost);
		this.authors = authors;
	}

	public void addAuthor(String name) throws AlreadyExistedException {
		if (!authors.contains(name)) {
			authors.add(name);
			System.out.println("Author added");
		} else {
			System.out.println("Author exists, cannot add");
			throw new AlreadyExistedException("Author already exists, cannot add");
		}
	}

	public void removeAuthor(String name)  throws NotExistedException {
		if (authors.contains(name)) {
			authors.remove(name);
			System.out.println("Author removed!");
		} else {
			System.out.println("Author not found");
			throw new NotExistedException("Author not found, cannot remove");
		}
	}

	public String toString() {
		return "Book: id: " + this.getId() + " - " + this.getTitle() + " - " + this.getCategory() + " - $"
				+ this.getCost();
	}

}
