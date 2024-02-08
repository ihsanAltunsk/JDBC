package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import utilities.JDBCReusableMethods;
import manage.QueryManage;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class stepDefinition {
    String query, version, updateLog, expected, actual;
    int rowCount, id, supportMessageID,expectedN, actualN;
    QueryManage queryManage = new QueryManage();
    ResultSet resultSet;
    PreparedStatement preparedStatement;
    Faker faker= new Faker();
    Random random = new Random();

    @Given("Establish a database connection.")
    public void establish_a_database_connection() {
        JDBCReusableMethods.createConnection();
    }
    @Given("Query01 Prepare and execute the query.")
    public void query01_prepare_and_execute_the_query() throws SQLException {
        query = queryManage.getQuery01();

        // OPTION 1
        query = queryManage.getQuery01();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);

        // OPTION 2
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,100);
        preparedStatement.setInt(2,500);
        resultSet = preparedStatement.executeQuery();
    }
    @Given("ResultSet01 Process the results.")
    public void result_set01_process_the_results() throws SQLException {
        resultSet.next();
        int actualUserID = resultSet.getInt("user_id");
        int expectedUserID = 1;
        assertEquals(expectedUserID, actualUserID);
    }
    @Given("Close the database connection.")
    public void close_the_database_connection() throws SQLException {
        JDBCReusableMethods.closeConnection();
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("Query02 Prepare and execute the query.")
    public void query02_prepare_and_execute_the_query() throws SQLException {
        query = queryManage.getQuery02();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);
    }
    @Given("ResultSet02 Process the results.")
    public void result_set02_process_the_results() throws SQLException {
        List<String> names = new ArrayList<>();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            names.add(name);
        }

        List<String> expectedNames = new ArrayList<>();
        expectedNames.add("5 Minutes");
        expectedNames.add("10 Minutes");

        for (int i = 0; i < names.size(); i++) {
            assertEquals(expectedNames.get(i), names.get(i));
        }
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("Query03 Prepare and execute the query.")
    public void query03_prepare_and_execute_the_query() throws SQLException {
        query = queryManage.getQuery03();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);
    }
    @Given("ResultSet03 Process the results.")
    public void result_set03_process_the_results() throws SQLException {
        String expectedName = "Mehmet Genç";
        resultSet.next();
        String actualName = resultSet.getString("firstname") +
                " " + resultSet.getString("lastname");
        assertEquals(expectedName, actualName);
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("Query04 Prepare and execute the query.")
    public void query04_prepare_and_execute_the_query() throws SQLException {
        query = queryManage.getQuery04();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);
    }
    @Given("ResultSet04 Process the results.")
    public void result_set04_process_the_results() throws SQLException {
        while (resultSet.next()) {
            String user_id = resultSet.getString("user_id");
            String browserOS = resultSet.getString("browser_os");

            System.out.println("User id: " + user_id);
            System.out.println("Browser & OS: " + browserOS);
        }
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("UpdateQuery05 Prepare and execute the query.")
    public void update_query05_prepare_and_execute_the_query() throws SQLException {
        query = queryManage.getUpdateQuery05();
        rowCount = JDBCReusableMethods.getStatement().executeUpdate(query);
        rowCount = JDBCReusableMethods.updateQuery(query);
    }
    @Given("UpdateQuery05 Validate the results.")
    public void update_query05_validate_the_results() {
        assertEquals(18,rowCount);
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("preparedQuery05 Prepare and execute the query.")
    public void prepared_query05_prepare_and_execute_the_query() throws SQLException {
        query = queryManage.getUpdatePreparedQuery05();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, 444444444);
        preparedStatement.setString(2, "%e_");

        rowCount = preparedStatement.executeUpdate();
    }
    @Given("preparedQuery05 Validate the results.")
    public void prepared_query05_validate_the_results() {
        assertEquals(18, rowCount);
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("preparedQuery06 Prepare and execute the query.")
    public void prepared_query06_prepare_and_execute_the_query() throws SQLException {
        query = queryManage.getInsertPreparedQuery06();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);

        // INSERT INTO admin_password_resets (id,email,token,status) VALUES (?,?,?,?);
        preparedStatement.setInt(1,106);
        preparedStatement.setString(2,"email33@gmail.com");
        preparedStatement.setString(3,"125478");
        preparedStatement.setInt(4,1);
        rowCount = preparedStatement.executeUpdate();
    }
    @Given("preparedQuery06 Validate the results.")
    public void prepared_query06_validate_the_results() {
        assertEquals(1, rowCount);
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("preparedQuery07 Prepare and execute the query.")
    public void prepared_query07_prepare_and_execute_the_query() throws SQLException {
    query = queryManage.getUpdatepreparedQuery07();
    preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
    preparedStatement.setInt(1,1);
    preparedStatement.setInt(2,773);
    rowCount = preparedStatement.executeUpdate();
    }
    @Given("preparedQuery07 Validate the results.")
    public void prepared_query07_validate_the_results() {
        assertEquals(1, rowCount);
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("Prepare and execute an insert query for the update_logs table.")
    public void prepare_and_execute_an_insert_query_for_the_table() throws SQLException {
        query = queryManage.getInsertPreparedQuery08();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        id = faker.number().numberBetween(450,550);
        version = faker.options().option("Windows 10", "MacOs Ventura", "Linux");
        updateLog = faker.lorem().sentence(1);

        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, version);
        preparedStatement.setString(3, updateLog);
        preparedStatement.setDate(4, Date.valueOf(LocalDate.now()));

        rowCount = preparedStatement.executeUpdate();

        int flag = 0;
        if (rowCount > 0 ){
            flag++;
        }else {
            System.out.println("UPDATE FAILED!");
        }
        rowCount = 0;
        assertEquals(1,flag);
    }
    @Given("Modify the update log value of the data inserted into the update_logs table.")
    public void modify_the_update_log_value_of_the_data_inserted_into_the_table() throws SQLException {
        query = queryManage.getUpdatePreparedQuery08();
        String updatedLog = "Updated Log";
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setString(1,updatedLog);
        preparedStatement.setString(2,version);
        preparedStatement.setInt(3,id);

        rowCount = preparedStatement.executeUpdate();
    }
    @Given("Confirm the change in the update log value.")
    public void confirm_the_change_in_the_update_log_value() {
        assertEquals(1,rowCount);
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("Delete the data inserted into the update_logs table.")
    public void delete_the_data_inserted_into_the_update_logs_table() throws SQLException {
        query = queryManage.getDeletePreparedQuery09();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,id);

        rowCount = preparedStatement.executeUpdate();
    }
    @Given("Confirm the deletion.")
    public void confirm_the_deletion() {
        assertEquals(1,rowCount);
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("Prepare and execute an insert query for the support_attachments table.")
    public void prepare_and_execute_an_insert_query_for_the_support_attachments_table() throws SQLException {
        query = queryManage.getInsertPreparedQuery10();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        id = faker.number().numberBetween(400,600);
        supportMessageID = faker.number().numberBetween(250,300);

        preparedStatement.setInt(1, id);
        preparedStatement.setInt(2, supportMessageID);
        preparedStatement.setString(3, "658401a61409c1703149990.png");
        preparedStatement.setDate(4, Date.valueOf(LocalDate.now()));

        rowCount = preparedStatement.executeUpdate();
        assertEquals(1,rowCount);
    }
    @Given("Delete the data inserted into the support_attachments table.")
    public void delete_the_data_inserted_into_the_support_attachments_table() throws SQLException {
        query = queryManage.getDeletePreparedQuery10();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,supportMessageID);

        rowCount = preparedStatement.executeUpdate();
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("Prepare and execute the query01.")
    public void prepare_and_execute_the_query01() throws SQLException {
        query = queryManage.getPracticeQuery01();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setString(1,"info@loantechexper.com");
        resultSet = preparedStatement.executeQuery();
    }
    @Given("Process the results for query01.")
    public void process_the_results_for_query01() throws SQLException {
        resultSet.next();
        expected = "1xUgfVUD1Ggx5CVz7mxLvcye8RXRbeFqSktSIkhya321TqDkLOsqhys4pnJv";
        actual = resultSet.getString("remember_token");
        System.out.println("actual: " + actual);
        System.out.println("expected: " + expected);
        assertEquals(expected,actual);
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("Prepare and execute the query02.")
    public void prepare_and_execute_the_query02() throws SQLException {
        query = queryManage.getPracticeQuery02();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,5000);
        preparedStatement.setString(2,"4GC9SMZUS69S");
        resultSet = preparedStatement.executeQuery();
    }
    @Given("Process the results for query02.")
    public void process_the_results_for_query02() throws SQLException {
        resultSet.next();
        expectedN =102;
        actualN = resultSet.getInt("charge");
        System.out.println("actual: " + actual);
        System.out.println("expected: " + expected);
        assertEquals(expected,actual);
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("Prepare and execute the query03.")
    public void prepare_and_execute_the_query03() throws SQLException {
        query = queryManage.getPracticeQuery03();
        int a,d;
        String b;
        String c;
        Date e;
        a = faker.number().numberBetween(0,100);
        b = faker.internet().emailAddress();
        c = faker.lorem().characters(6);
        d = random.nextInt(0,2);
        e = Date.valueOf(LocalDate.now());

        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, a);
        preparedStatement.setString(2, b);
        preparedStatement.setString(3, c);
        preparedStatement.setInt(4, d);
        preparedStatement.setDate(5, e);

        System.out.println(a + "  " + b + "  " + c + "  " + d + "  " + e);
        rowCount = preparedStatement.executeUpdate();
    }
    @Given("Process the results for query03.")
    public void process_the_results_for_query03() {
        assertEquals(1,rowCount);
    }
// ---------------------------------------------------------------------------------------------------------------------

}