package competition;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class SupprimmerAction extends AbstractAction{
	private FenetreCreerCompet fenetre;
	
	public SupprimmerAction(FenetreCreerCompet fenetre, String texte){
		super(texte);
 
		this.fenetre = fenetre;
	}
 
	public void actionPerformed(ActionEvent e) { 
		Object selected = fenetre.critere2().getSelectedItem();
		fenetre.critere2().removeItem(selected);
	} 
}
