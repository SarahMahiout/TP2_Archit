
public class MainAppMvc {

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
		InterfUniversiteRep UnivRep=new UniversiteRepository(db,jcomp);
		InterfEtudiantRep StudRep=new EtudiantRepository(db,jcomp);
		EtudiantService serv=new EtudiantService(StudRep,UnivRep,jcomp);
		
		AbstractViewInscription viewInscription= new ViewInscription();
		
		viewInscription.Show_Inscription();
		ControleurInscription ContInscription=new ControleurInscription(viewInscription,serv);
		viewInscription.addObserver(ContInscription);
		viewInscription.addListnerButton();
		
		
		
		
		
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}