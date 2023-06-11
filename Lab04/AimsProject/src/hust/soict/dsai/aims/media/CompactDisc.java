package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	private String artist; 
	private ArrayList<Track> tracks = new ArrayList<>();
	
	public String getArtist() {
		return artist;
	}
	
	public CompactDisc(String title, String category, String director, int length, float cost, String artist, ArrayList<Track> tracks) {
		super(title, category, director, length, cost);
		this.artist = artist;
		this.tracks = tracks;
	}
	
	public void addTrack(Track track) {
		if(tracks.contains(track)) {
			System.out.println("Already exist.");
		}else {
			tracks.add(track);
		}
	}
	
	public void removeTrack(Track track) {
		if(tracks.contains(track)) {
			tracks.remove(track);
		}else {
			System.out.println("Not exist.");
		}
	}
	
	public int getLength() {
		int sumLength = 0;
		for(Track track : tracks) {
			sumLength += track.getLength();
		}
		return sumLength;
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		for(Track track : tracks) {
			System.out.println(track.getTitle());
		}
	}

	@Override
	public String toString() {
		return super.toString() + "[artist=" + artist + ", tracks=" + tracks + "]";
	}
}
