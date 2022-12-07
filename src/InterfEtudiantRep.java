import java.io.IOException;
import java.sql.SQLException;
public interface InterfEtudiantRep {
	
	public void add(InterfEtudiant etud) throws SQLException, IOException;
	public boolean Exists(String email) throws SQLException, IOException;
	public boolean Exists(int mat) throws SQLException, IOException;
	public boolean CheckEmailMatricule(InterfEtudiant etud) throws SQLException, IOException;



}