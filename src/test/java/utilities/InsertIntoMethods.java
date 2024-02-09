package utilities;

import com.github.javafaker.Faker;
import manage.QueryManage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class InsertIntoMethods {
    static String query, version, updateLog, email, token;
    static int id, rowCount, status;
    static Date date;
    static PreparedStatement preparedStatement;
    static Faker faker= new Faker();
    static Random random = new Random();
    static QueryManage queryManage = new QueryManage();
    static ResultSet resultSet;

    public static int idGenerator(String givenQuery) throws SQLException {
        resultSet = JDBCReusableMethods.getStatement().executeQuery(givenQuery);

        List<Integer> ids = new ArrayList<>();
        while (resultSet.next()){
            ids.add(resultSet.getInt("id"));
        }

        id = random.nextInt(1000);
        while(ids.contains(id)){
            id = random.nextInt(1000);
        }

        return id;
    }

    public static int update_logsInsert() throws SQLException {
        query = queryManage.getInsertPreparedQuery08();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);

        id = idGenerator(queryManage.getQuery08());
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

    public static int admin_password_resetsInsert() throws SQLException {
        query = queryManage.getInsertPreparedQuery06();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);

        preparedStatement.setInt(1,106);
        preparedStatement.setString(2,"email33@gmail.com");
        preparedStatement.setString(3,"125478");
        preparedStatement.setInt(4,1);
        rowCount = preparedStatement.executeUpdate();

        return rowCount;
    }
}
