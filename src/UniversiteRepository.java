import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class UniversiteRepository implements InterfUniversiteRep {
	InterfaceDBConnection db;
	private IJournal ij;
	
	public UniversiteRepository(InterfaceDBConnection db, IJournal ij) {
		this.db=db;
		this.ij=ij;
	}
	@Override
	public Universite GetById(int universityId) throws SQLException, IOException {
		
		Connection connect=db.getConn();
		Statement stmt = connect.createStatement();
		//System.out.println("LogBD : début recherche de id université dans la base de donnée");
		ij.outPut_Msg("LogBD : début recherche de id université dans la base de donnée");
		String sql = "select * from universite where id_universite="+ universityId;
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();	
		TypePackage p=TypePackage.valueOf(rs.getString(3));
		Universite u = new Universite (rs.getInt(1),rs.getString(2),p);
		//System.out.println("LogBD : université récupérée");
		ij.outPut_Msg("LogBD : université récupérée");
		connect.close();
		return u;	


	}


	@Override
	public int NbrLivreAutoriser(int universityId) throws SQLException, IOException {
		// TODO Auto-generated method stub
		Universite univ=this.GetById(universityId);
		if (univ.getPack() == TypePackage.Standard)
	     {
	          return 10;
	     }
	     else if (univ.getPack() == TypePackage.Premium)
	     {
	    	 return 20;
	     }     
		return 0;
	}

	@Override
	public int GetNbrBonus(int universityId) throws SQLException, IOException {
		// TODO Auto-generated method stub
		Universite univ=this.GetById(universityId);
		if (univ.getPack() == TypePackage.Standard)
	     {
	          return 5;
	     }
	     else if (univ.getPack() == TypePackage.Premium)
	     {
	    	 return 10;
	     }     
		return 0;
	}

	
}