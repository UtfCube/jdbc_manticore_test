import java.sql.*;
 
public class Check {
    public static void main(String arg[])
    {
        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:9406/mydb");

            try (ResultSet rs = connection.getMetaData().getTables(
                null,
                null,
                "ratings",
                null
            )) {
                final boolean exists = rs.next();
                System.out.println(exists);
            }
            connection.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }
}