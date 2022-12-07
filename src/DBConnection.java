import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
public class DBConnection implements InterfaceDBConnection {

		String BDD = "nomBD";
		String url = "jdbc:mysql://localhost:3306/" + BDD;
		String user = "root";
		String passwd = "";
	    private Connection conn;
	    private static DBConnection instance;
	   
	    public DBConnection() throws SQLException {
			conn=DriverManager.getConnection(url, user,passwd);
		}
	    
	    public static DBConnection getInstance() throws SQLException {
	    	if (instance==null)
	    		instance=new DBConnection();
	    	else if (instance.getConn().isClosed()) {
	            instance = new DBConnection();
	        }
	    	return instance;

	    }


	    public Connection getConn() throws SQLException {
	    	if(conn.isClosed())
		@Override
		public Connection getConn() throws SQLException {
			// TODO Auto-generated method stub
			if(conn.isClosed())
				conn=DriverManager.getConnection(url, user,passwd);

			return conn;

		}







}