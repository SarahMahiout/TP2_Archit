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
	
	
	
	public EtudiantService(InterfEtudiantRep StudRep, InterfUniversiteRep UnivRep, IJournal ij) {
		this.StudRep= StudRep;
		this.UnivRep=UnivRep;
		this.ij=ij;
		

	}
	
	boolean inscription (InterfEtudiant etud) throws SQLException, IOException	
	{
	    ij.outPut_Msg("Log: d�but de l'op�ration d'ajout de l'�tudiant avec matricule "+etud.getMatricule());	    
	    // La verification de la validit� de l'email et matricule se fait � la classe EtudiantRepository
	    if(StudRep.CheckEmailMatricule(etud))
	    	{
	    	return false;
	    	}
	    //le nombre de livres autoriser est calculer danns la classe UniversiteRepository sans ajouter les conditions dans cette classe 
		int nbrLivre=UnivRep.NbrLivreAutoriser(etud.getId_universite());
		etud.setNbLivreMensuel_Autorise(nbrLivre);
		StudRep.add(etud);
		//System.out.println("Log: Fin de l'op�ration d'ajout de l'�tudiant avec matricule "+etud.getMatricule());
		ij.outPut_Msg("Log: Fin de l'op�ration d'ajout de l'�tudiant avec matricule "+etud.getMatricule());
		 
		return true;
	    
		
	}
	
	public void AjoutBonus() throws SQLException, IOException {
		// AjouterNbrBonus retourne le nombre livres bonus  
		
/*  Mise a jour de la fontion AjoutBonus pour quel ajouter le bonus pour tout les etudiant qui sont obtenus par la fonction "GetEtudiantParUniversitye() consid�rer comme pr�d�fini". */
		ArrayList<Etudiant> array= GetEtudiantParUniversitye();
		for( Etudiant et: array) {
			et.AddBonnus(UnivRep.GetNbrBonus(et.getId_universite()));
		}
		
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