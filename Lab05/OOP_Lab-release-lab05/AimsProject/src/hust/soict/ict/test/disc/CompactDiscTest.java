package hust.soict.ict.test.disc;

import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.media.Track;

public class CompactDiscTest {

	public static void main(String[] args) {
		CompactDisc cd = new CompactDisc(1, "Come and get your love", "R&B", 123f, "IDK", "Peter Quill");
		cd.addTrack(new Track("track1", 1));
		cd.addTrack(new Track("track2", 2));
		
		System.out.println(cd.toString());
	}

}
