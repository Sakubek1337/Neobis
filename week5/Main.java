import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring", "root",
                "password");
        Statement statement = connection.createStatement();
        String query = "INSERT INTO countries(id, name) VALUES(1, 'KYRGYZSTAN');";
        statement.executeUpdate(query);
        query = "INSERT INTO countries(id, name) VALUES(2, 'NORWAY');";
        statement.executeUpdate(query);
        query = "SELECT * FROM countries;";
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
    }
}
