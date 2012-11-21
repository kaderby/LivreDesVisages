
public class Commentaire extends Information{
	
	public Information reference; 
	
	public String toString(){		
		return (emetteur.toString()+"a écrit"+message+"en réponse à"+reference.emetteur.toString());
	}
}
