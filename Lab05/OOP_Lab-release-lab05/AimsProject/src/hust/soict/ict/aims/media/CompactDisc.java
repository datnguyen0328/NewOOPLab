package hust.soict.ict.aims.media;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.Track;
import hust.soict.ict.aims.exception.AlreadyExistedException;
import hust.soict.ict.aims.exception.NegativeException;
import hust.soict.ict.aims.exception.NotExistedException;
import hust.soict.ict.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<>();

	public CompactDisc(int id, String title, String category, float cost, String director, String artist,
			ArrayList<Track> tracks)  throws NegativeException {
		super(id, title, category, cost, director);
		this.artist = artist;
		this.tracks = tracks;
	}

	public CompactDisc(int id, String title, String category, float cost, String director, String artist, ArrayList<Track> tracks) throws NegativeException {
		super(id, title, category, cost, director);
		this.tracks = tracks;
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}

	public void addTrack(Track track)  throws AlreadyExistedException {
		if (!tracks.contains(track)) {
			tracks.add(track);
			System.out.println("Track has been added!");
		} else{
			throw new AlreadyExistedException("Track exists, cannot add");
		}
	}

	public void removeTrack(Track track) throws NotExistedException {
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("Track removed!");
		} else{
			throw new NotExistedException("Track not found");
		}
	}

	@Override
	public int getLength() {
		int totalLength = 0;
		for (Track track : tracks)
			totalLength += track.getLength();
		return totalLength;
	}

	public String toString() {
		return "CD: id: " + this.getId() + " - " + this.getTitle() + " - " + this.getCategory() + " - "
				+ this.getDirector() + " - " + this.getArtist() + " - " + this.getLength() + " - $" + this.getCost();
	}

	@Override
	public void play()  throws PlayerException {
		System.out.println("The CD has " + tracks.size() + " tracks");
		if(this.getLength() > 0){
			for (Track track : tracks)
			try{
				track.play();
			}catch(PlayerException e){
				e.printStackTrace();
			}
		}else {
			throw new PlayerException("CD has 0 tracks");
		}
	}
}
