package competition;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FenetreCreerCompet fenetre = new FenetreCreerCompet(new Manager());
				fenetre.setVisible(true);
			}
		});
	}

}
