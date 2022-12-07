import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
 public class EtudiantRepository {
	void add(Etudiant E) throws SQLException
	{

		DBConnection BD= new DBConnection();
		Connection connect=BD.getConn();
		Connection connect=DBConnection.getInstance().getConn();

		Statement stmt = connect.createStatement();
		String sql = "INSERT into etudiant values (" + E.getMatricule() + ",'" + E.getNom() + "','" + E.getPrenom() + "','" + E.getEmail() + "'," +E.getNbLivreMensuel_Autorise() + "," +E.getNbLivreEmprunte() + "," +E.getId_universite()+")";
  void add(Etudiant E) throws SQLException

	boolean Exists(String email) throws SQLException	
	{
		DBConnection BD= new DBConnection();
		Connection connect=BD.getConn();
		Connection connect=DBConnection.getInstance().getConn();

		Statement stmt = connect.createStatement();
		String sql = "select * from etudiant where email='"+ email+"'";
 boolean Exists(String email) throws SQLException

	boolean Exists(int mat) throws SQLException	
	{
		DBConnection BD= new DBConnection();
		Connection connect=BD.getConn();
		Connection connect=DBConnection.getInstance().getConn();

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