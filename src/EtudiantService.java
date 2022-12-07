import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class EtudiantService {
	private InterfEtudiantRep StudRep;
	private InterfUniversiteRep UnivRep;


	boolean inscription (int matricule, String nom, String prénom, String email,String pwd, int id_universite) throws SQLException	

	public EtudiantService(InterfEtudiantRep StudRep, InterfUniversiteRep UnivRep) {
		this.StudRep= StudRep;
		this.UnivRep=UnivRep;
	}

	boolean inscription (InterfEtudiant etud) throws SQLException	
	{
		EtudiantRepository StudRep= new EtudiantRepository();
	    UniversiteRepository UnivRep= new UniversiteRepository();
	    Etudiant stud = new Etudiant(matricule, nom, prénom, email,pwd,id_universite);
	    Universite univ=UnivRep.GetById(id_universite);



	    Universite univ=UnivRep.GetById(etud.getId_universite());

	    System.out.println("Log: début de l'opération d'ajout de l'étudiant avec matricule "+matricule);
	    System.out.println("Log: début de l'opération d'ajout de l'étudiant avec matricule "+etud.getMatricule());

	    if(email == null || email.length() == 0)
	    if(etud.getEmail() == null || etud.getEmail().length() == 0)
	    {
	    	return false;
	    }

	    if (StudRep.Exists(matricule))
	    if (StudRep.Exists(etud.getMatricule()))
	    {
	        return false;
	    }

		if (StudRep.Exists(email))
		if (StudRep.Exists(etud.getEmail()))
	    {
	        return false;
	    }
		
		

		 if (univ.getPack() == TypePackage.Standard)
	     {
	          stud.setNbLivreMensuel_Autorise(10);
	          etud.setNbLivreMensuel_Autorise(10);
	     }
	     else if (univ.getPack() == TypePackage.Premium)
	     {
	    	 stud.setNbLivreMensuel_Autorise(10*2);
	    	 etud.setNbLivreMensuel_Autorise(10*2);
	     }                           

		 StudRep.add(stud);
		 System.out.println("Log: Fin de l'opération d'ajout de l'étudiant avec matricule "+matricule);
		 StudRep.add(etud);
		 System.out.println("Log: Fin de l'opération d'ajout de l'étudiant avec matricule "+etud.getMatricule());
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