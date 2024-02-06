import java.sql.DriverManager;
import java.sql.SQLException;

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
        DriverManager.getConnection("jdbc:mysql://45.87.83.5/u168183796_qaloantec",
                                        "u168183796_qaloantecuser",
                                        "0&vG1A/MuWN");
    }
}
