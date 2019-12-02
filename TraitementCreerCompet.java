package competition;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class TraitementCreerCompet extends AbstractAction{
	private FenetreCreerCompet fenetre;
	
	public TraitementCreerCompet(FenetreCreerCompet fenetre, String texte) {
		super(texte);
		
		this.fenetre = fenetre;
	}
	
	public void actionPerformed(ActionEvent e) { 
		//Action lors du clic sur le bouton calculer
		String nomCompet = fenetre.nomCompet().getText();
		String jourCompet = fenetre.jourCompet().getSelectedItem().toString();
		String moisCompet = fenetre.moisCompet().getSelectedItem().toString();
		String anneeCompet = fenetre.anneeCompet().getSelectedItem().toString();
		String villeCompet = fenetre.villeCompet().getText();
		
		String dateCompet = jourCompet+"-"+moisCompet+"-"+anneeCompet;
		
		// on crée un objet compet en renseignant nom/date/ville
		Competition compet = new Competition(nomCompet, dateCompet, villeCompet);
//
		System.out.println(compet.nomCompet());
		System.out.println(compet.dateCompet());
		System.out.println(compet.villeCompet());
		
		// on envoie sur la fenetre selection des critères
		fenetre.setContentPane(fenetre.buildConteneurCriteres(compet));
		fenetre.repaint();
		fenetre.revalidate();
	}
}
