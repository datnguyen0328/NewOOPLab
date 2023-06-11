package hust.soict.ict.test.disc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.wrapper.DVDWrapper;

public class TestPassingParameter {
	public static void swap(DVDWrapper dw1, DVDWrapper dw2) {
		DigitalVideoDisc temp = dw1.dvd;
		dw1.dvd = dw2.dvd;
		dw2.dvd = temp;
	}
	
	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		DVDWrapper dw1 = new DVDWrapper(jungleDVD);
		DVDWrapper dw2 = new DVDWrapper(cinderellaDVD);

		swap(dw1, dw2);

		System.out.println("jungle dvd title: " + dw1.dvd.getTitle());
		System.out.println("cinderella dvd title: " + dw2.dvd.getTitle());
	}
}
