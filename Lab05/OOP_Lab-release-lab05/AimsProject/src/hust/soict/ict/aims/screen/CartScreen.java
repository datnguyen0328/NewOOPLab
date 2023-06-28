package hust.soict.ict.aims.screen;

import java.io.IOException;

import javax.naming.LimitExceededException;
import javax.swing.JFrame;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.exception.NegativeException;
import hust.soict.ict.aims.media.Book;
import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.media.Track;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLfxmlLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame{
	private Cart cart;
	
	public CartScreen (Cart cart) {
		super();
		
		this.cart = cart;

		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setVisible(true);
		
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLfxmlLoader fxmlLoader = new FXMLfxmlLoader(getClass().getResource("cart.fxml"));
					CartScreenController controller = new CartScreenController(cart);

					fxmlLoader.setController(controller);
					
					Parent root = fxmlLoader.load();	
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void main(String[] args) {
		Cart cart = new Cart();
		
		try {
			DigitalVideoDisc dvd = new DigitalVideoDisc("Joe mama", "Animation", "Jơe", 100, 20.03f);
			cart.addMedia(dvd);

			Book book = new Book("Little women", "Romantic", 1.2f);
			cart.addMedia(book);

			CompactDisc cd = new CompactDisc("We will rock you", "Rock", 12f, "Journey", "Joe West");
			cart.addMedia(cd);
		} catch (NegativeException e) {
			e.printStackTrace();
		} catch (LimitExceededException e) {
			e.printStackTrace();
		}
		
	    new CartScreen(cart);
	}
}
