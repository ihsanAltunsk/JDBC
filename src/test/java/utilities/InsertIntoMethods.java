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
    static String query, version, updateLog, email, token, loan_number, name, description;
    static int id, rowCount, status, supportMessageID, user_id, plan_id, amount, is_app, cron_job_id;
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

        do {
            id = random.nextInt(1000);
        } while (ids.contains(id));
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

        System.out.println("NEW DATA: |" + id + "| |" + version + "| |" + updateLog + "| |" + date + "|");

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

        System.out.println("NEW DATA: |" + id + "| |" + email + "| |" + token + "| |" + status + "| |" + date + "|");

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

        System.out.println("NEW DATA: |" + id + "| |" + supportMessageID + "| |658401a61409c1703149990.png| |" + date + "|");

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

        System.out.println("NEW DATA: |" + id + "| |" + loan_number + "| |" + user_id + "| |" + plan_id + "| |" + amount + "|");

        return loan_number;
    }

    public static void device_tokensInsert() throws SQLException {
        query = queryManage.getPracticeQuery07();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);

        id = idGenerator(queryManage.getPracticeQuery07ID());
        user_id = random.nextInt(10);
        is_app = random.nextInt(10);
        token = faker.lorem().characters(6);
        date = Date.valueOf(LocalDate.now());

        preparedStatement.setInt(1, id);
        preparedStatement.setInt(2, user_id);
        preparedStatement.setInt(3, is_app);
        preparedStatement.setString(4, token);
        preparedStatement.setDate(5, date);
        rowCount = preparedStatement.executeUpdate();
        assertEquals(1, rowCount);

        System.out.println("NEW DATA: |" + id + "| |" + user_id + "| |" + is_app + "| |" + token + "| |" + date + "|");
    }

    public static void cron_job_logsInsert() throws SQLException {
        query = queryManage.getPracticeQuery10();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);

        id = idGenerator(queryManage.getPracticeQuery10ID());
        cron_job_id = random.nextInt(10);
        date = Date.valueOf(LocalDate.now());

        preparedStatement.setInt(1, id);
        preparedStatement.setInt(2, cron_job_id);
        preparedStatement.setDate(3, date);
        rowCount = preparedStatement.executeUpdate();
        assertEquals(1, rowCount);

        System.out.println("NEW DATA: |" + id + "| |" + cron_job_id + "| |" + date + "|");
    }

    public static void categoriesInsert() throws SQLException {
        query = queryManage.getPracticeQuery14();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);

        id = idGenerator(queryManage.getPracticeQuery14ID());
        name = faker.name().fullName();
        description = faker.lorem().sentence(1);

        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, description);
        rowCount = preparedStatement.executeUpdate();
        assertEquals(1, rowCount);

        System.out.println("NEW DATA: |" + id + "| |" + name + "| |" + description + "|");
    }
}
