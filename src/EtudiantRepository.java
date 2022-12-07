import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EtudiantRepository {

public class EtudiantRepository implements InterfEtudiantRep {
	InterfaceDBConnection db;

	void add(Etudiant E) throws SQLException
	{

		Connection connect=DBConnection.getInstance().getConn();
	public EtudiantRepository(InterfaceDBConnection db) {
		this.db=db;

	}

	@Override
	public void add(InterfEtudiant E) throws SQLException {
		// TODO Auto-generated method stub
		Connection connect=db.getConn();
		Statement stmt = connect.createStatement();
		String sql = "INSERT into etudiant values (" + E.getMatricule() + ",'" + E.getNom() + "','" + E.getPrenom() + "','" + E.getEmail() + "'," +E.getNbLivreMensuel_Autorise() + "," +E.getNbLivreEmprunte() + "," +E.getId_universite()+")";
		int rs = stmt.executeUpdate(sql);
		
		if (rs == 1){
				System.out.println("log : ajout dans la BD réussi de l'étudiant  du Matricule" + E.getMatricule());
			}else if (rs == 0){
				System.out.println("log : Echec de l'ajout dans la BD de l'étudiant  du Matricule" + E.getMatricule());
			}
		connect.close();
	 }

		
	}

	boolean Exists(String email) throws SQLException	
	{
		Connection connect=DBConnection.getInstance().getConn();
	@Override
	public boolean Exists(String email) throws SQLException {
		// TODO Auto-generated method stub
		Connection connect=db.getConn();

		Statement stmt = connect.createStatement();
		String sql = "select * from etudiant where email='"+ email+"'";
		boolean rs = stmt.execute(sql);
		
		if (rs){
			System.out.println("logBD--- :email existe dans la BD  " + email);
			connect.close();
			return true;
			}
		System.out.println("logBD--- : email n'existe pas " + email);	
		connect.close();
		return false;

	}

	boolean Exists(int mat) throws SQLException	
	{
		Connection connect=DBConnection.getInstance().getConn();

	@Override
	public boolean Exists(int mat) throws SQLException {
		// TODO Auto-generated method stub

		Connection connect=db.getConn();

		Statement stmt = connect.createStatement();
		String sql = "select * from etudiant where matricule="+ mat;
		boolean rs = stmt.execute(sql);
		
		if (rs){
			System.out.println("logBD--- :etudiant avec ce matricule existe déja dans la BD  " + mat);
			connect.close();
			return true;
			}
		System.out.println("logBD----: etudiant avec ce matricule n'existe pas " + mat);	
		connect.close();
		return false;
	}








}