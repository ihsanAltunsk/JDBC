package utilities;

import com.github.javafaker.Faker;
import manage.QueryManage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class InsertIntoMethods {
    static String query, version, updateLog, email, token, loan_number;
    static int id, rowCount, status, supportMessageID, user_id, plan_id, amount;
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
        date = Date.valueOf(LocalDate.now());

        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, version);
        preparedStatement.setString(3, updateLog);
        preparedStatement.setDate(4, date);
        rowCount = preparedStatement.executeUpdate();
        assertEquals(1,rowCount);

        System.out.println("NEW DATA: " + id + " " + version + " " + updateLog + " " + date);

        return id;
    }

    public static int admin_password_resetsInsert() throws SQLException {
        query = queryManage.getInsertPreparedQuery06();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);

        id = idGenerator(queryManage.getQuery06());
        email = faker.internet().emailAddress();
        token = faker.lorem().characters(6);
        status = random.nextInt(0,2);
        date = Date.valueOf(LocalDate.now());

        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, token);
        preparedStatement.setInt(4, status);
        preparedStatement.setDate(5, date);
        rowCount = preparedStatement.executeUpdate();
        assertEquals(1,rowCount);

        System.out.println("NEW DATA: " + id + " " + email + " " + token + " " + status + " " + date);

        return rowCount;
    }
    public static int support_attachmentsInsert() throws SQLException {
        query = queryManage.getInsertPreparedQuery10();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);

        id = idGenerator(queryManage.getQuery10());
        supportMessageID = idGenerator(queryManage.getQuery10());
        date = Date.valueOf(LocalDate.now());

        preparedStatement.setInt(1, id);
        preparedStatement.setInt(2, supportMessageID);
        preparedStatement.setString(3, "658401a61409c1703149990.png");
        preparedStatement.setDate(4, date);
        rowCount = preparedStatement.executeUpdate();
        assertEquals(1, rowCount);

        System.out.println("NEW DATA: " + id + " " + supportMessageID + " 658401a61409c1703149990 " + date);

        return supportMessageID;
    }

    public static String loansInsert() throws SQLException {
        query = queryManage.getPracticeQuery06();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);

        id = idGenerator(queryManage.getPracticeQuery06ID());
        loan_number = faker.regexify("[A-Z]{12}");
        user_id = random.nextInt(100);
        plan_id = random.nextInt(100);
        amount = random.nextInt(1000,10000);

        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, loan_number);
        preparedStatement.setInt(3, user_id);
        preparedStatement.setInt(4, plan_id);
        preparedStatement.setInt(5, amount);
        rowCount = preparedStatement.executeUpdate();
        assertEquals(1, rowCount);

        System.out.println("NEW DATA: " + id + " " + loan_number + " " + user_id + " " + plan_id + " " + amount);

        return loan_number;
    }

}