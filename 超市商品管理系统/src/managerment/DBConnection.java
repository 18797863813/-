package managerment;
import java.sql.*;
public class DBConnection {

    String driver = "com.mysql.cj.jdbc.Driver";
    String url= "jdbc:mysql://localhost:3306/goods?useSSL=false&serverTimezone=UTC";
    String user = "root";
    String password = "root";
    Connection con;
	Statement sql;
	public PreparedStatement presql;
	public ResultSet rs;
    public Connection conn;

    public DBConnection() {

        try {
            Class.forName(driver);// ������������
           
        } catch (Exception e) {
        }
        try{
        	 conn = (Connection) DriverManager.getConnection(url, user, password);// �������ݿ� 
        }catch(SQLException e){
        	
        }
    }
    
    public void close() {
        try {
            this.conn.close();
        } catch (Exception e) {
        }
    }
}