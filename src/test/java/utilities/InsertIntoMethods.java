package utilities;

import com.github.javafaker.Faker;
import manage.QueryManage;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class InsertIntoMethods {
    static String query, version, updateLog;
    static int id, rowCount;
    static Date date;
    static PreparedStatement preparedStatement;
    static Faker faker= new Faker();
    static Random random = new Random();
    static QueryManage queryManage = new QueryManage();

    public static int update_logsInsert() throws SQLException {
        query = queryManage.getInsertPreparedQuery08();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        id = faker.number().numberBetween(600,1000);
        version = faker.options().option("Windows 10", "MacOs Ventura", "Linux");
        updateLog = faker.lorem().sentence(1);
        date = java.sql.Date.valueOf(LocalDate.now());

        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, version);
        preparedStatement.setString(3, updateLog);
        preparedStatement.setDate(4, (java.sql.Date) date);
        rowCount = preparedStatement.executeUpdate();

        System.out.println("NEW DATA: " + id + " " + version + " " + updateLog + " " + date);

        return rowCount;
    }

}
