
public class Commentaire extends Information{
	
	public Information reference; 
	
	public String toString(){		
		return (emetteur.toString()+"a �crit"+message+"en r�ponse �"+reference.emetteur.toString());
	}
}
