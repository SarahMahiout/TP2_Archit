
import java.io.IOException;
import java.sql.SQLException;
public interface InterfUniversiteRep {

	public Universite GetById(int universityId) throws SQLException, IOException;
	public int NbrLivreAutoriser(int universityId) throws SQLException, IOException;


}