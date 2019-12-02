package competition;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class TraitementCriteres extends AbstractAction{
	private FenetreCreerCompet fenetre;
	private Competition compet;
	
	public TraitementCriteres(FenetreCreerCompet fenetre, String texte, Competition compet) {
		super(texte);
		
		this.fenetre = fenetre;
		this.compet = compet;
	}
	
	public void actionPerformed(ActionEvent e) { 
		//Action lors du clic sur le bouton calculer
		
		// on récupère les critères
//		String critere2 = fenetre.critere2().getSelectedItem().toString();

		// on récupère les nombre d'items 		
		int taille = fenetre.critere2().getItemCount();
		String[] listCrit = new String[taille];
		
		// on fait une boucle qui récupère tous les items avec fenetre.critere2().getItemAt(index) et les met dans un tableau
		for(int i=0; i<taille; i++) {
			listCrit[i] = fenetre.critere2().getItemAt(i).toString();
		}
		
		// on les ajoute à l'objet compet
		compet.setListCriteres(listCrit);
		
		System.out.println(compet.nomCompet());
		System.out.println(compet.dateCompet());
		System.out.println(compet.villeCompet());
		for(int i=0; i<compet.listCritere().length; i++)
			System.out.println(compet.listCritere()[i]);
		
		// on envoie sur la fenetre selection des critères
	}
}
