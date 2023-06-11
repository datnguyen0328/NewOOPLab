package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	private static int nbDigitalVideoDiscs = 0;
	private int id;
	private String title;
	private String category;
	private float cost;

	public int getId() {
		return id;
	}

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

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public Media(String title) {
		this.id = ++nbDigitalVideoDiscs;
		this.title = title;
	}

	public Media(String title, String category, float cost) {
		this.id = ++nbDigitalVideoDiscs;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", title=" + title + ", category=" + category + ", cost=" + cost + "]";
	}
	
	@Override
	public boolean equals(Object object) {
		if(!(object instanceof Media)) {
			return false;
		}
		
		return this.getTitle().equals(((Media) object).getTitle());
	}
}
