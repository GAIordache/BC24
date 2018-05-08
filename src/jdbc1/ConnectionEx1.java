package jdbc1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ConnectionEx1 {

	public static void main(String[] args) throws Exception {
		//Class.forName ("org.h2.Driver"); 
		//String jdbcURL = "jdbc:h2:tcp://localhost/~/test";
		String jdbcURL = "jdbc:h2:D:\\dbeaver\\db\\curs";
		// String jdbcURLPostgresql = jdbc:postgresql://host:port/database
		String userName = "xx";
		String userPasswd = "xx";
		
		// DE ACI NU MAI STIU CE BAZA E
		Connection conn = DriverManager.getConnection(jdbcURL, userName, userPasswd); 
		DatabaseMetaData md = conn.getMetaData();
		System.out.println(md.getDatabaseProductName());
		ResultSet tbls = md.getTables(null, "PUBLIC", null, null);
		ResultSetMetaData rsMeta = tbls.getMetaData(); 
		while(tbls.next()) {
			for(int i=1;i <= rsMeta.getColumnCount();i++) {
				System.out.print(rsMeta.getColumnLabel(i) + ":" + tbls.getObject(i) + "\t");
			}
			System.out.println();
		}
	}

}
