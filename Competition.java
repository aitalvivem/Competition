package competition;

public class Competition {
	private String nomCompet;
	private String dateCompet;
	private String villeCompet;
	private int codeFormat;
	private int codeTypeRound;
	private int codeTypeCompet;
	private String[] listCriteres;
	// liste participants
	
	public Competition(String nomCompet, String dateCompet, String villeCompet) {
		setNomCompet(nomCompet);
		setDateCompet(dateCompet);
		setVilleCompet(villeCompet);
	}
	
	//mutateurs
	public void setNomCompet(String nomCompet) {
		this.nomCompet = nomCompet;
	}
	public void setDateCompet(String dateCompet) {
		this.dateCompet = dateCompet;
	}
	public void setVilleCompet(String villeCompet) {
		this.villeCompet = villeCompet;
	}
	public void setCodeFormat(int codeFormat) {
		this.codeFormat = codeFormat;
	}
	public void setCodeTypeRound(int codeTypeRound) {
		this.codeTypeRound = codeTypeRound;
	}
	public void setCodeTypeCompet(int codeTypeCompet) {
		this.codeTypeCompet = codeTypeCompet;
	}
	public void setListCriteres(String[] list) {
		this.listCriteres = list;
	}
	
	// accesseurs
	public String nomCompet() {
		return this.nomCompet;
	}
	public String dateCompet() {
		return this.dateCompet;
	}
	public String villeCompet() {
		return this.villeCompet;
	}
	public int codeFormat() {
		return this.codeFormat;
	}
	public int codeTypeRound() {
		return this.codeTypeRound;
	}
	public int codeTypeCompet() {
		return this.codeTypeCompet;
	}
	public String[] listCritere(){
		return this.listCriteres;
	}
	
}
