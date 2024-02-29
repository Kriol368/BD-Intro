import java.sql.SQLException;
import java.sql.*;

public class Main {
    private static java.sql.Connection con;

    public static void main(String[] args) throws SQLException {
        String host = "jdbc:sqlite:src/main/resources/network";
        con = java.sql.DriverManager.getConnection(host);
        //crearTable();
        leerUsuarios();
    }

    private static void crearTable() throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate("CREATE TABLE T1 (c1 VARCHAR (50))");
    }

    private static void leerUsuarios() throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM usuarios");
        while (rs.next()) {
            System.out.println("ID:" + rs.getInt(1) + "\n" + "NAME: " + rs.getString(2) + "\n" + "LASTNAME: " + rs.getString(3));
        }
    }
}
