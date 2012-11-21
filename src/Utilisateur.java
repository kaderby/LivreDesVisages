import java.util.LinkedList;


public class Utilisateur {

	public String surnom;
	public String adresseMail;
	public LinkedList<Utilisateur> listeAmis;
	public LinkedList<Information> facade;
	public static LinkedList<Utilisateur> allUtilisateurs;
	
	
	public Information addInfoFacade(String msg ){
	Information inf = new Information();
	
	inf.emetteur=this;
	inf.message=msg;
	inf.date=System.currentTimeMillis();
	
	facade.add(inf);
	
	return inf;
	}
	
	public Information addComInfo(String msg, Information inf){
		Commentaire ComAj = new Commentaire();
		
		ComAj.emetteur=this;
		ComAj.message=msg;
		ComAj.reference=inf;
		ComAj.date=System.currentTimeMillis();
		
		return ComAj;
		}
	
	public Utilisateur(String nom, String mail) throws UtilisateurExistantException{
	boolean ajoutable = true;
	for(int i = 0; i<allUtilisateurs.size(); i++){
		if((allUtilisateurs.get(i).surnom == nom) || (allUtilisateurs.get(i).adresseMail == mail) ){
			ajoutable = false;
		}
	}
	
	if(ajoutable){
		surnom=nom;
		adresseMail=mail;
		allUtilisateurs.add(this);
	}else{
		UtilisateurExistantException e = new UtilisateurExistantException();
		throw e;  	
		}
	}
	
	public void afficherFacade(Utilisateur U){
	boolean estAmi = false;
	for(int i = 0; i<listeAmis.size(); i++){
		if(listeAmis.get(i) == U){
			estAmi = true;
		}	
	}
	if(estAmi){
		for(int j = 0; j<U.facade.size() && j<5; j++){
			System.out.println(U.facade.get(facade.size()-j)+"\n");	
		}		
	}
	}
	
}
