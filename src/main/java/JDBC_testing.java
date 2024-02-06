import java.sql.*;

public class JDBC_testing {
/*
    type: jdbc:mysql
    host/ip: 45.87.83.5
    port: 3306
    database_name: u168183796_qaloantec
    username: u168183796_qaloantecuser
    password: 0&vG1A/MuWN
        url = jdbc:mysql://45.87.83.5/u168183796_qaloantec
        username: u168183796_qaloantecuser
        password: 0&vG1A/MuWN
*/
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1- ADD THE CORRECT DRIVER.
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2- INITIATE THE CONNECTION WITH THE DATABASE.
        Connection connection = DriverManager.getConnection("jdbc:mysql://45.87.83.5/u168183796_qaloantec",
                                                                "u168183796_qaloantecuser",
                                                                "0&vG1A/MuWN");

        // 3- CREATE and EXECUTE SQL STATEMENTS.
        String query = "SELECT * FROM u168183796_qaloantec.users";
        Statement statement =connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        // To create a statement, there must be a connection.
        // The created statement can be used for executing a query without assignment.
        // However, if it is intended to be used multiple times, it can be assigned and reused.

        // 4- EXECUTE QUERY.
        ResultSet resultSet = statement.executeQuery(query);

/*
        -statement.executeQuery(query);
                     AND
        -connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
               have the same usage.
*/

        // 5- PROCESS RESULTS.
        resultSet.next();
        System.out.println(resultSet.getString(2));

        //Print the data in the next row.
        resultSet.next();
        System.out.println(resultSet.getString(2));

        //Print the data in the next column of the same row "lastname".
        System.out.println(resultSet.getString("lastname"));

        //Print the data in the 10th row for "firstname".
        resultSet.absolute(10);
        System.out.println( resultSet.getString("firstname"));

        //Print the first data for "email"
        resultSet.first();
        resultSet.getString("email");
    }
}
