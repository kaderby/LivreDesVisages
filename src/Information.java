
public class Information {

	public Utilisateur emetteur;
	public String message;
	public long date;
	
	public String toString(){		
		return (emetteur.toString()+"a écrit"+message);
	}
	
}
