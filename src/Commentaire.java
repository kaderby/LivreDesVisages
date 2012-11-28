
public class Commentaire extends Information{
	
	private Information reference; 
	
	
	//GETTERS & SETTERS
	public Information getReference() {
		return reference;
	}

	public void setReference(Information reference) {
		this.reference = reference;
	}
	
	//METHODES
	public String toString(){		
		return (super.toString()+"  TO:  "+reference.getEmetteur().getSurnom());
	}
	
}
