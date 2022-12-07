import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class EtudiantRepository implements InterfEtudiantRep {
	InterfaceDBConnection db;
	private IJournal ij;
	
	
	public EtudiantRepository(InterfaceDBConnection db, IJournal ij) {
		this.db=db;
		this.ij=ij;
	}
	@Override
	public void add(InterfEtudiant E) throws SQLException, IOException {
		// TODO Auto-generated method stub
		Connection connect=db.getConn();
		Statement stmt = connect.createStatement();
		String sql = "INSERT into etudiant values (" + E.getMatricule() + ",'" + E.getNom() + "','" + E.getPrenom() + "','"+ E.getPwd() + "','" + E.getEmail() + "'," +E.getNbLivreMensuel_Autorise() + "," +E.getNbLivreEmprunte() + "," +E.getId_universite()+")";
		int rs = stmt.executeUpdate(sql);
		
		if (rs == 1){
				//System.out.println("log : ajout dans la BD réussi de l'étudiant  du Matricule" + E.getMatricule());
				ij.outPut_Msg("log : ajout dans la BD réussi de l'étudiant  du Matricule" + E.getMatricule());
			}else if (rs == 0){
				//System.out.println("log : Echec de l'ajout dans la BD de l'étudiant  du Matricule" + E.getMatricule());
				ij.outPut_Msg("log : Echec de l'ajout dans la BD de l'étudiant  du Matricule" + E.getMatricule());
			}
		connect.close();
		
	}
	@Override
	public boolean Exists(String email) throws SQLException, IOException {
		// TODO Auto-generated method stub
		Connection connect=db.getConn();
		
		Statement stmt = connect.createStatement();
		String sql = "select * from etudiant where email='"+ email+"'";
		ResultSet rs = stmt.executeQuery(sql);
		
		if(rs.next()){
			//System.out.println("logBD--- :email existe dans la BD  " + email);
			ij.outPut_Msg("logBD--- :email existe dans la BD  " + email);
			connect.close();
			return true;
			}
		//System.out.println("logBD--- : email n'existe pas " + email);
		ij.outPut_Msg("logBD--- : email n'existe pas " + email);
		connect.close();
		return false;
		
		
	}
	@Override
	public boolean Exists(int mat) throws SQLException, IOException {
		// TODO Auto-generated method stub
		
		Connection connect=db.getConn();
		Statement stmt = connect.createStatement();
		String sql = "select * from etudiant where matricule="+ mat;
		ResultSet rs = stmt.executeQuery(sql);
		
		if(rs.next()){
			//System.out.println("logBD--- :etudiant avec ce matricule existe déja dans la BD  " + mat);
			ij.outPut_Msg("logBD--- :etudiant avec ce matricule existe déja dans la BD  " + mat);
			connect.close();
			return true;
			}
		//System.out.println("logBD----: etudiant avec ce matricule n'existe pas " + mat);
		ij.outPut_Msg("logBD----: etudiant avec ce matricule n'existe pas " + mat);
		connect.close();
		return false;
	}
	@Override
	public boolean CheckEmailMatricule(InterfEtudiant etud) throws SQLException, IOException {
		// TODO Auto-generated method stub
		return Exists(etud.getMatricule())|| Exists(etud.getEmail()) || etud.getEmail()== null || etud.getEmail().length() == 0;
	}



	
}