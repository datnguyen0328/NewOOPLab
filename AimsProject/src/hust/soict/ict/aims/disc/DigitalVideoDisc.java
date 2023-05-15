package hust.soict.ict.aims.disc;
public class DigitalVideoDisc {
	private int id;
	private static int nbDigitalVideoDiscs = 0;
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public DigitalVideoDisc(String title) {
		id = ++nbDigitalVideoDiscs;
		this.title = title;
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		id = ++nbDigitalVideoDiscs;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		id = ++nbDigitalVideoDiscs;
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "DVD - [ID=" + id + " - title=" + title + " - category=" + category + " - director=" + director
				+ " - length=" + length + " - cost=" + cost + "$]";
	}
}
