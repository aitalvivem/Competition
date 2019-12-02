package competition;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class FenetreCreerCompet extends Fenetre{
	private JTextField nomCompet;
	private JComboBox<String> jourCompet;
	private JComboBox<String> moisCompet;
	private JComboBox<String> anneeCompet;
	private JTextField villeCompet;
	private JComboBox<String> critere1;
	private JComboBox<String> critere2;
	
	public FenetreCreerCompet(Manager manager) {
		super(manager);
		build();
	}
	
	private void build() {
		/*
		 * ce qui s'ajoute au constructeur parent
		 */
		setContentPane(buildConteneur());
	}
	
	private JPanel buildConteneur() {
		JPanel panneau = new JPanel();
		panneau.setBackground(Color.white);
		
		JLabel label1 = new JLabel("Créer une compétition");
		JLabel label2 = new JLabel("Nom de la compétition");
		JLabel label3 = new JLabel("Date de la compétition");
		JLabel label4 = new JLabel("Ville de la compétition");
		
		nomCompet = new JTextField();
		nomCompet.setColumns(20);
		
		JPanel dateCompet = buildDateCompet();
		
		villeCompet = new JTextField();
		villeCompet.setColumns(20);
		
		JButton bouton = new JButton(new TraitementCreerCompet(this, "Créer la compétition"));
		bouton.addActionListener(this);
		
		GroupLayout dispo = new GroupLayout(panneau);
		panneau.setLayout(dispo);
		
		dispo.setAutoCreateContainerGaps(true);
		dispo.setAutoCreateGaps(true);
		
		dispo.setHorizontalGroup(
				dispo.createSequentialGroup()
				.addGroup(
						dispo.createParallelGroup()
						.addComponent(label2)
						.addComponent(label3)
						.addComponent(label4)
				)
				.addGroup(
						dispo.createParallelGroup()
						.addComponent(label1)
						.addComponent(nomCompet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(dateCompet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE) 
						.addComponent(villeCompet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				)
				.addComponent(bouton)
		);
		
		dispo.setVerticalGroup(
				dispo.createSequentialGroup()
				.addComponent(label1)
				.addGroup(
						dispo.createParallelGroup()
						.addComponent(label2)
						.addComponent(nomCompet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				)
				.addGroup(
						dispo.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(label3)
						.addComponent(dateCompet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				)
				.addGroup(
						dispo.createParallelGroup()
						.addComponent(label4)
						.addComponent(villeCompet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				)
				.addComponent(bouton)
		);
		
		return panneau;
	}
	
	private JPanel buildDateCompet() {
		JPanel panneau = new JPanel();
		panneau.setBackground(Color.white);
		
		jourCompet = new JComboBox<String>();
		for(int i=1; i<10;i++) {
			String jour = "0"+Integer.toString(i);
			jourCompet.addItem(jour);
		}
		for(int i=10; i<=31;i++) {
			String jour = Integer.toString(i);
			jourCompet.addItem(jour);
		}
		
		moisCompet = new JComboBox<String>();
		for(int i=1; i<10;i++) {
			String mois = "0"+Integer.toString(i);
			moisCompet.addItem(mois);
		}
		for(int i=10; i<=12;i++) {
			String mois = Integer.toString(i);
			moisCompet.addItem(mois);
		}
		
		anneeCompet = new JComboBox<String>();
		for(int i=2019; i<=2100;i++) {
			String annee = Integer.toString(i);
			anneeCompet.addItem(annee);
		}
		
		JLabel sep = new JLabel(" / ");
		JLabel sep2 = new JLabel(" / ");
		JLabel label = new JLabel("(format : JJ-MM-AAA)");
		
		// on construit le layout
		GroupLayout dispo = new GroupLayout(panneau);
		panneau.setLayout(dispo);
		
		dispo.setAutoCreateContainerGaps(true);
		dispo.setAutoCreateGaps(true);
		
		dispo.setHorizontalGroup(
				dispo.createSequentialGroup()
				.addComponent(jourCompet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addComponent(sep)
				.addComponent(moisCompet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addComponent(sep2)
				.addComponent(anneeCompet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addComponent(label)
		);
		
		dispo.setVerticalGroup(
				dispo.createParallelGroup()
				.addComponent(jourCompet)
				.addComponent(sep)
				.addComponent(moisCompet)
				.addComponent(sep2)
				.addComponent(anneeCompet)
				.addComponent(label)
		);
		
		return panneau;
	}
	
	public JPanel buildConteneurCriteres(Competition compet) {
		JPanel panneau = new JPanel();
		panneau.setLayout(new FlowLayout());
		panneau.setBackground(Color.white);
		
		JLabel label1 = new JLabel("Séléctionner les critères à utiliser pour cette compétition");
		panneau.add(label1);
		
		// on affiche 2 liste, une avec les critères existants un avec les critères sélectionnés
		// on récupère la liste des critères existants grâce au manager
		String[] listCriteres = super.manager().getListCriteres();
		critere1 = new JComboBox<String>(listCriteres);
		panneau.add(critere1);
		
		// un bouton selectionner 
		JButton selectionner = new JButton(new CopierAction(this, "Séléctionner"));
		selectionner.addActionListener(this);
		panneau.add(selectionner);
		
		// la liste vide
		critere2 = new JComboBox<String>();
		panneau.add(critere2);
		
		// un bouton supprimmer 
		JButton supprimmer = new JButton(new SupprimmerAction(this, "Supprimmer"));
		supprimmer.addActionListener(this);
		panneau.add(supprimmer);
		
		JButton confirmer = new JButton(new TraitementCriteres(this, "Confirmer les critères", compet));
		confirmer.addActionListener(this);
		panneau.add(confirmer);
		
		return panneau;
	}
	
	public void actionPerformed(ActionEvent e) {
		/*
		 * fonction qui définit l'action effectuée pour un évènement
		 */
	}
	
	public JTextField nomCompet() {
		return nomCompet;
	}
	public JTextField villeCompet() {
		return villeCompet;
	}
	public JComboBox<String> jourCompet() {
		return jourCompet;
	}
	public JComboBox<String> moisCompet() {
		return moisCompet;
	}
	public JComboBox<String> anneeCompet() {
		return anneeCompet;
	}
	public JComboBox<String> critere1() {
		return critere1;
	}
	public JComboBox<String> critere2() {
		return critere2;
	}
}
