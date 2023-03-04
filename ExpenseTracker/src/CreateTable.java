import java.sql.*;

public class CreateTable {
    static final String URL = "jdbc:hsqldb:hsql://localhost/";

    public static void main(String[] args) {

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            createTable();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static void createTable() throws SQLException {
        Connection conn = DriverManager.getConnection(URL, "SA", "");
        System.out.println("Connected to database!");

        Statement s = conn.createStatement();
        ResultSet result = s.executeQuery("""
                CREATE TABLE expenses
                (
                    id INTEGER PRIMARY KEY,
                    date DATE NOT NULL,
                    amount FLOAT NOT NULL,
                    description VARCHAR(255),
                    category VARCHAR(50)
                )
        """);

        while (result.next()) {
            System.out.println(result.getString("description"));
        }
        conn.close();
    }
}
