package competition;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Fenetre  extends JFrame implements ActionListener{
	private Manager manager;
	
	public Fenetre(Manager manager){
		super();
		build(manager);
	}
	
	private void build(Manager manager) {
		/*
		 * fonction qui construit la fenetre
		 */
		setTitle("Competition");
		setSize(1000, 800);
		setLocationRelativeTo(null); // centrer la fenetre 
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setManager(manager);
	}
	
	public void actionPerformed(ActionEvent e) {
		/*
		 * fonction qui définit l'action effectuée pour un évènement
		 */
	}
	
	public void setManager(Manager man) {
		manager = man;
	}
	public Manager manager() {
		return manager;
	}
}
