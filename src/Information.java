
public class Information {

	private Utilisateur emetteur;
	private String message;
	private long date;
	
	
	//GETTERS & SETTERS
	public Utilisateur getEmetteur() {
		return emetteur;
	}

	public void setEmetteur(Utilisateur emetteur) {
		this.emetteur = emetteur;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}	
	
	
	//METHODES
	public String toString(){		
		return (emetteur.getSurnom()+"  :  "+message);
	}
	
	public String toString(int cpt){
		String tirets = "";
		for(int i=0; i<cpt; i++){
			tirets = tirets+"-";
		}
		return(tirets+this.toString());
	}
}
