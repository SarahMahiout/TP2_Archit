import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class EtudiantService {
	private InterfEtudiantRep StudRep;
	private InterfUniversiteRep UnivRep;
	private IJournal ij;



	public EtudiantService(InterfEtudiantRep StudRep, InterfUniversiteRep UnivRep) {
	public EtudiantService(InterfEtudiantRep StudRep, InterfUniversiteRep UnivRep, IJournal ij) {
		this.StudRep= StudRep;
		this.UnivRep=UnivRep;
		this.ij=ij;


	}

	boolean inscription (InterfEtudiant etud) throws SQLException	
	boolean inscription (InterfEtudiant etud) throws SQLException, IOException	
	{



	    Universite univ=UnivRep.GetById(etud.getId_universite());

	    System.out.println("Log: début de l'opération d'ajout de l'étudiant avec matricule "+etud.getMatricule());
	    //System.out.println("Log: début de l'opération d'ajout de l'étudiant avec matricule "+etud.getMatricule());
	    ij.outPut_Msg("Log: début de l'opération d'ajout de l'étudiant avec matricule "+etud.getMatricule());

	    if(etud.getEmail() == null || etud.getEmail().length() == 0)
	    {
 else if (univ.getPack() == TypePackage.Premium)
	     }                           

		 StudRep.add(etud);
		 System.out.println("Log: Fin de l'opération d'ajout de l'étudiant avec matricule "+etud.getMatricule());
		 //System.out.println("Log: Fin de l'opération d'ajout de l'étudiant avec matricule "+etud.getMatricule());
		 ij.outPut_Msg("Log: Fin de l'opération d'ajout de l'étudiant avec matricule "+etud.getMatricule());

		 return true;


	}
	
	
	
public ArrayList<Etudiant> GetEtudiantParUniversitye()
{
    //...
	return new ArrayList<>(4);
}
public ArrayList<Etudiant> GetEtudiatparLivreEmprunte()
{
    //...
	return new ArrayList<>(4);
	
}
	
}