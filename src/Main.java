
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			//Intialisation
			Utilisateur Man = Utilisateur.creeUtilisateur("Man","man@ec-nantes.fr");
			//System.out.println(Man.surnom);
			Utilisateur Miss = Utilisateur.creeUtilisateur("Miss","miss@ec-nantes.fr");
			//System.out.println(Miss.surnom);
			Utilisateur Flane = Utilisateur.creeUtilisateur("Flane","Flane@ec-nantes.fr");
			//System.out.println(Miss.surnom);

			
			//Liens d'amitié
			Man.getListeAmis().add(Miss);
			Miss.getListeAmis().add(Man);
			
			Man.getListeAmis().add(Flane);
			Flane.getListeAmis().add(Man);
			
			Flane.getListeAmis().add(Miss);
			Miss.getListeAmis().add(Flane);
			
			
//			Man.addInfoFacade("I am very happy today2");
//			Man.addInfoFacade("I am very happy today3");
//			Man.addInfoFacade("I am very happy today4");
//			Man.addInfoFacade("I am very happy today5");
//			Man.addInfoFacade("I am very happy today6");
//			Man.addInfoFacade("I am very happy today7");
			
//			Miss.addInfoFacade("I am very happy today1");
//			Miss.addInfoFacade("I am very happy today2");
//			Miss.addInfoFacade("I am very happy today3");
//			Miss.addInfoFacade("I am very happy today4");
			
//			Miss.afficherFacade(Man);
//			Miss.afficherDernier();
//			Man.afficherDernier();
			
			Information A = Man.addInfoFacade("je suis debout");
			
			Information B = Miss.addComInfo("bonne journée", A);
			Information Bbis = Man.addComInfo("merci", B);
			Flane.addComInfo("quelle politesse", Bbis);
			
			Information C = Flane.addComInfo("c'est très interessant", A);
			Information D = Man.addComInfo("pas obligé de me lire", C);
			Information Dbis = Miss.addComInfo("de quoi il se mele ?", D);
			
			//Miss.afficherFile(A,1);
			Miss.afficherConversation(A);
		
			
			//System.out.println(Man.facade.get(1).message);
			
			
		} catch (UtilisateurExistantException e) {
			//e.printStackTrace();
			System.out.println("ERROR: Cet utilisateur existe deja !!");
		}

	}

}
