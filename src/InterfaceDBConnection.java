
import java.sql.Connection;
import java.sql.SQLException;

public interface InterfaceDBConnection {
	public abstract Connection getConn() throws SQLException;
}
