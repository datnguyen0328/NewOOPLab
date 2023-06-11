package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authorStrings = new ArrayList<>();
	
	public Book(String title, String category, float cost, ArrayList<String> authorStrings) {
		super(title, category, cost);
		this.authorStrings = authorStrings;
	}

	public List<String> getAuthorStrings() {
		return authorStrings;
	}
	
	public void addAuthor(String author) {
		if(authorStrings.contains(author)) {
			System.out.println("Already exist.");
		}else {
			authorStrings.add(author);
		}
	}
	
	public void removeAuthor(String author) {
		if(authorStrings.contains(author)) {
			authorStrings.remove(author);
		}else {
			System.out.println("Not exist.");
		}
	}

	@Override
	public String toString() {
		return super.toString() + "[authorStrings=" + authorStrings + "]";
	}
	
	
}
