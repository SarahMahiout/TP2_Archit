public class MainApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			afficherCompsite jcomp= new afficherCompsite();
			IJournal j1 = new AfiicherMsgDerect();
			IJournal j2 = new AfficherMsgFichier();
			IJournal j3 = new AfficherMsgDateClasse();
			jcomp.ajouter(j1);
			jcomp.ajouter(j2);
			jcomp.ajouter(j3);

		InterfaceDBConnection db=DBConnection.getInstance();
		InterfUniversiteRep UnivRep=new UniversiteRepository(db);
		InterfEtudiantRep StudRep=new EtudiantRepository(db);
		InterfEtudiant etud = new Etudiant(2, "Guendouziiiii", "wassila", "guen@gmail.com","xxxx", 1);
		EtudiantService serv=new EtudiantService(StudRep,UnivRep);

			serv.inscription(etud);

		InterfUniversiteRep UnivRep=new UniversiteRepository(db,jcomp);
		InterfEtudiantRep StudRep=new EtudiantRepository(db,jcomp);
		EtudiantService serv=new EtudiantService(StudRep,UnivRep,jcomp);
		InterfEtudiant etud = new Etudiant(50, "Guendouziiiii", "wassila", "azds@gmail.com","xxxx", 1);
		serv.inscription(etud);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}