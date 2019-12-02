package competition;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class CopierAction extends AbstractAction{
	private FenetreCreerCompet fenetre;
	
	public CopierAction(FenetreCreerCompet fenetre, String texte){
		super(texte);
 
		this.fenetre = fenetre;
	}
 
	public void actionPerformed(ActionEvent e) { 
		String selected = fenetre.critere1().getSelectedItem().toString();
		fenetre.critere2().addItem(selected);
	} 
}
