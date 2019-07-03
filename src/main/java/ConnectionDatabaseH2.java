import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDatabaseH2 {
	
	Connection cn;
	Statement st;
	ResultSet rs;
	
	public ConnectionDatabaseH2() {
		try {
			Class.forName("org.h2.Driver");
			cn = DriverManager.getConnection("jdbc:h2:lib//database","sa","");
			st = cn.createStatement();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void teste() {
		
		try {
			rs = st.executeQuery("SELECT * FROM projeto.usuarios");
			while(rs.next()){
				System.out.println("ID:" + rs.getInt("id") + "\t" 
						+ "Nome:" + rs.getString("nome") + "\t"
						+ "CPF:" + rs.getString("cpf"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
