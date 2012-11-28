import java.util.LinkedList;


public class Utilisateur {

	private String surnom;
	private String adresseMail;
	private LinkedList<Utilisateur> listeAmis = new LinkedList<Utilisateur>();;
	private LinkedList<Information> facade = new LinkedList<Information>();;
	private static LinkedList<Utilisateur> allUtilisateurs = new LinkedList<Utilisateur>(); //Pour eviter un nullpointerException au constructeur
	
	//GETTERS & SETTERS
	
	public String getSurnom() {
		return surnom;
	}

	public void setSurnom(String surnom) {
		this.surnom = surnom;
	}

	public String getAdresseMail() {
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	public LinkedList<Utilisateur> getListeAmis() {
		return listeAmis;
	}

	public LinkedList<Information> getFacade() {
		return facade;
	}

	public static LinkedList<Utilisateur> getAllUtilisateurs() {
		return allUtilisateurs;
	}

	
	//METHODES
	
	public Information addInfoFacade(String msg ){
	Information inf = new Information();
	
	inf.setEmetteur(this);
	inf.setMessage(msg);
	inf.setDate(System.currentTimeMillis());
	
	facade.add(inf);
	
	return inf;
	}
	
	public Commentaire addComInfo(String msg, Information inf){
		Commentaire ComAj = new Commentaire();
		
		ComAj.setEmetteur(this);
		ComAj.setMessage(msg);
		ComAj.setReference(inf);
		ComAj.setDate(System.currentTimeMillis());
		
		inf.getEmetteur().facade.add(ComAj);
		
		return ComAj;
		}
	
	
	public static Utilisateur creeUtilisateur(String nom, String mail) throws UtilisateurExistantException{
		if(Utilisateur.allUtilisateurs!=null){
		for(int i = 0; i<Utilisateur.allUtilisateurs.size(); i++){
			if((Utilisateur.allUtilisateurs.get(i).getSurnom().equals(nom)) || (Utilisateur.allUtilisateurs.get(i).getAdresseMail().equals(mail)) ){
				UtilisateurExistantException e = new UtilisateurExistantException();
				throw e;
			}
		}
		}
		Utilisateur util = new Utilisateur(nom, mail);
		allUtilisateurs.add(util);
		return util;
		
	}
	
	private Utilisateur(String nom, String mail) {
		surnom=nom;
		adresseMail=mail;
		allUtilisateurs.add(this);
	}
	
	public boolean estMonAmi(Utilisateur U){
	boolean estAmi = false;
	for(int i = 0; i<listeAmis.size(); i++){
		if(listeAmis.get(i) == U){
			estAmi = true;
		}	
	}
	return estAmi;	
	}
	
	public void afficherFacade(Utilisateur U){
	
	if(this.estMonAmi(U)){
		for(int j = 0; j<U.getFacade().size() && j<5; j++){
			System.out.println(U.getFacade().get(U.getFacade().size()-(j+1)).getMessage()+"\n");	
		}		
	}else{
		System.out.println(U.getSurnom() + "n'est pas votre Ami");
	}
	}
	
	public void afficherDernier(){
		for(int i=0; i<getListeAmis().size(); i++){
			System.out.println(getListeAmis().get(i).getSurnom()+"  a dit  :"+getListeAmis().get(i).getFacade().get(getListeAmis().get(i).getFacade().size()-1).toString()+"\n");
		}
	}
	
	
	public LinkedList<Commentaire> estCommente(Information inf){
		LinkedList<Commentaire> listeDesCommentaire = new LinkedList<Commentaire>(); //s'il n'y a pas de commentaire.. c'est null
		int size = inf.getEmetteur().getFacade().size();
		for(int i=0; i<size; i++){
			if(inf.getEmetteur().getFacade().get(i).getClass().getName()=="Commentaire"){
				Commentaire com = (Commentaire) inf.getEmetteur().getFacade().get(i);
				if(com.getReference()==inf){
					listeDesCommentaire.add(com);		
				}
			}		
		}
		return listeDesCommentaire;
	}
		
		
	public void afficherFile(Information inf, int indice){
		Information infoCourante = inf;
		int cpt = 1;
		if(this.estCommente(infoCourante).size()!=0){
			infoCourante = this.estCommente(infoCourante).get(indice);	
			}
		while(true){
			System.out.println(infoCourante.toString(cpt));
			cpt +=1;
			if(this.estCommente(infoCourante).size()!=0){
			infoCourante = this.estCommente(infoCourante).get(0);	
			}else{
				break;
			}
			
		}			
			
	}
	
	
	public void afficherConversation(Information inf){
		System.out.println(inf.toString());
		for(int i=0; i<this.estCommente(inf).size(); i++){
			this.afficherFile(inf,i);		
		}			
	}
	
	
//	public void afficherConversation(Information inf){
//		System.out.println(inf.toString());
//		Information courant = inf;
//		for(int i=0; i<this.estCommente(inf).size(); i++){
//			if(this.estCommente(courant).size()<2){
//				this.afficherFile(courant,i);	
//			}else{
//				afficherConversation(courant);
//			}					
//		}			
//	}
	
}
