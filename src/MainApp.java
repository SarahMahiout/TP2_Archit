import java.sql.SQLException;


public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		EtudiantService serv=new EtudiantService();
		try {
			serv.inscription(2, "Guendouziiiii", "wassila", "guen@gmail.com","xxxx", 1);
		InterfaceDBConnection db=DBConnection.getInstance();
		InterfUniversiteRep UnivRep=new UniversiteRepository(db);
		InterfEtudiantRep StudRep=new EtudiantRepository(db);
		InterfEtudiant etud = new Etudiant(2, "Guendouziiiii", "wassila", "guen@gmail.com","xxxx", 1);
		EtudiantService serv=new EtudiantService(StudRep,UnivRep);

			serv.inscription(etud);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}