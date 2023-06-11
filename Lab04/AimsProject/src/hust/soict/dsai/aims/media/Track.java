package hust.soict.dsai.aims.media;

public class Track implements Playable {
	private String title;
	private int length;

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	@Override
	public String toString() {
		return "Track [title=" + title + ", length=" + length + "]";
	}

	@Override
	public boolean equals(Object object) {
		if(!(object instanceof Track)) {
			return false;
		}
		
		return this.getTitle().equals(((Track)object).getTitle()) && this.getLength() == ((Track)object).getLength();
	}
}
